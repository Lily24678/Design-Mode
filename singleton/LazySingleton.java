package design_mode.singleton;

/**
 * LazySingleton为了解决Singleton遗留的问题
 * 
 * @author lishangyun
 * @time 2018年9月14日上午11:51:41
 */
public class LazySingleton {
	private static LazySingleton lazySingleton = null;

	private LazySingleton() {
		System.out.println("LazySingleton is create");
	}

	public static LazySingleton getInstance() {

		synchronized (LazySingleton.class) {// 多线程，加入synchronized反而降低了系统性能
			if (lazySingleton == null) {
				lazySingleton = new LazySingleton();
			}
		}

		return lazySingleton;
	}

	public static void createString() {// 这是模拟单例类扮演其他角色
		System.out.println("createString in LazySingleton");
	}
}
