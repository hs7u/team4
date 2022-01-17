package web.Course_Timeable.vo;

import java.sql.Timestamp;

public class Course_TimeableVO implements java.io.Serializable{
    private Integer course_timeable_id;
    private Integer course_id;
    private Timestamp course_date;
	public Course_TimeableVO() {
		super();
	}
	public Course_TimeableVO(Integer course_id, Timestamp course_date) {
		super();
		setCourse_id(course_id);
		setCourse_date(course_date);
	}
	public Integer getCourse_timeable_id() {
		return course_timeable_id;
	}
	public void setCourse_timeable_id(Integer course_timele_id) {
		this.course_timeable_id = course_timele_id;
	}
	public Integer getCourse_id() {
		return course_id;
	}
	public void setCourse_id(Integer course_id) {
		this.course_id = course_id;
	}
	public Timestamp getCourse_date() {
		return course_date;
	}
	public void setCourse_date(Timestamp course_date) {
		this.course_date = course_date;
	}
}
