package web.RefProductTag.vo;

public class RefProductTagVO implements java.io.Serializable{
    private Integer serialNumber; 
    private Integer productCategoryCode; 
    private Integer productId;
	public RefProductTagVO() {
		super();
	}
	public RefProductTagVO(Integer serialNumber, Integer productCategoryCode, Integer productId) {
		setSerialNumber(serialNumber);
		setProductCategoryCode(productCategoryCode);
		setProductId(productId);
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
