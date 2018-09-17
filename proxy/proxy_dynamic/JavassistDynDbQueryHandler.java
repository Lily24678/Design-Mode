package design_mode.proxy.proxy_dynamic;

import java.lang.reflect.Method;

import design_mode.proxy.proxy_static.DBQuery;
import design_mode.proxy.proxy_static.IDBQuery;
import javassist.util.proxy.MethodHandler;

public class JavassistDynDbQueryHandler implements MethodHandler {
	IDBQuery real = null;

	@Override
	public Object invoke(Object arg0, Method arg1, Method arg2, Object[] arg3) throws Throwable {
		if (real == null)
			real = new DBQuery();
		return real.request();
	}

	
}
