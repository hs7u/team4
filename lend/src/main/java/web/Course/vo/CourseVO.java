package web.Course.vo;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "Course")
public class CourseVO implements java.io.Serializable{
	@Id
	@Column(name = "course_id")
	private Integer courseId;
	@Column(name = "course_name")
    private String courseName;
	@Column(name = "course_price")
    private Integer coursePrice;
	@Column(name = "course_image")
    private byte[] courseImage;
	@Column(name = "released_time")
    private Timestamp releasedTime;
	@Column(name = "maximun_ofCourse")
    private Integer maxOfCourse;
	@Column(name = "minimun_ofCourse")
    private Integer minOfCourse;
	@Column(name = "course_location")
    private String courseLocation;
	@Column(name = "signUp_startdate")
    private Timestamp signUpStartdate;
	@Column(name = "signUp_deadline")
    private Timestamp signUpDeadline;
	@Column(name = "course_describe")
    private String courseDescribe;
	@Column(name = "course_status")
	private Byte courseState;
    public CourseVO() {
		super();
	}
    public CourseVO(Integer courseId, String courseName, Integer coursePrice, byte[] courseImage,
			Timestamp releasedTime, Integer maxOfCourse, Integer minOfCourse, String courseLocation,
			Timestamp signUpStartdate, Timestamp signUpDeadline, String courseDescribe) {
		setCourseId(courseId);
		setCourseName(courseName);
		setCoursePrice(coursePrice);
		setCourseImage(courseImage);
		setReleasedTime(releasedTime);
		setMaxOfCourse(maxOfCourse);
		setMinOfCourse(minOfCourse);
		setCourseLocation(courseLocation);
		setSignUpStartdate(signUpStartdate);
		setSignUpDeadline(signUpDeadline);
		setCourseDescribe(courseDescribe);
	}
	public Integer getCourseId() {
		return courseId;
	}
	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public Integer getCoursePrice() {
		return coursePrice;
	}
	public void setCoursePrice(Integer coursePrice) {
		this.coursePrice = coursePrice;
	}
	public byte[] getCourseImage() {
		return courseImage;
	}
	public void setCourseImage(byte[] courseImage) {
		this.courseImage= courseImage;
	}
	public Timestamp getReleasedTime() {
		return releasedTime;
	}
	public void setReleasedTime(Timestamp releasedTime) {
		this.releasedTime = releasedTime;
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
	public String getCourseLocation() {
		return courseLocation;
	}
	public void setCourseLocation(String courseLocation) {
		this.courseLocation = courseLocation;
	}
	public Timestamp getSignUpStartdate() {
		return signUpStartdate;
	}
	public void setSignUpStartdate(Timestamp signUpStartdate) {
		this.signUpStartdate = signUpStartdate;
	}
	public Timestamp getSignUpDeadline() {
		return signUpDeadline;
	}
	public void setSignUpDeadline(Timestamp signUpDeadline) {
		this.signUpDeadline = signUpDeadline;
	}
	public String getCourseDescribe() {
		return courseDescribe;
	}
	public void setCourseDescribe(String courseDescribe) {
		this.courseDescribe = courseDescribe;
	} 
	public Byte getCourseState(){
		return this.courseState;
	}
	public void setCourseState(Byte courseState){
		this.courseState = courseState;
	}
}
