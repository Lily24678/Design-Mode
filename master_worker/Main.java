package design_mode.master_worker;

import java.util.Map;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		Master m = new Master(new PlusWorker(), 5);// 固定使用5个Worker,并指定Worker
		for (int i = 0; i < 100; i++)
			m.submit(i);// 提交100个子任务
		m.execute();// 开始计算
		int re = 0;// 最终计算结果保存在此

		Map<String, Object> resultMap = m.getResultMap();
		while (resultMap.size() > 0 || !m.isComplete()) {// 不需要等待所以Worker都执行完，即可开始计算最终结果
			Set<String> keys = resultMap.keySet();
			String key = null;
			for (String k : keys) {
				key = k;
				break;

			}
			Integer i = null;
			if (key != null)
				i = (Integer) resultMap.get(key);
			if (i != null)
				re += i;
			if (key != null)
				resultMap.remove(key);// 移除已经被计算的项

		}
		System.out.println(re);

	}

}
