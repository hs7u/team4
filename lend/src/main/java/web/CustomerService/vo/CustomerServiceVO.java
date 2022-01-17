package web.CustomerService.vo;

import java.sql.Timestamp;

public class CustomerServiceVO implements java.io.Serializable{
    private Integer message_id;
    private Integer cusotmer_id;
    private Timestamp message_time;
    private String message_title;
    private String message_context;
    private String reply_context;
	public CustomerServiceVO() {
		super();
	}
	public CustomerServiceVO(Integer message_id, Integer cusotmer_id, Timestamp message_time, String message_title,
			String message_context, String reply_context) {
		setMessage_id(message_id);
        setCusotmer_id(cusotmer_id);
        setMessage_time(message_time);
        setMessage_title(message_title);
        setMessage_context(message_context);
        setReply_context(reply_context);
	}
	public Integer getMessage_id() {
		return message_id;
	}
	public void setMessage_id(Integer message_id) {
		this.message_id = message_id;
	}
	public Integer getCusotmer_id() {
		return cusotmer_id;
	}
	public void setCusotmer_id(Integer cusotmer_id) {
		this.cusotmer_id = cusotmer_id;
	}
	public Timestamp getMessage_time() {
		return message_time;
	}
	public void setMessage_time(Timestamp message_time) {
		this.message_time = message_time;
	}
	public String getMessage_title() {
		return message_title;
	}
	public void setMessage_title(String message_title) {
		this.message_title = message_title;
	}
	public String getMessage_context() {
		return message_context;
	}
	public void setMessage_context(String message_context) {
		this.message_context = message_context;
	}
	public String getReply_context() {
		return reply_context;
	}
	public void setReply_context(String reply_context) {
		this.reply_context = reply_context;
	}
}
