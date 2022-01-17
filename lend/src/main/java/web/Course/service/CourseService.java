package web.Course.service;

import java.sql.Timestamp;

import ProjectInterfaces.CourseInterface;
import web.Course.dao.CourseDAO;
import web.Course.vo.CourseVO;

public class CourseService {
    private CourseInterface<CourseVO> dao;
    public CourseService() {
        dao = new CourseDAO();
    }
    public CourseVO addCourse(String course_name, Integer course_price, byte[] course_image,
            Integer maxOfCourse, Integer minOfCourse, String course_location,
            Timestamp signUp_startdate, Timestamp signUp_deadline, String course_describe) {
        java.sql.Timestamp released_time = new java.sql.Timestamp(System.currentTimeMillis());
        CourseVO cVo = new CourseVO();
        cVo.setCourse_id(hashCode(course_name, course_location));
		cVo.setCourse_name(course_name);
		cVo.setCourse_price(course_price);
		cVo.setCourse_image(course_image);
		cVo.setReleased_time(released_time);
		cVo.setMaxOfCourse(maxOfCourse);
		cVo.setMinOfCourse(minOfCourse);
		cVo.setCourse_location(course_location);
		cVo.setSignUp_startdate(signUp_startdate);
		cVo.setSignUp_deadline(signUp_deadline);
		cVo.setCourse_describe(course_describe);
        dao.insert(cVo);
        return cVo;
    }
    public CourseVO update(Integer course_id, String course_name, Integer course_price, byte[] course_image,
            Integer maxOfCourse, Integer minOfCourse, String course_location,
            Timestamp signUp_startdate, Timestamp signUp_deadline, String course_describe){
        CourseVO cVo = new CourseVO();
        cVo.setCourse_id(course_id);
		cVo.setCourse_name(course_name);
		cVo.setCourse_price(course_price);
		cVo.setCourse_image(course_image);
		cVo.setMaxOfCourse(maxOfCourse);
		cVo.setMinOfCourse(minOfCourse);
		cVo.setCourse_location(course_location);
		cVo.setSignUp_startdate(signUp_startdate);
		cVo.setSignUp_deadline(signUp_deadline);
		cVo.setCourse_describe(course_describe);
        dao.update(cVo);
        return cVo;
    }
    public void delete(Integer course_id){
        dao.delete(course_id);
    }
    public void changeState(Integer course_id, Byte course_state){
        dao.changeState(course_id, course_state);
    }
    public CourseVO selectByCourseId(Integer course_id){
        return dao.selectByCourseId(course_id);
    }
    public int hashCode(String course_name, String course_location) {
        final int prime = 31;
		int result = 1;
		result = result * prime + (course_name == null ? 0 : (course_name).hashCode()); 
		result = result * prime + (course_location == null ? 0 : (course_location).hashCode()); 
        
		return result;
    }
}
