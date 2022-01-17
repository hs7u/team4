package web.Course_Timeable.service;

import java.sql.Timestamp;
import java.util.ArrayList;

import ProjectInterfaces.Course_TimeableInterface;
import web.Course_Timeable.dao.Course_TimeableDAO;
import web.Course_Timeable.vo.Course_TimeableVO;

public class Course_TimeableService {
    private Course_TimeableInterface<Course_TimeableVO> dao;
    public Course_TimeableService() {
        dao = new Course_TimeableDAO();
    }
    public Course_TimeableVO addCourse_Timeable(Integer course_id, Timestamp course_date) {
        Course_TimeableVO ctvo = new Course_TimeableVO();
        ctvo.setCourse_id(course_id);
        ctvo.setCourse_date(course_date);
        dao.insert(ctvo);
        return ctvo;
    }
    public Course_TimeableVO updateCourseTimeable(Integer course_timeable_id, Integer course_id, Timestamp course_date){
        Course_TimeableVO ctvo = new Course_TimeableVO();
        ctvo.setCourse_timeable_id(course_timeable_id);
        ctvo.setCourse_id(course_id);
        ctvo.setCourse_date(course_date);
        dao.update(ctvo);
        return ctvo;
    }
    public void deleteCourseTimeable(Integer course_timeable_id){
        dao.delete(course_timeable_id);
    }
    public ArrayList<Timestamp> selectByCourseId(Integer course_id) {
        return dao.selectByCourseId(course_id);
    }
}
