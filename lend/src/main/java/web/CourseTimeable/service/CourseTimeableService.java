package web.CourseTimeable.service;

import java.sql.Timestamp;
import java.util.ArrayList;

import org.hibernate.Session;

import ProjectInterfaces.CourseTimeableInterface;
import web.CourseTimeable.dao.CourseTimeableDAO;
import web.CourseTimeable.vo.CourseTimeableVO;

public class CourseTimeableService {
    private CourseTimeableInterface<CourseTimeableVO> dao;
    public CourseTimeableService(Session session) {
        dao = new CourseTimeableDAO(session);
    }
    public CourseTimeableVO addCourseTimeable(Integer courseId, Timestamp courseDate,Timestamp signUpStartdate, Timestamp signUpDeadline) {
        CourseTimeableVO ctvo = new CourseTimeableVO();
        ctvo.setCourseId(courseId);
        ctvo.setCourseDate(courseDate);
        ctvo.setSignUpStartdate(signUpStartdate);
        ctvo.setSignUpDeadline(signUpDeadline);
        dao.insert(ctvo);
        return ctvo;
    }
    public CourseTimeableVO updateCourseTimeable(Integer courseTimeableId, Integer courseId, Timestamp courseDate, Timestamp signUpStartdate, Timestamp signUpDeadline){
        CourseTimeableVO ctvo = new CourseTimeableVO();
        ctvo.setCourseTimeableId(courseTimeableId);
        ctvo.setCourseId(courseId);
        ctvo.setCourseDate(courseDate);
        ctvo.setSignUpStartdate(signUpStartdate);
        ctvo.setSignUpDeadline(signUpDeadline);
        dao.update(ctvo);
        return ctvo;
    }
    public void deleteCourseTimeable(Integer courseTimeableId){
        dao.delete(courseTimeableId);
    }
    public ArrayList<Timestamp> selectByCourseId(Integer courseId) {
        return dao.selectByCourseId(courseId);
    }
}
