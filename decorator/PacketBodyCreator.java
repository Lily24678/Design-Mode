package design_mode.decorator;

public class PacketBodyCreator implements IPacketCreator {

	@Override
	public String handleContent() {
		return "Content of Paclet";//构造核心数据，但不包括格式
	}

}
