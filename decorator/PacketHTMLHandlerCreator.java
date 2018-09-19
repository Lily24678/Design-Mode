package design_mode.decorator;

/**
 * 具体装饰者
 */
public class PacketHTMLHandlerCreator extends PacketDecorator {
	public PacketHTMLHandlerCreator(IPacketCreator c) {
		super(c);
	}

	@Override
	public String handleContent() {//将给定数据封装成HTML
		StringBuffer sb = new StringBuffer();
		sb.append("<html>");
		sb.append("<body>");
		sb.append(component.handleContent());
		sb.append("</body>");
		sb.append("</html>");
		return sb.toString();
	}

}
