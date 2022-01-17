package web.Favorite.vo;

public class FavoriteVO implements java.io.Serializable{
    private Integer favorite_id;
    private Integer customer_id;
    private Integer product_id;
	public FavoriteVO() {
		super();
	}
	public FavoriteVO(Integer favorite_id, Integer customer_id, Integer product_id) {
		setFavorite_id(favorite_id);
		setCustomer_id(customer_id);
		setProduct_id(product_id);
	}
	public Integer getFavorite_id() {
		return favorite_id;
	}
	public void setFavorite_id(Integer favorite_id) {
		this.favorite_id = favorite_id;
	}
	public Integer getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(Integer customer_id) {
		this.customer_id = customer_id;
	}
	public Integer getProduct_id() {
		return product_id;
	}
	public void setProduct_id(Integer product_id) {
		this.product_id = product_id;
	}
}
