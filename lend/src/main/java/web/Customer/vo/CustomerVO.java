package web.Customer.vo;
import java.sql.Date;
import java.sql.Timestamp;
public class CustomerVO implements java.io.Serializable{
	private Integer customerId;
    private String customerName;
    private String customerEmail;
    private String customerPassword;
    private String customerPhone;
    private Date customerBirthday;
    private String customerGender;
    private String customerAddress;
    private Timestamp customerRegisterTime;
	private Byte customerStatus;
    public CustomerVO(){
		
	}
	public CustomerVO(Integer customerId, String customerName, String customerEmail, String customerPassword,
			String customerPhone, Date customerBirthday, String customerGender, String customerAddress,
			Timestamp customerRegisterTime) {
		setCustomerId(customerId);
		setCustomerName(customerName);
		setCustomerEmail(customerEmail);
		setCustomerPassword(customerPassword);
		setCustomerPhone(customerPhone);
		setCustomerBirthday(customerBirthday);
		setCustomerGender(customerGender);
		setCustomerAddress(customerAddress);
		setCustomerRegisterTime(customerRegisterTime);
	}
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerEmail() {
		return customerEmail;
	}
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}
	public String getCustomerPassword() {
		return customerPassword;
	}
	public void setCustomerPassword(String customerPassword) {
		this.customerPassword = customerPassword;
	}
	public String getCustomerPhone() {
		return customerPhone;
	}
	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}
	public Date getCustomerBirthday() {
		return customerBirthday;
	}
	public void setCustomerBirthday(Date customerBirthday) {
		this.customerBirthday = customerBirthday;
	}
	public String getCustomerGender() {
		return customerGender;
	}
	public void setCustomerGender(String customerGender) {
		this.customerGender = customerGender;
	}
	public String getCustomerAddress() {
		return customerAddress;
	}
	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}
	public Timestamp getCustomerRegisterTime() {
		return customerRegisterTime;
	}
	public void setCustomerRegisterTime(Timestamp customerRegisterTime) {
		this.customerRegisterTime = customerRegisterTime;
	}
	public Byte getCustomerStatus(){
		return customerStatus;
	}
	public void setCustomerStatus(Byte customerStatus){
		this.customerStatus = customerStatus;
	}
}
