package web.Favorite.vo;

public class FavoriteVO implements java.io.Serializable{
    private Integer favoriteId;
    private Integer customerId;
    private Integer productId;
	public FavoriteVO() {
		super();
	}
	public FavoriteVO(Integer favoriteId, Integer customerId, Integer productId) {
		setFavoriteId(favoriteId);
		setCustomerId(customerId);
		setProductId(productId);
	}
	public Integer getFavoriteId() {
		return favoriteId;
	}
	public void setFavoriteId(Integer favoriteId) {
		this.favoriteId = favoriteId;
	}
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
}
