package web.Course.vo;

public enum CourseEnum {
    coursePrice("課程價格 非數字"),
    maxOfCourse("額滿人數 非數字"),
    minOfCourse("開課人數 非數字"),;
    private String type;

	CourseEnum(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
