package design_mode.proxy.proxy_dynamic;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import design_mode.proxy.proxy_static.DBQuery;
import design_mode.proxy.proxy_static.IDBQuery;

public class CglibDbQueryInterceptor implements MethodInterceptor {
	IDBQuery real = null;

	@Override
	public Object intercept(Object arg0, Method arg1, Object[] arg2, MethodProxy arg3) throws Throwable {
		if (real == null)
			real = new DBQuery();
		return real.request();
	}



}
