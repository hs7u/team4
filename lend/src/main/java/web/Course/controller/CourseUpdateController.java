package web.Course.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
        if(cs.update(vo, check)){
            return "success";
        }
        return "fail";
    }
    @GetMapping(path = {"/Course/delete/{param}"})
    public void delete(@PathVariable("param") Integer courseId) {
        cs.delete(courseId);
    }
}
