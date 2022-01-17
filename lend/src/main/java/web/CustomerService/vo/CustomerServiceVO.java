package web.CustomerService.vo;

import java.sql.Timestamp;

public class CustomerServiceVO implements java.io.Serializable{
    private Integer messageId;
    private Integer cusotmerId;
    private Timestamp messageTime;
    private String messageTitle;
    private String messageContext;
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
