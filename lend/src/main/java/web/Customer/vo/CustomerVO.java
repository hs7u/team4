package web.Customer.vo;
import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "Customer")
public class CustomerVO implements java.io.Serializable{
	@Id
	@Column(name = "customer_id")
	private Integer customerId;
	@Column(name = "customer_name")
    private String customerName;
	@Column(name = "customer_email")
    private String customerEmail;
	@Column(name = "customer_password")
    private String customerPassword;
	@Column(name = "customer_phone")
    private String customerPhone;
	@Column(name = "customer_birthday")
    private Date customerBirthday;
	@Column(name = "customer_gender")
    private String customerGender;
	@Column(name = "customer_address")
    private String customerAddress;
	@Column(name = "customer_register_time")
    private Timestamp customerRegisterTime;
	@Column(name = "customer_status")
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
