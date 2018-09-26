package design_mode.GuardedSuspension;

public class Main {

	public static void main(String[] args) {
		RequestQueue requestQueue = new RequestQueue();// 请求队列
		for (int i = 0; i < 10; i++) {
			new ServerThread(requestQueue, "ServerThread" + i).start();// 服务器进程开启
		}
		for (int i = 0; i < 10; i++) {
			new ClientThread(requestQueue, "ClientThread" + i).start();// 请求进程开启
		}
	}

}
