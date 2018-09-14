package design_mode.singleton;

/**
 * 这种单例的实现方式十分简单，而且十分可靠。它唯一的不足仅是无法对instance实例做延迟加载。假如单例的创建过程很慢，而由于instance成员变量定义的是static定义的，因此在JVM加载单例类时，单例对象就会被建立，如果此时，这个单例类在系统中还扮演其他角色，那么在任何使用这个单例类的地方都会初始化这个单例变量，而不管是否会被用到。
 * 
 * @author lishangyun
 * @time 2018年9月14日上午11:27:39
 */
public class Singleton {
	private static Singleton singleton = new Singleton();

	private Singleton() {
		System.out.println("Singleton is create");
	}

	public static Singleton getInstance() {
		return singleton;
	}

	public static void createString() {// 这是模拟单例类扮演其他角色
		System.out.println("createString in Singleton");
	}
}
