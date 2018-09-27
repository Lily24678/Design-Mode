package design_mode.producer_consumer;

/**
 * PCData作为生产者和消费者之间共享的数据
 * 
 * @author lsy 2018年9月26日下午9:58:54
 */
public class PCData {
	private final int inData;

	public PCData(int d) {
		inData = d;
	}

	public int getData() {
		return inData;
	}

	@Override
	public String toString() {

		return "data" + inData;
	}

}
