package design_mode.singleton;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.junit.Test;

import junit.framework.Assert;

public class SingletonTest implements Runnable {
	public static void main(String[] args) {

		// 性能 测试
		for (int i = 0; i < 5; i++) {
			new Thread(new SingletonTest()).start();
		}
	}

	@Test
	public void test1() {

		// 单例类扮演其他角色 的 测试
		Singleton.createString();
		LazySingleton.createString();
		StaticSingleton.createString();
	}

	@SuppressWarnings({ "deprecation", "resource" })
	@Test
	public void test2_SerSingleton() throws Exception {
		SerSingleton s1 = null;
		SerSingleton s = SerSingleton.getInstance();
		// 先将实例串行化到文件
		FileOutputStream fos = new FileOutputStream("F:/temp/SerSingleton.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(s);
		oos.flush();
		oos.close();
		// 从文件读出原有的单例类
		FileInputStream fis = new FileInputStream("F:/temp/SerSingleton.txt");
		ObjectInputStream ois = new ObjectInputStream(fis);
		s1 = (SerSingleton) ois.readObject();

		Assert.assertEquals(s, s1);
	}

	@Override
	public void run() {
		long begintime = System.currentTimeMillis();
		for (int i = 0; i < 1000000; i++)
			// Singleton.getInstance();
			// LazySingleton.getInstance();
			StaticSingleton.getoInstance();
		System.out.println("spend：" + (System.currentTimeMillis() - begintime));
	}

}
