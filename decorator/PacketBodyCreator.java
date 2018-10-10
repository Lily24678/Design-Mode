package design_mode.decorator;
/**
 * 具体组件（被装饰的对象）
 * @author lsy
 * 2018年10月10日上午10:14:07
 */
public class PacketBodyCreator implements IPacketCreator {

	@Override
	public String handleContent() {
		return "Content of Paclet";//构造核心数据，但不包括格式
	}

}
