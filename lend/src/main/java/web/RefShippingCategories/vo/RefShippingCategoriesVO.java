package web.RefShippingCategories.vo;

public class RefShippingCategoriesVO implements java.io.Serializable{
    private Integer shippingMethodCode;
    private String shippingCategoryDescription;
	public RefShippingCategoriesVO() {
		super();
	}
	public RefShippingCategoriesVO(Integer shippingMethodCode, String shippingCategoryDescription) {
		setShippingMethodCode(shippingMethodCode);
		setShippingCategoryDescription(shippingCategoryDescription);
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
