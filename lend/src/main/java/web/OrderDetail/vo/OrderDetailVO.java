package web.OrderDetail.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import web.Product.vo.ProductVO;

@Entity
@Table(name = "Customers_OrdersDetails")
@DynamicInsert
@DynamicUpdate
public class OrderDetailVO {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column(name = "orderDetails_id")
	private Integer orderDetailsId;
	@Column(name = "order_id")
	private Integer orderId;
	@Column(name = "product_id", insertable = false, updatable = false)
	private Integer productId;
	@Column(name = "product_price")
	private Integer productPrice;
	@Column(name = "product_quantity")
	private Integer productQuantity;
	@Column(
		name = "customer_upload_img",
		columnDefinition = "mediumblob",
		nullable = true
		)
	private byte[] customerUploadImg;
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "product_id", referencedColumnName = "product_id")
	private ProductVO product;
//	@ManyToOne
//	@JoinColumn(name = "order_id")
//	private CustomerOrdersVO order;
//	public CustomerOrdersVO getOrders(){
//		return order;
//	}
//	public void setOrders(CustomerOrdersVO order){
//		this.order = order;
//	}
	public ProductVO getProduct(){
		return product;
	}
	public void setProduct(ProductVO product){
		this.product = product;
	}
	public Integer getOrderDetailsId() {
		return orderDetailsId;
	}
	public void setOrderDetailsId(Integer orderDetailsId) {
		this.orderDetailsId = orderDetailsId;
	}
	public Integer getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(Integer productPrice) {
		this.productPrice = productPrice;
	}
	public Integer getProductQuantity() {
		return productQuantity;
	}
	public void setProductQuantity(Integer productQuantity) {
		this.productQuantity = productQuantity;
	}
	public byte[] getCustomerUploadImg() {
		return customerUploadImg;
	}
	public void setCustomerUploadImg(byte[] customerUploadImg) {
		this.customerUploadImg = customerUploadImg;
	}
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
}
