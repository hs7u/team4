package web.CourseTimeable.vo;

import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import web.Course.vo.CourseVO;
import web.CourseRegistraion.vo.CourseRegistraionVO;
@Entity
@Table(name = "Course_Timeable")
@DynamicInsert
@DynamicUpdate
public class CourseTimeableVO implements java.io.Serializable{
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "course_timeable_id")
	private Integer courseTimeableId;
	@Column(name = "course_id")
    private Integer courseId;
	@Column(name = "course_date")
    private Timestamp courseDate;
	@Column(name = "signUp_startdate")
    private Timestamp signUpStartdate;
	@Column(name = "signUp_deadline")
    private Timestamp signUpDeadline;
//	@ManyToOne(optional=false, fetch = FetchType.LAZY)
//	@JoinColumn(name = "course_id", referencedColumnName = "course_id")
//	private CourseVO course;
	@OneToMany(mappedBy = "timeable", cascade = CascadeType.ALL)
	private Set<CourseRegistraionVO> regist;
	public Set<CourseRegistraionVO> getRegist(){
		return regist;
	}
	public void setRegist(Set<CourseRegistraionVO> regist){
		this.regist = regist;
	}
//	public CourseVO getCourse(){
//		return course;
//	}
//	public void setCourse(CourseVO course){
//		this.course = course;
//	}
	public CourseTimeableVO() {
		super();
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
}
