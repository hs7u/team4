package web.CustomerOrders.vo;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Customer_Orders")
public class CustomerOrdersVO implements java.io.Serializable{
	@Id
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
	@Column(name = "order_status")
	private Byte orderStatus;
	@Column(name = "payment_status")
	private Byte paymentStatus;
	@Column(name = "shipping_status")
	private Byte shippingStatus;
	@Column(name = "return_status")
	private Byte returnStatus;
	public CustomerOrdersVO() {
		super();
	}
	public CustomerOrdersVO(Integer orderId, Integer customerId, Integer shippingMethodCode,
			Timestamp orderCreatedDate, Integer orderDeliveryCharge, Timestamp orderShippingDate, 
			String recipient, String sendersAddress, String orderDetails) {
			setOrderId(orderId);
			setCustomerId(customerId);
			setShippingMethodCode(shippingMethodCode);
			setOrderCreatedDate(orderCreatedDate);
			setOrderDeliveryCharge(orderDeliveryCharge);
			setRecipient(recipient);
			setSendersAddress(sendersAddress);
			setOrderDetails(orderDetails);
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
	public String getRecipint(){
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
