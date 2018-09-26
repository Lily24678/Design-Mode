package design_mode.future.hello;

/**
 * RealData是最终需要使用的数据模型，它的构造很慢。在这里使用sleep()函数模拟这个构造过程。
 * 
 * @author lishangyun
 * @time 2018年9月26日上午11:19:52
 */
public class RealData implements Data {
	protected final String result;

	public RealData(String para) {
		// Realdata的构造可能很慢，需要用户等很久，这里用sleep()模拟
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < 10; i++) {
			sb.append(para);
			try {
				// 这里使用sleep()代替一个很慢的操作过程
				Thread.sleep(1000);
			} catch (Exception e) {
			}
		}
		result = sb.toString();
	}

	@Override
	public String getResult() {
		return result;
	}

}
