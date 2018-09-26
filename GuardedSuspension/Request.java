package design_mode.GuardedSuspension;

import design_mode.future.hello.Data;

public class Request {
	private String name;
	private Data response;


	public synchronized Data getResponse() {
		return response;
	}

	public synchronized void setResponse(Data response) {
		this.response = response;
	}

	public Request(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "[ Request " + name + " ]";
	}
}
