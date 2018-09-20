package design_mode.valueObject;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class OrderManager extends UnicastRemoteObject implements IOrderManager{

	protected OrderManager() throws RemoteException {
		super();
	}

	@Override
	public Order getOrder(int id) throws RemoteException {
		Order o = new Order();
		o.setClientName("billy");
		o.setNumber(20);
		o.setProductName("desk");
		return o;
	}

	@Override
	public String getClientName(int id) throws RemoteException {
		return "billy";
	}

	@Override
	public String getProdName(int id) throws RemoteException {
		return "desk";
	}

	@Override
	public int getNumber(int id) throws RemoteException {
		return 20;
	}

	

}
