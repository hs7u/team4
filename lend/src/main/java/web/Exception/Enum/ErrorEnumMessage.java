package web.Exception.Enum;

public enum ErrorEnumMessage {
    coursePrice("課程價格: 請填數字"),
    maxOfCourse("額滿人數: 請填數字"),
    minOfCourse("開課人數: 請填數字"),
    numOfPeople("報名人數: 請填數字"),
    creditcardNumber("信用卡號: 請填數字"),
    cvvCode("安全碼: 請填數字"),
    productPrice("產品價格: 請填數字"),
    productInventory("產品庫存: 請填數字"),
    customerProductPrice("客製價格: 請填數字"),;
    
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
