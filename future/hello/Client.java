package design_mode.future.hello;
/**
 * Client主要实现了获取FutureData，开启构造RealData的线程，并接受请求胡，很快的返回Futuredata
 * FutureData是future模式的关键，它实际上市真实数据Realdata的代理，封装了获取Realdata的等待过程。
 * @author lishangyun
 * @time 2018年9月26日下午12:03:06
 */
public class Client {

	public Data request(final String queryStr) {
		final FutureData future = new FutureData();
		// Realdata的构建很慢，所以在单独的线程中进行。
		new Thread() {
			@Override
			public void run() {
				RealData realData = new RealData(queryStr);
				future.setRealdata(realData);
			}
		}.start();
		return future;
	}
}
