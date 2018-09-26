package design_mode.master_worker;
/**
 * Worker对象在应用层的代码如下，如：1~100的立方和
 * @author lishangyun
 * @time 2018年9月26日下午2:43:23
 */
public class PlusWorker extends Worker{

	@Override
	public Object handle(Object input) {//Worker,求立方和
		Integer i=(Integer) input;
		return i*i*i;
	}

}
