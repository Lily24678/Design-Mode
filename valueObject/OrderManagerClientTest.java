package design_mode.valueObject;

import java.rmi.Naming;

public class OrderManagerClientTest {
	public static void main(String[] args) {
		try {
			IOrderManager usermanager = (IOrderManager) Naming.lookup("OrderManager");
			long begin = System.currentTimeMillis();
			for (int i = 0; i < 1000; i++) {
				usermanager.getOrder(i);// Value Object 模式
			}
			System.out.println("getOrder spend: " + (System.currentTimeMillis() - begin));

			begin = System.currentTimeMillis();
			for (int i = 0; i < 1000; i++) {
				// 通过多次交互
				usermanager.getClientName(i);
				usermanager.getNumber(i);
				usermanager.getProdName(i);
			}
			System.out.println("3 Method call spend: " + (System.currentTimeMillis() - begin));
			System.out.println(usermanager.getOrder(0).getClientName());
		} catch (Exception e) {
			System.out.println("OrderManager exception: " + e);
		}
	}
}
