package web.Product.vo;
import java.sql.Timestamp;
public class ProductVO implements java.io.Serializable{
	private Integer productId;
	private Integer productCategoryCode;
	private Integer productPrice;
	private String productName;
	private byte[] productImage;
	private String productDescription;
	private Integer productInventory;
	private Integer productSold;
	private Timestamp releasedTime;
	private Byte customization;
	private Integer customerProductPrice;
	private Byte productStatus;
	public ProductVO() {
		super();
	}
	public ProductVO(Integer productId, Integer productCategoryCode, Integer productPrice, String productName,
			byte[] productImage, String productDescription, Integer productInventory,Timestamp releasedTime, Byte customization, Integer customerProductPrice) {
		setProductId(productId);
		setProductCategoryCode(productCategoryCode);
		setProductPrice(productPrice);
		setProductName(productName);
		setProductImage(productImage);
		setProductDescription(productDescription);
		setProductInventory(productInventory);
		setReleasedTime(releasedTime);
		setCustomization(customization);
		setCustomerProductPrice(customerProductPrice);
	}
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public Integer getProductCategoryCode() {
		return productCategoryCode;
	}
	public void setProductCategoryCode(Integer productCategoryCode) {
		this.productCategoryCode = productCategoryCode;
	}
	public Integer getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(Integer productPrice) {
		this.productPrice = productPrice;
	}
	public String getProductName(){
		return productName;
	}
	public void setProductName(String productName){
		this.productName = productName;
	}
	public byte[] getProductImage(){
		return productImage;
	}
	public void setProductImage(byte[] productImage){
		this.productImage = productImage;
	}
	public String getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	public Integer getProductInventory() {
		return productInventory;
	}
	public void setProductInventory(Integer productInventory) {
		this.productInventory = productInventory;
	}
	public Integer getProductSold() {
		return productSold;
	}
	public void setProductSold(Integer productSold) {
		this.productSold = productSold;
	}
	public Timestamp getReleasedTime() {
		return releasedTime;
	}
	public void setReleasedTime(Timestamp releasedTime) {
		this.releasedTime = releasedTime;
	}
	public void setCustomization(Byte customization){
		this.customization = customization;
	}
	public Byte getCustomization(){
		return customization;
	}
	public void setCustomerProductPrice(Integer customerProductPrice){
		this.customerProductPrice = customerProductPrice;
	}
	public Integer getCustomerProductPrice(){
		return customerProductPrice;
	}
	public void setProductStatus(Byte productStatus) {
		this.productStatus = productStatus;
	}
	public Byte getProductStatus() {
		return productStatus;
	}
}
