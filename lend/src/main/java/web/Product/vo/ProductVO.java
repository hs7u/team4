package web.Product.vo;
import java.sql.Timestamp;
public class ProductVO implements java.io.Serializable{
	private Integer product_id;
	private Integer product_category_code;
	private Integer product_price;
	private String product_name;
	private byte[] product_image;
	private String product_description;
	private Integer product_inventory;
	private Integer product_sold;
	private Timestamp released_time;
	private Byte customization;
	private Integer customer_product_price;
	private Byte product_status;
	public ProductVO() {
		super();
	}
	public ProductVO(Integer product_id, Integer product_category_code, Integer product_price, String product_name,
			byte[] product_image, String product_description, Integer product_inventory,Timestamp released_time, Byte customization, Integer customer_product_price) {
		setProduct_id(product_id);
		setProduct_category_code(product_category_code);
		setProduct_price(product_price);
		setProduct_name(product_name);
		setProduct_image(product_image);
		setProduct_description(product_description);
		setProduct_inventory(product_inventory);
		setReleased_time(released_time);
		setCustomization(customization);
		setCustomer_product_price(customer_product_price);
	}
	public Integer getProduct_id() {
		return product_id;
	}
	public void setProduct_id(Integer product_id) {
		this.product_id = product_id;
	}
	public Integer getProduct_category_code() {
		return product_category_code;
	}
	public void setProduct_category_code(Integer product_category_code) {
		this.product_category_code = product_category_code;
	}
	public Integer getProduct_price() {
		return product_price;
	}
	public void setProduct_price(Integer product_price) {
		this.product_price = product_price;
	}
	public String getProduct_name(){
		return product_name;
	}
	public void setProduct_name(String product_name){
		this.product_name = product_name;
	}
	public byte[] getProduct_image(){
		return product_image;
	}
	public void setProduct_image(byte[] product_image){
		this.product_image = product_image;
	}
	public String getProduct_description() {
		return product_description;
	}
	public void setProduct_description(String product_description) {
		this.product_description = product_description;
	}
	public Integer getProduct_inventory() {
		return product_inventory;
	}
	public void setProduct_inventory(Integer product_inventory) {
		this.product_inventory = product_inventory;
	}
	public Integer getProduct_sold() {
		return product_sold;
	}
	public void setProduct_sold(Integer product_sold) {
		this.product_sold = product_sold;
	}
	public Timestamp getReleased_time() {
		return released_time;
	}
	public void setReleased_time(Timestamp released_time) {
		this.released_time = released_time;
	}
	public void setCustomization(Byte customization){
		this.customization = customization;
	}
	public Byte getCustomization(){
		return customization;
	}
	public void setCustomer_product_price(Integer customer_product_price){
		this.customer_product_price = customer_product_price;
	}
	public Integer getCustomer_product_price(){
		return customer_product_price;
	}
	public void setProduct_status(Byte product_status) {
		this.product_status = product_status;
	}
	public Byte getProduct_status() {
		return product_status;
	}
}
