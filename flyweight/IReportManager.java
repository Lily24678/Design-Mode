package design_mode.flyweight;
/**
 * 抽象享元
 * 本例中享元对象接口的实现如下，它用于创建一个报表。即，所有的报表生成类将作为享元对象在公司（租户）中共享。
 */
public interface IReportManager {
	public String createReport();
}
