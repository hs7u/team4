package web.Customer.vo;
import java.sql.Date;
import java.sql.Timestamp;
public class CustomerVO implements java.io.Serializable{
	private Integer customer_id;
    private String customer_name;
    private String customer_email;
    private String customer_password;
    private String customer_phone;
    private Date customer_birthday;
    private String customer_gender;
    private String customer_address;
    private Timestamp customer_register_time;
	private Byte customer_status;
    public CustomerVO(){
		
	}
	public CustomerVO(Integer customer_id, String customer_name, String customer_email, String customer_password,
			String customer_phone, Date customer_birthday, String customer_gender, String customer_address,
			Timestamp customer_register_time) {
		setCustomer_id(customer_id);
		setCustomer_name(customer_name);
		setCustomer_email(customer_email);
		setCustomer_password(customer_password);
		setCustomer_phone(customer_phone);
		setCustomer_birthday(customer_birthday);
		setCustomer_gender(customer_gender);
		setCustomer_address(customer_address);
		setCustomer_register_time(customer_register_time);
	}
	public Integer getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(Integer customer_id) {
		this.customer_id = customer_id;
	}
	public String getCustomer_name() {
		return customer_name;
	}
	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}
	public String getCustomer_email() {
		return customer_email;
	}
	public void setCustomer_email(String customer_email) {
		this.customer_email = customer_email;
	}
	public String getCustomer_password() {
		return customer_password;
	}
	public void setCustomer_password(String customer_password) {
		this.customer_password = customer_password;
	}
	public String getCustomer_phone() {
		return customer_phone;
	}
	public void setCustomer_phone(String customer_phone) {
		this.customer_phone = customer_phone;
	}
	public Date getCustomer_birthday() {
		return customer_birthday;
	}
	public void setCustomer_birthday(Date customer_birthday) {
		this.customer_birthday = customer_birthday;
	}
	public String getCustomer_gender() {
		return customer_gender;
	}
	public void setCustomer_gender(String customer_gender) {
		this.customer_gender = customer_gender;
	}
	public String getCustomer_address() {
		return customer_address;
	}
	public void setCustomer_address(String customer_address) {
		this.customer_address = customer_address;
	}
	public Timestamp getCustomer_register_time() {
		return customer_register_time;
	}
	public void setCustomer_register_time(Timestamp customer_register_time) {
		this.customer_register_time = customer_register_time;
	}
	public Byte getCustomer_status(){
		return this.customer_status;
	}
	public void setCustomer_status(Byte customer_status){
		this.customer_status = customer_status;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((customer_name == null) ? 0 : customer_name.hashCode());
		result = prime * result + ((customer_id == null) ? 0 : customer_id);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
			CustomerVO other = (CustomerVO) obj;
		if (customer_email == null) {
			if (other.customer_email != null)
				return false;
		} else if (!customer_email.equals(other.customer_email))
			return false;
		return true;
	}
}
