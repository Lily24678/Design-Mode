package design_mode.proxy.proxy_dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import design_mode.proxy.proxy_static.DBQuery;
import design_mode.proxy.proxy_static.IDBQuery;

public class JdkDbQueryHandler implements InvocationHandler {
	IDBQuery real = null;// 主题接口

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		if (real == null)
			real = new DBQuery();// 如果是第一次调用，则生成真实对象
		return real.request();// 使用真实主题完成实际的操作
	}


}
