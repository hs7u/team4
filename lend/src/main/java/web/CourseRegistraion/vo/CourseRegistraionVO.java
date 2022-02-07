package web.CourseRegistraion.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Course_Registraion")
public class CourseRegistraionVO implements java.io.Serializable{
	@Id
	@Column(name = "registration_id")
    private Integer registrationId;
	@Column(name = "customer_id")
    private Integer customerId;
	@Column(name = "course_id")
    private Integer courseId;
	@Column(name = "course_timeble_id")
    private Integer courseTimeableId;
	@Column(name = "numOfPeople")
    private Integer numOfPeople;
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
