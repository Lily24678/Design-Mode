package design_mode.flyweight;

/**
 * 具体享元类
 * 员工个人信息报表
 */
public class EmployeeReportManager implements IReportManager {
	protected String tenantId = null;

	public EmployeeReportManager(String tenantId) {
		this.tenantId = tenantId;
	}

	@Override
	public String createReport() {
		return "This is a employ report";
	}

}
