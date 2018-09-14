package design_mode.singleton;

import java.io.Serializable;

/**
 * 一个可被串行化的单例
 * 
 * @author lishangyun
 * @time 2018年9月14日下午2:26:35
 */
public class SerSingleton implements Serializable {
	private static final long serialVersionUID = 1L;
	String name;

	private SerSingleton() {
		System.out.println("SerSingleton is create");
		name = "SerSingleton";
	}

	private static SerSingleton serSingleton = new SerSingleton();

	public static SerSingleton getInstance() {
		return serSingleton;
	}

	public static void createString() {// 这是模拟单例类扮演其他角色
		System.out.println("createString in Singleton");
	}

	/**
	 * 1、如果将readResolve()方法去掉，在反序列化后生成多个实例对象。
	 * 2、有readResolve()方法时，即便经过反序列化，仍然保持了单例的特征。
	 * 3、事实上，在实现私有的readResolve()方法后，ObjectInputStream的readObject()方法已经形同虚设，它直接使用readResolve()替换了原来的返回值，从而在形式上构造了单例。
	 * 
	 * @return
	 */
	private Object readResolve() {// 阻止生成新的实例，总是返回当前对象
		return serSingleton;
	}
}
