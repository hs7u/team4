package web.ProductTag.vo;

public class ProductTagVO implements java.io.Serializable{
    private Integer productCategoryCode;
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
