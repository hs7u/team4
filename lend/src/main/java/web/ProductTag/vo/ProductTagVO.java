package web.ProductTag.vo;

public class ProductTagVO implements java.io.Serializable{
    private Integer product_category_code;
    private String product_label_name;
	public ProductTagVO() {
		super();
	}
	public ProductTagVO(Integer product_category_code, String product_label_name) {
		setProduct_category_code(product_category_code);
		setProduct_label_name(product_label_name);
	}
	public Integer getProduct_category_code() {
		return product_category_code;
	}
	public void setProduct_category_code(Integer product_category_code) {
		this.product_category_code = product_category_code;
	}
	public String getProduct_label_name() {
		return product_label_name;
	}
	public void setProduct_label_name(String product_label_name) {
		this.product_label_name = product_label_name;
	}
}
