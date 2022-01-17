package web.CourseTimeable.vo;

import java.sql.Timestamp;

public class CourseTimeableVO implements java.io.Serializable{
    private Integer courseTimeableId;
    private Integer courseId;
    private Timestamp courseDate;
	public CourseTimeableVO() {
		super();
	}
	public CourseTimeableVO(Integer courseId, Timestamp courseDate) {
		super();
		setCourseId(courseId);
		setCourseDate(courseDate);
	}
	public Integer getCourseTimeableId() {
		return courseTimeableId;
	}
	public void setCourseTimeableId(Integer courseTimeleId) {
		this.courseTimeableId = courseTimeleId;
	}
	public Integer getCourseId() {
		return courseId;
	}
	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}
	public Timestamp getCourseDate() {
		return courseDate;
	}
	public void setCourseDate(Timestamp courseDate) {
		this.courseDate = courseDate;
	}
}
