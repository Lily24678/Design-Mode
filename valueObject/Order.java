package design_mode.valueObject;

import java.io.Serializable;
/**
 * Value Object
 * @author lishanyun
 * 2018年9月19日下午10:03:11
 */
public class Order implements Serializable {

	private static final long serialVersionUID = 1L;
	private int orderid;
	private String clientName;
	private int number;
	private String productName;

	public int getOrderid() {
		return orderid;
	}

	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

}
