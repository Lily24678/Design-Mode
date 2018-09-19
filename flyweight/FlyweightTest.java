package design_mode.flyweight;

/**
 * ReportManagerFactory作为享元工厂，以租客ID为索引，维护了一个享元对象的集合，它确保相同租客的请求都返回同一个享元实例，确保享元对象的有效复用。
 */
public class FlyweightTest {
	public static void main(String[] args) {
		ReportManagerFactory rmf = new ReportManagerFactory();
		IReportManager rm = rmf.getFinancialReportManager("A");
		System.out.println(rm.createReport());
	}
}
