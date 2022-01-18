package web.ProductTag.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Product_Tag")
public class ProductTagVO implements java.io.Serializable{
    @Id
	@Column(name = "product_category_code")
	private Integer productCategoryCode;
	@Column(name = "product_label_name")
    private String productLabelName;
	public ProductTagVO() {
		super();
	}
	public ProductTagVO(Integer productCategoryCode, String productLabelName) {
		setProductCategoryCode(productCategoryCode);
		setProductLabelName(productLabelName);
	}
	public Integer getProductCategoryCode() {
		return productCategoryCode;
	}
	public void setProductCategoryCode(Integer productCategoryCode) {
		this.productCategoryCode = productCategoryCode;
	}
	public String getProductLabelName() {
		return productLabelName;
	}
	public void setProductLabelName(String productLabelName) {
		this.productLabelName = productLabelName;
	}
}
