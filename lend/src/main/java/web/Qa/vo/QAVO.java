package web.Qa.vo;

public class QAVO implements java.io.Serializable{
    private Integer qa_id;
    private String answer;
    private String quession;
	public QAVO() {
		super();
	}
	public QAVO(Integer qa_id, String answer, String quession) {
		setQa_id(qa_id);
		setAnswer(answer);
		setQuession(quession);
	}
	public Integer getQa_id() {
		return qa_id;
	}
	public void setQa_id(Integer qa_id) {
		this.qa_id = qa_id;
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
