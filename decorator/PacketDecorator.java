package design_mode.decorator;
/**
 *装饰者
 */
public abstract class PacketDecorator implements IPacketCreator {
	IPacketCreator component;

	public PacketDecorator(IPacketCreator c) {
		component = c;
	}
}
