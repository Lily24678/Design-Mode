package design_mode.future.hello;

public class FutureData implements Data {
	protected RealData realdata = null;
	protected boolean isReady = false;

	public synchronized void setRealdata(RealData realdata) {
		if (isReady) {
			return;
		}
		this.realdata = realdata;
		isReady = true;// Realdata已经被注入，通知getResult()
		notifyAll();
	}

	@Override
	public synchronized String getResult() {
		while (!isReady) {
			try {
				wait();// 一直等待，直到Realdata被注入
			} catch (Exception e) {
			}
		}
		return realdata.result;
	}

}
