package web.RefShippingCategories.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Ref_Shipping_Categories")
public class RefShippingCategoriesVO implements java.io.Serializable{
	@Id
	@Column(name = "delivery_method_code")
    private Integer shippingMethodCode;
	@Column(name = "delivery_category_description")
    private String shippingCategoryDescription;
	public RefShippingCategoriesVO() {
		super();
	}
	public Integer getShippingMethodCode() {
		return shippingMethodCode;
	}
	public void setShippingMethodCode(Integer shippingMethodCode) {
		this.shippingMethodCode = shippingMethodCode;
	}
	public String getShippingCategoryDescription() {
		return shippingCategoryDescription;
	}
	public void setShippingCategoryDescription(String shippingCategoryDescription) {
		this.shippingCategoryDescription = shippingCategoryDescription;
	}
}
