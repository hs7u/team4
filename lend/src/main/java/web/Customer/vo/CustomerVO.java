package web.Customer.vo;
import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name = "Customer")
@DynamicInsert
@DynamicUpdate
public class CustomerVO implements java.io.Serializable{
//	@OneToMany(mappedBy = "Favorite",cascade = CascadeType.REMOVE)
//	private Set<FavoriteVO> fVos;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
	@ColumnDefault(value = "0")
	@Column(
			name = "customer_status",
			columnDefinition = "bit"
			)
	private Byte customerStatus;
    public CustomerVO(){
		
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
//	public Set<FavoriteVO> getfavorites(){
//		return fVos;
//	}
//	public void setFavorites(Set<FavoriteVO> fVos){
//		this.fVos = fVos;
//	}
}
