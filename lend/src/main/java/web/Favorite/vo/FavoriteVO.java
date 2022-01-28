package web.Favorite.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "Favorite")
public class FavoriteVO implements java.io.Serializable{
//	@ManyToOne
//	@JoinColumn(
//		name = "customer_id",
//		referencedColumnName = "customer_id"
//	)
//	private CustomerVO cVo;
//	@ManyToOne
//	@JoinColumn(
//		name = "product_id",
//		referencedColumnName = "product_id"
//	)
//	private ProductVO pVo;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "favorite_id")
    private Integer favoriteId;
	@Column(name = "customer_id")
    private Integer customerId;
	@Column(name = "product_id")
    private Integer productId;
	public FavoriteVO() {
		super();
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
//	public CustomerVO getCustomer(){
//		return cVo;
//	}
//	public void setCustomer(CustomerVO cVo){
//		this.cVo = cVo;
//	}
//	public ProductVO getProduct(){
//		return pVo;
//	}
//	public void setProduct(ProductVO pVo){
//		this.pVo = pVo;
//	}
}
