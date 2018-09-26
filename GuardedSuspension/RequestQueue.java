package design_mode.GuardedSuspension;

import java.util.LinkedList;

public class RequestQueue {
	private LinkedList<Request> queue = new LinkedList<>();

	public synchronized Request getRequest() {
		while (queue.size() == 0) {
			try {
				wait();// 等待直到有新的Request加入
			} catch (Exception e) {
			}

		}
		return (Request) queue.remove();// 返回Request队列的第一个请求
	}

	public synchronized void addRequest(Request request) {
		queue.add(request);// 加入新的Request请求
		notifyAll();// 通知getRequest()方发发发
	}
}
