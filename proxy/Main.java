package design_mode.proxy;

import java.lang.reflect.Proxy;

import org.springframework.cglib.proxy.Enhancer;

import design_mode.proxy.proxy_dynamic.CglibDbQueryInterceptor;
import design_mode.proxy.proxy_dynamic.JavassistDynDbQueryHandler;
import design_mode.proxy.proxy_dynamic.JdkDbQueryHandler;
import design_mode.proxy.proxy_static.DBQuery;
import design_mode.proxy.proxy_static.DBQueryProxy;
import design_mode.proxy.proxy_static.IDBQuery;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtField;
import javassist.CtNewConstructor;
import javassist.CtNewMethod;
import javassist.util.proxy.ProxyFactory;
import javassist.util.proxy.ProxyObject;

public class Main {
	public static final int CIRCLE = 30000000;

	public static void main(String[] args) throws Exception {
		// 静态代理测试
		IDBQuery q = new DBQueryProxy();// 使用代理
		String string = q.request();// 在真正使用时才创建真实对象
		System.out.println(string);

		// 代理的性能测试,去掉DBQuery类中的sleep()代码
		IDBQuery d = null;
		long begin = System.currentTimeMillis();
		d = createJdkProxy();// 测试JDK动态代理
		System.out.println("createJdkProxy：" + (System.currentTimeMillis() - begin));
		System.out.println("JdkProxy class：" + d.getClass().getName());
		begin = System.currentTimeMillis();
		for (int i = 0; i < CIRCLE; i++)
			d.request();
		System.out.println("callJdkProxy：" + (System.currentTimeMillis() - begin));

		begin = System.currentTimeMillis();
		d = createCglibProxy();// 测试CGLIB动态代理
		System.out.println("createCglibProxy：" + (System.currentTimeMillis() - begin));
		System.out.println("CglibProxy class：" + d.getClass().getName());
		begin = System.currentTimeMillis();
		for (int i = 0; i < CIRCLE; i++)
			d.request();
		System.out.println("callCglibProxy：" + (System.currentTimeMillis() - begin));

		begin = System.currentTimeMillis();
		d = createJavassistDynProxy();// 测试Javassist动态代理
		System.out.println("createJavassistDynProxy：" + (System.currentTimeMillis() - begin));
		System.out.println("JavassistDynProxy class：" + d.getClass().getName());
		begin = System.currentTimeMillis();
		for (int i = 0; i < CIRCLE; i++)
			d.request();
		System.out.println("callJavassistDynProxy：" + (System.currentTimeMillis() - begin));

		begin = System.currentTimeMillis();
		d = createJavassistBytecodeDynamicProxy();// 测试Javassist动态代理
		System.out.println("createJavassistBytecodeDynamicProxy：" + (System.currentTimeMillis() - begin));
		System.out.println("JavassistBytecodeDynamicProxy class：" + d.getClass().getName());
		begin = System.currentTimeMillis();
		for (int i = 0; i < CIRCLE; i++)
			d.request();
		System.out.println("callJavassistBytecodeDynamicProxy：" + (System.currentTimeMillis() - begin));

	}

	public static IDBQuery createJdkProxy() {
		IDBQuery jdkProxy = (IDBQuery) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(),
				new Class<?>[] { IDBQuery.class }, new JdkDbQueryHandler());
		return jdkProxy;
	}

	public static IDBQuery createCglibProxy() {
		Enhancer enhancer = new Enhancer();
		enhancer.setCallback(new CglibDbQueryInterceptor());// 指定切入器，定义代理类逻辑
		enhancer.setInterfaces(new Class<?>[] { IDBQuery.class });// 指定实现的接口
		IDBQuery cglibProxy = (IDBQuery) enhancer.create();// 生成代理类的实例
		return cglibProxy;
	}

	// 基于Handler为基础，创建Javassist代理
	public static IDBQuery createJavassistDynProxy() throws Exception {
		ProxyFactory proxyFactory = new ProxyFactory();
		proxyFactory.setInterfaces(new Class<?>[] { IDBQuery.class });// 指定接口
		Class<?> proxyClass = proxyFactory.createClass();
		IDBQuery javassistProxy = (IDBQuery) proxyClass.newInstance();
		((ProxyObject) javassistProxy).setHandler(new JavassistDynDbQueryHandler());
		return javassistProxy;
	}

	public static IDBQuery createJavassistBytecodeDynamicProxy() throws Exception {
		ClassPool mPool = new ClassPool(true);
		// 定义类名
		CtClass mCtc = mPool.makeClass(IDBQuery.class.getName() + "JavassistBytecodeProxy");
		// 需要实现的接口
		mCtc.addInterface(mPool.get(IDBQuery.class.getName()));
		// 添加构造函数
		mCtc.addConstructor(CtNewConstructor.defaultConstructor(mCtc));
		// CtField.make()和CtNewMethod.make()生成代理类的字段和方法
		// 添加类的字段信息，使用动态Java代码
		mCtc.addField(CtField.make("public " + IDBQuery.class.getName() + " real;", mCtc));
		String dbqueryname = DBQuery.class.getName();
		// 添加方法，这里使用动态Java代码指定内部逻辑
		mCtc.addMethod(CtNewMethod.make(
				"public String request() { if(real==null)real=new " + dbqueryname + "();return real.request(); }",
				mCtc));
		// 基于以上信息，生成动态类
		Class<?> pc = mCtc.toClass();
		// 生成动态类的实例
		IDBQuery bytecodeProxy = (IDBQuery) pc.newInstance();
		return bytecodeProxy;
	}

}
