package web.CourseRegistraion.vo;

public class CourseRegistraionVO implements java.io.Serializable{
    private Integer registrationId;
    private Integer customerId;
    private Integer courseId;
    private Integer courseTimeableId;
    private Integer numOfPeople;
	public CourseRegistraionVO() {
		super();
	}
	public CourseRegistraionVO(Integer registrationId, Integer customerId, Integer courseId,
			Integer courseTimeableId, Integer numOfPeople) {
		setRegistrationId(registrationId);
		setCustomerId(customerId);
		setCourseId(courseId);
		setCourseTimeableId(courseTimeableId);
		setNumOfPeople(numOfPeople);
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
