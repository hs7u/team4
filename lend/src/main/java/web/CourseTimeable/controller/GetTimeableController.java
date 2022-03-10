package web.CourseTimeable.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import web.CourseTimeable.service.CourseTimeableService;

@RestController
public class GetTimeableController {
    @Autowired
    private CourseTimeableService cts;
    @PostMapping(path = {"/Course/schedule"})
    public ResponseEntity<?> getSchedule(@RequestBody(required = false) Integer courseId){
        return new ResponseEntity<>(cts.selectByCourseId(courseId), HttpStatus.OK);
    }
}
