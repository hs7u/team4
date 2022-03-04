package web.Exception.Enum;

public enum ErrorEnumMessage {
    coursePrice("課程價格 非數字"),
    maxOfCourse("額滿人數 非數字"),
    minOfCourse("開課人數 非數字"),
    numOfPeople("報名人數 非數字"),
    creditcardNumber("信用卡號 非數字"),
    cvvCode("安全碼 非數字"),;
    
	private String type;

	ErrorEnumMessage(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
