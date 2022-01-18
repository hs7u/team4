package web.CourseTimeable.vo;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "Course_Timeable")
public class CourseTimeableVO implements java.io.Serializable{
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "course_timeable_id")
	private Integer courseTimeableId;
	@Column(name = "course_id")
    private Integer courseId;
	@Column(name = "course_date")
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
