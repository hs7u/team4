package web.Course.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import web.Course.service.CourseService;
import web.Course.vo.CourseVO;

@RestController
public class AddCourseController {
    @Autowired
    private CourseService cs;
    @RequestMapping(path = {"/Course/addCourse"}, method = RequestMethod.POST)
    public ResponseEntity<String> newCourse(@RequestBody(required = false)CourseVO cVo){
        return new ResponseEntity<>(cs.addCourse(cVo), HttpStatus.OK);
    }
}
