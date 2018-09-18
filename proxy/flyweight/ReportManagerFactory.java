package design_mode.flyweight;
/**
 * 核心：享元工厂类。它确保同一个公司（租户）使用相同的对象生成报表。
 */

import java.util.HashMap;
import java.util.Map;

public class ReportManagerFactory {
	Map<String, IReportManager> financialReportManager = new HashMap<>();
	Map<String, IReportManager> employReportManager = new HashMap<>();

	IReportManager getFinancialReportManager(String tenantId) {
		IReportManager r = financialReportManager.get(tenantId);
		if (r == null) {
			r = new FinancialReportManager(tenantId);
			financialReportManager.put(tenantId, r);
		}
		return r;
	}
	IReportManager getEmployReportManager(String tenantId) {
		IReportManager r = employReportManager.get(tenantId);
		if (r == null) {
			r = new EmployeeReportManager(tenantId);
			employReportManager.put(tenantId, r);
		}
		return r;
	}
}
