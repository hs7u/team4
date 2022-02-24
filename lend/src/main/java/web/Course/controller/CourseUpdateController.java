package web.Course.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import web.Course.service.CourseService;
import web.Course.vo.CourseVO;

@RestController
public class CourseUpdateController {
    @Autowired
    private CourseService cs;
    @RequestMapping(path = {"/Course/update"}, method = RequestMethod.POST)
    public String update(@RequestBody(required = false) CourseVO vo) {
        CourseVO check = cs.getOneCourse(vo.getCourseId());
        if(check != null){
            if(vo.getCourseName().trim().isEmpty())
                vo.setCourseName(check.getCourseName());
            if(vo.getCoursePrice() == null)
                vo.setCoursePrice(check.getCoursePrice());
            if(vo.getCourseImage().length <= 0)
                vo.setCourseImage(check.getCourseImage());
            if(vo.getMaxOfCourse() == null)
                vo.setMaxOfCourse(check.getMaxOfCourse());
            if(vo.getMinOfCourse() == null)
                vo.setMinOfCourse(check.getMinOfCourse());
            if(vo.getCourseLocation().trim().isEmpty())
                vo.setCourseLocation(check.getCourseDescribe());
            if(vo.getCourseDescribe().trim().isEmpty())
                vo.setCourseDescribe(check.getCourseDescribe());
            if(cs.update(vo))
                return "success";
        }
        return "fail";
    }
}
