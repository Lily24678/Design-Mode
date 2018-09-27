package design_mode.producer_consumer;

import java.text.MessageFormat;
import java.util.Random;
import java.util.concurrent.BlockingQueue;

import design_mode.future.hello.Data;

/**
 * 对应的消费者
 * 
 * @author lsy 2018年9月26日下午10:01:08
 */
public class Consumer implements Runnable {
	private BlockingQueue<PCData> queue;// 缓冲区
	private static final int SLEEPTIME = 1000;

	public Consumer(BlockingQueue<PCData> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		System.out.println("start Consumer id=" + Thread.currentThread().getId());
		Random r = new Random();// 随机等待时间
		try {
			while (true) {
				PCData data = queue.take();// 提取任务
				if (null != data) {
					int re = data.getData() * data.getData();// 计算平方
					System.out.println(MessageFormat.format("{0}*{1}={2}", data.getData(), data.getData(), re));
					Thread.sleep(r.nextInt(SLEEPTIME));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			Thread.currentThread().interrupt();
		}
	}

}
