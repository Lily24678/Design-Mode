package design_mode.GuardedSuspension;

import design_mode.future.hello.FutureData;
import design_mode.future.hello.RealData;

public class ServerThread extends Thread {
	private RequestQueue requestQueue;// 请求队列

	public ServerThread(RequestQueue requestQueue, String name) {
		super(name);
		this.requestQueue = requestQueue;
	}



	@Override
	public void run() {
		while(true) {
			final Request request = requestQueue.getRequest();// 得到请求
			final FutureData future=(FutureData) request.getResponse();
			//Realdata的创建比较耗时
			RealData realData=new RealData(request.getName());
			//处理完成后，通知客户进程
			future.setRealdata(realData);
			System.out.println(Thread.currentThread().getName() + " handles " + request);
		}
		
	}
}
