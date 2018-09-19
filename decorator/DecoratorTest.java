package design_mode.decorator;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 对于装饰者模式，另一个值得关注的地方就是它的使用方法。在本例中，通过层层构造和组装这些装饰者到一个对象中，使其有机地结合在一起工作。
 */
public class DecoratorTest {
	public static void main(String[] args) throws IOException {
		IPacketCreator pc = new PacketHTTPCreator(new PacketHTMLHandlerCreator(new PacketBodyCreator()));
		pc.handleContent();
		System.out.println(pc.handleContent());

		// 以 OutputStream为例
		// 生成一个有缓冲功能的流对象
		DataOutputStream dout = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("F:/temp/a.txt")));
		// 没有缓冲功能的流对象
		// DataOutputStream dout = new DataOutputStream(new FileOutputStream("F:/temp/a.txt"));
		long begin = System.currentTimeMillis();
		for (int i = 0; i < 100000; i++)
			dout.writeLong(i);
		System.out.println("spend:" + (System.currentTimeMillis() - begin));
	}
}
