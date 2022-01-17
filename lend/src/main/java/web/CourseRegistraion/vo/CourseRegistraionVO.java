package web.CourseRegistraion.vo;

public class CourseRegistraionVO implements java.io.Serializable{
    private Integer registration_id;
    private Integer customer_id;
    private Integer course_id;
    private Integer course_timeable_id;
    private Integer numOfPeople;
	public CourseRegistraionVO() {
		super();
	}
	public CourseRegistraionVO(Integer registration_id, Integer customer_id, Integer course_id,
			Integer course_timeable_id, Integer numOfPeople) {
		setRegistration_id(registration_id);
		setCustomer_id(customer_id);
		setCourse_id(course_id);
		setCourse_timeable_id(course_timeable_id);
		setNumOfPeople(numOfPeople);
	}
	public Integer getRegistration_id() {
		return registration_id;
	}
	public void setRegistration_id(Integer registration_id) {
		this.registration_id = registration_id;
	}
	public Integer getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(Integer customer_id) {
		this.customer_id = customer_id;
	}
	public Integer getCourse_id() {
		return course_id;
	}
	public void setCourse_id(Integer course_id) {
		this.course_id = course_id;
	}
	public Integer getCourse_timeable_id() {
		return course_timeable_id;
	}
	public void setCourse_timeable_id(Integer course_timeable_id) {
		this.course_timeable_id = course_timeable_id;
	}
	public Integer getNumOfPeople() {
		return numOfPeople;
	}
	public void setNumOfPeople(Integer numOfPeople) {
		this.numOfPeople = numOfPeople;
	}
}
