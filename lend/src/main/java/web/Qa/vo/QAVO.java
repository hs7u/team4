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
	@Column(name = "answer")
    private String answer;
	@Column(name = "quession")
    private String quession;
	public QAVO() {
		super();
	}
	public QAVO(Integer qaId, String answer, String quession) {
		setQaId(qaId);
		setAnswer(answer);
		setQuession(quession);
	}
	public Integer getQaId() {
		return qaId;
	}
	public void setQaId(Integer qaId) {
		this.qaId = qaId;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public String getQuession() {
		return quession;
	}
	public void setQuession(String quession) {
		this.quession = quession;
	}
	
}
