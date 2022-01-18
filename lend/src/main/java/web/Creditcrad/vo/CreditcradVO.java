package web.Creditcrad.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Creditcard_Info")
public class CreditcradVO implements java.io.Serializable{
	@Id
	@Column(name = "creditcard_number")
    private Integer creditcardNumber;
	@Column(name = "customer_id")
    private Integer customerId;
	@Column(name = "cardholder_name")
    private String cardholderName;
	@Column(name = "cvv_code")
    private String cvvCode;
	@Column(name = "expire_month")
    private String expireMonth;
	@Column(name = "expire_year")
	private String expireYear;
	public CreditcradVO() {
		super();
	}
	public CreditcradVO(Integer creditcardNumber, Integer customerId, String cardholderName, String cvvCode,
				String expireMonth, String expireYear) {
			setCreditcardNumber(creditcardNumber);
			setCustomerId(customerId);
			setCardholderName(cardholderName);
			setCvvCode(cvvCode);
			setExpireMonth(expireMonth);
			setExpireYear(expireYear);
		}
	public Integer getCreditcardNumber() {
		return creditcardNumber;
	}
	public void setCreditcardNumber(Integer creditcardNumber) {
		this.creditcardNumber = creditcardNumber;
	}
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	public String getCardholderName() {
		return cardholderName;
	}
	public void setCardholderName(String cardholderName) {
		this.cardholderName = cardholderName;
	}
	public String getCvvCode() {
		return cvvCode;
	}
	public void setCvvCode(String cvvCode) {
		this.cvvCode = cvvCode;
	}
	public String getExpireMonth() {
		return expireMonth;
	}
	public void setExpireMonth(String expireMonth) {
		this.expireMonth = expireMonth;
	}
	public String getExpireYear() {
		return expireYear;
	}
	public void setExpireYear(String expireYear) {
		this.expireYear = expireYear;
	}
}
