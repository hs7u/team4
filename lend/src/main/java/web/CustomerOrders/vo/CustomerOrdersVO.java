package web.CustomerOrders.vo;
import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.validator.internal.util.stereotypes.Lazy;

import web.OrderDetail.vo.OrderDetailVO;

@Entity
@Table(name = "Customer_Orders")
@DynamicInsert
@DynamicUpdate
public class CustomerOrdersVO implements java.io.Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_id")
	private Integer orderId;
	@Column(name = "customer_id")
	private Integer customerId;
	@Column(name = "shipping_method_code")
    private Integer shippingMethodCode;
	@Column(name = "order_created_date")
    private Timestamp orderCreatedDate;
	@Column(name = "order_delivery_charge")
    private Integer orderDeliveryCharge;
	@Column(name = "order_shipping_date")
	private Timestamp orderShippingDate;
	@Column(name = "recipient")
	private String recipient;
	@Column(name = "senders_address")
	private String sendersAddress;
	@Column(name = "order_detials")
    private String orderDetails;
	@ColumnDefault(value = "0")
	@Column(
		name = "order_status",
		columnDefinition = "bit"
		)
	private Byte orderStatus;
	@ColumnDefault(value = "0")
	@Column(
		name = "payment_status",
		columnDefinition = "bit"
		)
	private Byte paymentStatus;
	@ColumnDefault(value = "0")
	@Column(
		name = "shipping_status",
		columnDefinition = "bit"
		)
	private Byte shippingStatus;
	@ColumnDefault(value = "0")
	@Column(
		name = "return_status",
		columnDefinition = "bit"
		)
	private Byte returnStatus;
	@OneToMany(fetch=FetchType.EAGER , cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "order_id")
	private Set<OrderDetailVO> detail;
	public Set<OrderDetailVO> getDetail(){
		return detail;
	}
	public void setDetail(Set<OrderDetailVO> detail){
		this.detail = detail;
	}
	public CustomerOrdersVO() {
		super();
	}
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	public Integer getShippingMethodCode() {
		return shippingMethodCode;
	}
	public void setShippingMethodCode(Integer shippingMethodCode) {
		this.shippingMethodCode = shippingMethodCode;
	}
	public Timestamp getOrderCreatedDate() {
		return orderCreatedDate;
	}
	public void setOrderCreatedDate(Timestamp orderCreatedDate) {
		this.orderCreatedDate = orderCreatedDate;
	}
	public Integer getOrderDeliveryCharge() {
		return orderDeliveryCharge;
	}
	public void setOrderDeliveryCharge(Integer orderDeliveryCharge) {
		this.orderDeliveryCharge = orderDeliveryCharge;
	}
	public Timestamp getOrderShippingDate(){
		return orderShippingDate;
	}
	public void setOrderShippingDate(Timestamp orderShippingDate){
		this.orderShippingDate = orderShippingDate;
	}
	public String getRecipient(){
		return recipient;
	}
	public void setRecipient(String recipient){
		this.recipient = recipient;
	}
	public String getSendersAddress(){
		return sendersAddress;
	}	
	public void setSendersAddress(String sendersAddress){
		this.sendersAddress = sendersAddress;
	}
	public String getOrderDetails() {
		return orderDetails;
	}
	public void setOrderDetails(String orderDetails) {
		this.orderDetails = orderDetails;
	}
	public Byte getOrderStatus(){
		return orderStatus;
	}
	public void setOrderStatus(Byte orderStatus){
		this.orderStatus = orderStatus;
	}
	public Byte getPaymentStatus(){
		return paymentStatus;
	}
	public void setPaymentStatus(Byte paymentStatus){
		this.paymentStatus = paymentStatus;
	}
	public Byte getShippingStatus(){
		return shippingStatus;
	}
	public void setShippingStatus(Byte shippingStatus){
		this.shippingStatus = shippingStatus;
	}
	public Byte getReturnStatus(){
		return returnStatus;
	}
	public void setReturnStatus(Byte returnStatus){
		this.returnStatus = returnStatus;
	}
}
