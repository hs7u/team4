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
	@Column(name = "product_tag_name")
    private String productTagName;
	public ProductTagVO() {
		super();
	}
	public Integer getProductCategoryCode() {
		return productCategoryCode;
	}
	public void setProductCategoryCode(Integer productCategoryCode) {
		this.productCategoryCode = productCategoryCode;
	}
	public String getProductTagName() {
		return productTagName;
	}
	public void setProductTagName(String productTagName) {
		this.productTagName = productTagName;
	}
}
