package web.CustomerOrders.vo;
import java.sql.Timestamp;
public class CustomerOrdersVO implements java.io.Serializable{
	private Integer order_id;
	private Integer customer_id;
    private Integer shipping_mothod_code;
    private Timestamp order_created_date;
    private Integer order_delivery_charge;
	private Timestamp order_shipping_date;
	private String recipient;
	private String senders_address;
    private String order_details;
	private Byte order_status;
	private Byte payment_status;
	private Byte shipping_status;
	private Byte return_status;
	public CustomerOrdersVO() {
		super();
	}
	public CustomerOrdersVO(Integer order_id, Integer customer_id, Integer shipping_mothod_code,
			Timestamp order_created_date, Integer order_delivery_charge, Timestamp order_shipping_date, 
			String recipient, String senders_address, String order_details) {
			setOrder_id(order_id);
			setCustomer_id(customer_id);
			setShipping_mothod_code(shipping_mothod_code);
			setOrder_created_date(order_created_date);
			setOrder_delivery_charge(order_delivery_charge);
			setRecipient(recipient);
			setSenders_address(senders_address);
			setOrder_details(order_details);
	}
	public Integer getOrder_id() {
		return order_id;
	}
	public void setOrder_id(Integer order_id) {
		this.order_id = order_id;
	}
	public Integer getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(Integer customer_id) {
		this.customer_id = customer_id;
	}
	public Integer getShipping_mothod_code() {
		return shipping_mothod_code;
	}
	public void setShipping_mothod_code(Integer shipping_mothod_code) {
		this.shipping_mothod_code = shipping_mothod_code;
	}
	public Timestamp getOrder_created_date() {
		return order_created_date;
	}
	public void setOrder_created_date(Timestamp order_created_date) {
		this.order_created_date = order_created_date;
	}
	public Integer getOrder_delivery_charge() {
		return order_delivery_charge;
	}
	public void setOrder_delivery_charge(Integer order_delivery_charge) {
		this.order_delivery_charge = order_delivery_charge;
	}
	public void setOrder_shipping_date(Timestamp order_shipping_date){
		this.order_shipping_date = order_shipping_date;
	}
	public Timestamp getOrder_shipping_date(){
		return order_shipping_date;
	}
	public String getRecipint(){
		return this.recipient;
	}
	public void setRecipient(String recipient){
		this.recipient = recipient;
	}
	public String getSenders_address(){
		return this.senders_address;
	}	
	public void setSenders_address(String senders_address){
		this.senders_address = senders_address;
	}
	public String getOrder_details() {
		return order_details;
	}
	public void setOrder_details(String order_details) {
		this.order_details = order_details;
	}
	public Byte getOrder_status(){
		return this.order_status;
	}
	public void setOrder_status(Byte order_status){
		this.order_status = order_status;
	}
	public Byte getPayment_status(){
		return this.payment_status;
	}
	public void setPayment_status(Byte payment_status){
		this.payment_status = payment_status;
	}
	public Byte getShipping_status(){
		return this.shipping_status;
	}
	public void setShipping_status(Byte shipping_status){
		this.shipping_status = shipping_status;
	}
	public Byte getReturn_status(){
		return this.return_status;
	}
	public void setReturn_status(Byte return_status){
		this.return_status = return_status;
	}
}
