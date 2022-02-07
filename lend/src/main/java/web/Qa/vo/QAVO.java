package web.Qa.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "QA")
public class QAVO implements java.io.Serializable{
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "qa_id")
	private Integer qaId;
	@Column(name = "reply")
    private String reply;
	@Column(name = "quession")
    private String quession;
	public QAVO() {
		super();
	}
	public Integer getQaId() {
		return qaId;
	}
	public void setQaId(Integer qaId) {
		this.qaId = qaId;
	}
	public String getReply() {
		return reply;
	}
	public void setReply(String reply) {
		this.reply = reply;
	}
	public String getQuession() {
		return quession;
	}
	public void setQuession(String quession) {
		this.quession = quession;
	}
	
}
