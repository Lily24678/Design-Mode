package design_mode.proxy.proxy_static;

//真实主题
public class DBQuery implements IDBQuery {
	public DBQuery() {
		try {
			Thread.sleep(1000);//可能包含数据库连接等耗时操作
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	@Override
	public String request() {
		return "request string";
	}

}
