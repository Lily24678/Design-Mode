package design_mode.future.hello;
/**
 * main()函数主要负责调用Client发起请求，并使用返回的数据。
 * @author lishangyun
 * @time 2018年9月26日上午11:56:05
 */
public class Main {
	public static void main(String[] args) {
		Client client = new Client();
		Data data = client.request("name");
		System.out.println("请求完毕");
		try {
			// 之力可以用一个sleep()代替对其他业务逻辑的处理，在处理这些业务逻辑中，Realdata被创建，从而充分利用等待时间
			Thread.sleep(10000);
		} catch (Exception e) {
		}
		// 使用真实数据
		System.out.println("数据 = " + data.getResult());
	}
}
