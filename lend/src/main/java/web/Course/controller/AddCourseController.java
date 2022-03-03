package web.Course.controller;

import java.util.EnumSet;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import web.Course.service.CourseService;
import web.Course.vo.CourseEnum;
import web.Course.vo.CourseVO;

@RestController
public class AddCourseController {
    @Autowired
    private CourseService cs;
    @RequestMapping(path = {"/Course/addCourse"}, method = RequestMethod.POST)
    public ResponseEntity<String> newCourse(@RequestBody(required = false)CourseVO cVo){
        return new ResponseEntity<>(cs.addCourse(cVo), HttpStatus.OK);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<String> handleBadInput(HttpMessageNotReadableException ex) {
        Throwable cause = ex.getCause();
        String check = cause.getMessage();
        String errorEx = Stream.of(CourseEnum.values()).filter(e -> check.contains(e.name()))
                                                    .findFirst()
                                                    .get()
                                                    .getType();
        return ResponseEntity.ok(errorEx);
    }
}
