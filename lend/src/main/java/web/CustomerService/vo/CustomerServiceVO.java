package web.CustomerService.vo;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "Customer_Service")
public class CustomerServiceVO implements java.io.Serializable{
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cusotmer_id")
	private Integer messageId;
	@Column(name = "message_id")
    private Integer cusotmerId;
	@Column(name = "message_time")
    private Timestamp messageTime;
	@Column(name = "message_title")
    private String messageTitle;
	@Column(name = "message_context")
    private String messageContext;
	@Column(name = "reply_context")
    private String replyContext;
	public CustomerServiceVO() {
		super();
	}
	public CustomerServiceVO(Integer messageId, Integer cusotmerId, Timestamp messageTime, String messageTitle,
			String messageContext, String replyContext) {
		setMessageId(messageId);
        setCusotmerId(cusotmerId);
        setMessageTime(messageTime);
        setMessageTitle(messageTitle);
        setMessageContext(messageContext);
        setReplyContext(replyContext);
	}
	public Integer getMessageId() {
		return messageId;
	}
	public void setMessageId(Integer messageId) {
		this.messageId = messageId;
	}
	public Integer getCusotmerId() {
		return cusotmerId;
	}
	public void setCusotmerId(Integer cusotmerId) {
		this.cusotmerId = cusotmerId;
	}
	public Timestamp getMessageTime() {
		return messageTime;
	}
	public void setMessageTime(Timestamp messageTime) {
		this.messageTime = messageTime;
	}
	public String getMessageTitle() {
		return messageTitle;
	}
	public void setMessageTitle(String messageTitle) {
		this.messageTitle = messageTitle;
	}
	public String getMessageContext() {
		return messageContext;
	}
	public void setMessageContext(String messageContext) {
		this.messageContext = messageContext;
	}
	public String getReplyContext() {
		return replyContext;
	}
	public void setReplyContext(String replyContext) {
		this.replyContext = replyContext;
	}
}
