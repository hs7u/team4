package web.Course.vo;

import java.sql.Timestamp;

public class CourseVO implements java.io.Serializable{
	private Integer course_id;
    private String course_name;
    private Integer course_price;
    private byte[] course_image;
    private Timestamp released_time;
    private Integer maxOfCourse;
    private Integer minOfCourse;
    private String course_location;
    private Timestamp signUp_startdate;
    private Timestamp signUp_deadline;
    private String course_describe;
	private Byte course_state;
    public CourseVO() {
		super();
	}
    public CourseVO(Integer course_id, String course_name, Integer course_price, byte[] course_image,
			Timestamp released_time, Integer maxOfCourse, Integer minOfCourse, String course_location,
			Timestamp signUp_startdate, Timestamp signUp_deadline, String course_describe) {
		setCourse_id(course_id);
		setCourse_name(course_name);
		setCourse_price(course_price);
		setCourse_image(course_image);
		setReleased_time(released_time);
		setMaxOfCourse(maxOfCourse);
		setMinOfCourse(minOfCourse);
		setCourse_location(course_location);
		setSignUp_startdate(signUp_startdate);
		setSignUp_deadline(signUp_deadline);
		setCourse_describe(course_describe);
	}
	public Integer getCourse_id() {
		return course_id;
	}
	public void setCourse_id(Integer course_id) {
		this.course_id = course_id;
	}
	public String getCourse_name() {
		return course_name;
	}
	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}
	public Integer getCourse_price() {
		return course_price;
	}
	public void setCourse_price(Integer course_price) {
		this.course_price = course_price;
	}
	public byte[] getCourse_image() {
		return course_image;
	}
	public void setCourse_image(byte[] course_image) {
		this.course_image= course_image;
	}
	public Timestamp getReleased_time() {
		return released_time;
	}
	public void setReleased_time(Timestamp released_time) {
		this.released_time = released_time;
	}
	public Integer getMaxOfCourse() {
		return maxOfCourse;
	}
	public void setMaxOfCourse(Integer maxOfCourse) {
		this.maxOfCourse = maxOfCourse;
	}
	public Integer getMinOfCourse() {
		return minOfCourse;
	}
	public void setMinOfCourse(Integer minOfCourse) {
		this.minOfCourse = minOfCourse;
	}
	public String getCourse_location() {
		return course_location;
	}
	public void setCourse_location(String course_location) {
		this.course_location = course_location;
	}
	public Timestamp getSignUp_startdate() {
		return signUp_startdate;
	}
	public void setSignUp_startdate(Timestamp signUp_startdate) {
		this.signUp_startdate = signUp_startdate;
	}
	public Timestamp getSignUp_deadline() {
		return signUp_deadline;
	}
	public void setSignUp_deadline(Timestamp signUp_deadline) {
		this.signUp_deadline = signUp_deadline;
	}
	public String getCourse_describe() {
		return course_describe;
	}
	public void setCourse_describe(String course_describe) {
		this.course_describe = course_describe;
	} 
	public Byte getCourse_state(){
		return this.course_state;
	}
	public void setCourse_state(Byte course_state){
		this.course_state = course_state;
	}
}
