package design_mode.decorator;

/**
 * 具体装饰者
 */
public class PacketHTTPCreator extends PacketDecorator {
	public PacketHTTPCreator(IPacketCreator c) {
		super(c);
	}

	@Override
	public String handleContent() {// 对给定数据加上HTTP头信息
		StringBuffer sb = new StringBuffer();
		sb.append("Cache-Control:non-cache\n");
		sb.append("Date:Mon,31Dec201204:25:57\n");
		sb.append(component.handleContent());
		return sb.toString();
	}
}
