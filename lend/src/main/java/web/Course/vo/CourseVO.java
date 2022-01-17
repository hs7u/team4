package web.Course.vo;


import java.sql.Timestamp;

public class CourseVO implements java.io.Serializable{
	private Integer courseId;
    private String courseName;
    private Integer coursePrice;
    private byte[] courseImage;
    private Timestamp releasedTime;
    private Integer maxOfCourse;
    private Integer minOfCourse;
    private String courseLocation;
    private Timestamp signUpStartdate;
    private Timestamp signUpDeadline;
    private String courseDescribe;
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
