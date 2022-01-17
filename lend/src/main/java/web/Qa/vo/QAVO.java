package web.Qa.vo;

public class QAVO implements java.io.Serializable{
    private Integer qaId;
    private String answer;
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
