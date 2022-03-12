package web.CourseRegistraion.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import web.Course.vo.CourseVO;
import web.CourseTimeable.vo.CourseTimeableVO;


@Entity
@Table(name = "Course_Registraion")
public class CourseRegistraionVO implements java.io.Serializable{
	@Id
	@Column(name = "registration_id")
    private Integer registrationId;
	@Column(name = "customer_id")
    private Integer customerId;
	@Column(name = "course_id", insertable = false, updatable = false)
    private Integer courseId;
	@Column(name = "course_timeable_id", insertable = false, updatable = false)
    private Integer courseTimeableId;
	@Column(name = "numOfPeople")
    private Integer numOfPeople;
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "course_id", referencedColumnName = "course_id")
	private CourseVO course;
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "course_timeable_id", referencedColumnName = "course_timeable_id")
	private CourseTimeableVO timeable;
	public CourseTimeableVO getTimeable(){
		return timeable;
	}
	public void setTimeable(CourseTimeableVO timeable){
		this.timeable = timeable;
	}
	public CourseVO getCourse(){
		return course;
	}
	public void setCourse(CourseVO course){
		this.course = course;
	}
	public CourseRegistraionVO() {
		super();
	}
	public Integer getRegistrationId() {
		return registrationId;
	}
	public void setRegistrationId(Integer registrationId) {
		this.registrationId = registrationId;
	}
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	public Integer getCourseId() {
		return courseId;
	}
	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}
	public Integer getCourseTimeableId() {
		return courseTimeableId;
	}
	public void setCourseTimeableId(Integer courseTimeableId) {
		this.courseTimeableId = courseTimeableId;
	}
	public Integer getNumOfPeople() {
		return numOfPeople;
	}
	public void setNumOfPeople(Integer numOfPeople) {
		this.numOfPeople = numOfPeople;
	}
}
