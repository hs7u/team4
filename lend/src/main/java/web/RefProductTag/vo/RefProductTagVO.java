package web.RefProductTag.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Ref_Product_Tag")
public class RefProductTagVO implements java.io.Serializable{
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "serial_number")
	private Integer serialNumber; 
	@Column(name = "product_category_code")
    private Integer productCategoryCode; 
	@Column(name = "product_id")
    private Integer productId;
	public RefProductTagVO() {
		super();
	}
	public Integer getSerialNumber() {
		return serialNumber;
	}
	public void setSerialNumber(Integer serialNumber) {
		this.serialNumber = serialNumber;
	}
	public Integer getProductCategoryCode() {
		return productCategoryCode;
	}
	public void setProductCategoryCode(Integer productCategoryCode) {
		this.productCategoryCode = productCategoryCode;
	}
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	} 
}
