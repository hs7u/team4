package web.Course.service;

import java.sql.Timestamp;

import ProjectInterfaces.CourseInterface;
import web.Course.dao.CourseDAO;
import web.Course.vo.CourseVO;

public class CourseService {
    private CourseInterface<CourseVO> dao;
    public CourseService() {
        dao = new CourseDAO(null);
    }
    public CourseVO addCourse(String courseName, Integer coursePrice, byte[] courseImage,
            Integer maxOfCourse, Integer minOfCourse, String courseLocation,
            Timestamp signUpStartdate, Timestamp signUpDeadline, String courseDescribe) {
        java.sql.Timestamp releasedTime = new java.sql.Timestamp(System.currentTimeMillis());
        CourseVO cVo = new CourseVO();
        cVo.setCourseId(hashCode(courseName, courseLocation));
		cVo.setCourseName(courseName);
		cVo.setCoursePrice(coursePrice);
		cVo.setCourseImage(courseImage);
		cVo.setReleasedTime(releasedTime);
		cVo.setMaxOfCourse(maxOfCourse);
		cVo.setMinOfCourse(minOfCourse);
		cVo.setCourseLocation(courseLocation);
		cVo.setCourseDescribe(courseDescribe);
        dao.insert(cVo);
        return cVo;
    }
    public CourseVO update(Integer courseId, String courseName, Integer coursePrice, byte[] courseImage,
            Integer maxOfCourse, Integer minOfCourse, String courseLocation,
            Timestamp signUpStartdate, Timestamp signUpDeadline, String courseDescribe){
        CourseVO cVo = new CourseVO();
        cVo.setCourseId(courseId);
		cVo.setCourseName(courseName);
		cVo.setCoursePrice(coursePrice);
		cVo.setCourseImage(courseImage);
		cVo.setMaxOfCourse(maxOfCourse);
		cVo.setMinOfCourse(minOfCourse);
		cVo.setCourseLocation(courseLocation);
		cVo.setCourseDescribe(courseDescribe);
        dao.update(cVo);
        return cVo;
    }
    public void delete(Integer courseId){
        dao.delete(courseId);
    }
    public void changeState(Integer courseId, Byte courseState){
        dao.changeState(courseId, courseState);
    }
    public CourseVO selectByCourseId(Integer courseId){
        return dao.selectByCourseId(courseId);
    }
    public int hashCode(String courseName, String courseLocation) {
        final int prime = 31;
		int result = 1;
		result = result * prime + (courseName == null ? 0 : (courseName).hashCode()); 
		result = result * prime + (courseLocation == null ? 0 : (courseLocation).hashCode()); 
        
		return result;
    }
}
