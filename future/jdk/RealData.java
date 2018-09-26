package design_mode.future.jdk;

import java.util.concurrent.Callable;

/**
 * {@link Callable}接口是一个用户自定义的实现。通过实现Callable接口的call()方法，指定FutureTask的实际工作内容和返回对象。
 * 
 * @author lishangyun
 * @time 2018年9月26日下午1:15:36
 */
public class RealData implements Callable<String> {
	private String para;

	public RealData(String para) {
		this.para = para;
	}

	@Override
	public String call() throws Exception {
		// 这里是真实的业务逻辑，去其执行可能很慢
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < 10; i++) {
			sb.append(para);
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
			}
		}
		return sb.toString();
	}

}
