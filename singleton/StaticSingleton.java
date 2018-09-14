package design_mode.singleton;

/**
 * StaticSingleton解决LazySingleton遗留的问题。
 * 单例模式使用内部类维护单例的实例，当StaticSingleton被加载时，其内部类并不会被初始化，故可以确保当StaticSingleton类被载入JVM时，不会初始化单例类，而当getInstance()方法被调用时，才会加载SingletonHolder，从而初始化instance。同时，由于实例的创建是在类加载时完成，故天生对多线程友好。
 * 
 * @author lishangyun
 * @time 2018年9月14日下午2:03:53
 */
public class StaticSingleton {
	private StaticSingleton() {
		System.out.println("StaticSingleton is create");
	}

	private static class SingletonHolder {
		private static StaticSingleton instance = new StaticSingleton();
	}

	public static StaticSingleton getoInstance() {
		return SingletonHolder.instance;
	}
	
	public static void createString() {// 这是模拟单例类扮演其他角色
		System.out.println("createString in StaticSingleton");
	}
}
