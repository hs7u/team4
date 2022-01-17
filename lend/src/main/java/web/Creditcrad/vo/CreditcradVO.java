package web.Creditcrad.vo;

public class CreditcradVO implements java.io.Serializable{
    private Integer creditcard_number;
    private Integer customer_id;
    private String cardholder_name;
    private String cvv_code;
    private String expire_month;
	private String expire_year;
	public CreditcradVO() {
		super();
	}
	public CreditcradVO(Integer creditcard_number, Integer customer_id, String cardholder_name, String cvv_code,
				String expire_month, String expire_year) {
			setCreditcard_number(creditcard_number);
			setCustomer_id(customer_id);
			setCardholder_name(cardholder_name);
			setCvv_code(cvv_code);
			setExpire_month(expire_month);
			setExpire_year(expire_year);
		}
	public Integer getCreditcard_number() {
		return creditcard_number;
	}
	public void setCreditcard_number(Integer creditcard_number) {
		this.creditcard_number = creditcard_number;
	}
	public Integer getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(Integer customer_id) {
		this.customer_id = customer_id;
	}
	public String getCardholder_name() {
		return cardholder_name;
	}
	public void setCardholder_name(String cardholder_name) {
		this.cardholder_name = cardholder_name;
	}
	public String getCvv_code() {
		return cvv_code;
	}
	public void setCvv_code(String cvv_code) {
		this.cvv_code = cvv_code;
	}
	public String getExpire_month() {
		return expire_month;
	}
	public void setExpire_month(String expire_month) {
		this.expire_month = expire_month;
	}
	public String getExpire_year() {
		return expire_year;
	}
	public void setExpire_year(String expire_year) {
		this.expire_year = expire_year;
	}
}
