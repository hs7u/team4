package web.Course.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ProjectInterfaces.CourseInterface;
import web.Course.vo.CourseVO;

@Service
@Transactional
public class CourseService {
    @Autowired
    private CourseInterface<CourseVO> dao;
    // private CourseDAO dao;
    // public CourseService(Session session) {
    //     dao = new CourseDAO(session);
    // }
    public CourseVO addCourse(String courseName, Integer coursePrice, byte[] courseImage,
            Integer maxOfCourse, Integer minOfCourse, String courseLocation, String courseDescribe) {
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
    public CourseVO update(CourseVO cVo){
        // CourseVO cVo = new CourseVO();
        // cVo.setCourseId(courseId);
		// cVo.setCourseName(courseName);
		// cVo.setCoursePrice(coursePrice);
		// cVo.setCourseImage(courseImage);
		// cVo.setMaxOfCourse(maxOfCourse);
		// cVo.setMinOfCourse(minOfCourse);
		// cVo.setCourseLocation(courseLocation);
		// cVo.setCourseDescribe(courseDescribe);
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
    
    public List<CourseVO> getALL(){
    	return dao.getAll();
    }
    
}
