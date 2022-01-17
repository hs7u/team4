package web.Ref_ProductTag.vo;

public class Ref_ProductTagVO implements java.io.Serializable{
    private Integer serial_number; 
    private Integer product_category_code; 
    private Integer product_id;
	public Ref_ProductTagVO() {
		super();
	}
	public Ref_ProductTagVO(Integer serial_number, Integer product_category_code, Integer product_id) {
		setSerial_number(serial_number);
		setProduct_category_code(product_category_code);
		setProduct_id(product_id);
	}
	public Integer getSerial_number() {
		return serial_number;
	}
	public void setSerial_number(Integer serial_number) {
		this.serial_number = serial_number;
	}
	public Integer getProduct_category_code() {
		return product_category_code;
	}
	public void setProduct_category_code(Integer product_category_code) {
		this.product_category_code = product_category_code;
	}
	public Integer getProduct_id() {
		return product_id;
	}
	public void setProduct_id(Integer product_id) {
		this.product_id = product_id;
	} 
}
