package web.Admin.vo;

public class AdminVO implements java.io.Serializable{
    private Integer adminId;
    private String adminAccount;
    private String adminPassword;
    private String permission;
	public AdminVO() {
		super();
	}
	public AdminVO(Integer adminId, String adminAccount, String adminPassword, String permission) {
		setAdminId(adminId);
		setAdminAccount(adminAccount);
		setAdminPassword(adminPassword);
		setPermission(permission);
	}
	public Integer getAdminId() {
		return adminId;
	}
	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}
	public String getAdminAccount() {
		return adminAccount;
	}
	public void setAdminAccount(String adminAccount) {
		this.adminAccount = adminAccount;
	}
	public String getAdminPassword() {
		return adminPassword;
	}
	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}
	public String getPermission() {
		return permission;
	}
	public void setPermission(String permission) {
		this.permission = permission;
	}
}
