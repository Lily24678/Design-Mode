package design_mode.GuardedSuspension;

import java.util.ArrayList;
import java.util.List;

import design_mode.future.hello.FutureData;

public class ClientThread extends Thread {
	private RequestQueue requestQueue;// 请求队列
	private List<Request> myRequest = new ArrayList<>();

	public ClientThread(RequestQueue requestQueue, String name) {
		super(name);
		this.requestQueue = requestQueue;
	}

	@Override
	public void run() {
		// 先提出请求
		for (int i = 0; i < 10; i++) {
			Request request = new Request("RequestID: " + i + " Thread_Name: " + Thread.currentThread().getName());// 构造请求
			System.out.println(Thread.currentThread().getName() + " requests " + request);
			// 设置一个FutureData的返回值
			request.setResponse(new FutureData());
			requestQueue.addRequest(request);// 提交请求
			// 发送请求
			myRequest.add(request);
			// 这里可以做一些额外的业务处理，等待服务端装配数据
			try {
				Thread.sleep(1000);// 客户端请求的速度快于服务端处理的速度
			} catch (Exception e) {
			}
			// 取得服务端的返回数值
			for (Request r : myRequest) {

				System.out.println("ClientThread Name is: " + Thread.currentThread().getName() + " Response is: "
						+ r.getResponse().getResult());// r.getResponse().getResult()如果服务器还没处理完，这里会等待
			}
		}
	}
}
