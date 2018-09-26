package design_mode.future.jdk;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * 由于使用JDK的内置框架，Data、FutureData等对象就不需要了。在Main方法的实现中，直接通过RealData构造FutureTask，并将其作为单独的线程运行。在提交请求后，执行其他业务逻辑，最后通过FutureTask.get()方法，的到RealData的执行结果。
 * 
 * @author lishangyun
 * @time 2018年9月26日下午1:18:35
 */
public class Main {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		// 构造FutureTask
		FutureTask<String> future = new FutureTask<>(new RealData("a"));
		ExecutorService executor = Executors.newFixedThreadPool(1);
		// 执行FutureTask，相当于上例中的client.request("a")发送请求，在这里开启线程进行Realdata的call()执行
		executor.submit(future);
		System.out.println("请求完毕");
		try {
			// 之力可以用一个sleep()代替对其他业务逻辑的处理，在处理这些业务逻辑中，Realdata被创建，从而充分利用等待时间
			Thread.sleep(10000);
		} catch (Exception e) {
		}
		// 相当于上例中的data.getResult()，取得call()方法的返回值，如果此时call()方法没有执行完成，则依然会等待
		System.out.println("数据 = " + future.get());

	}

}
