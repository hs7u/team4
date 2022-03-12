package web.Product.vo;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name = "Product")
@DynamicInsert
@DynamicUpdate
public class ProductVO implements java.io.Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_id")
	private Integer productId;
	@Column(name = "product_category_code")
	private Integer productCategoryCode;
	@Column(name = "product_price")
	private Integer productPrice;
	@Column(name = "product_name")
	private String productName;
	@Column(
			name = "product_image",
			columnDefinition = "mediumblob"
			)
	private byte[] productImage;
	@Column(name = "product_description")
	private String productDescription;
	@Column(name = "product_inventory")
	private Integer productInventory;
	@Column(name = "product_sold")
	private Integer productSold;
	@Column(name = "released_time")
	private Timestamp releasedTime;
	@ColumnDefault(value = "0")
	@Column(
			name = "customization",
			columnDefinition = "bit"
			)
	private Byte customization;
	@Column(name = "custom_product_price")
	private Integer customerProductPrice;
	@ColumnDefault(value = "0")
	@Column(
			name = "product_status",
			columnDefinition = "bit"
			)
	private Byte productStatus;
//	@OneToMany(fetch=FetchType.EAGER)
//	@JoinColumn(name = "product_id")
//	private Set<OrderDetailVO> detail;
//	public Set<OrderDetailVO> getDetail(){
//		return detail;
//	}
//	public void setDetail(Set<OrderDetailVO> detail){
//		this.detail = detail;
//	}
	public ProductVO() {
		super();
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
