package web.CourseTimeable.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import web.CourseTimeable.service.CourseTimeableService;
import web.CourseTimeable.vo.CourseTimeableVO;

@RestController
public class TimeableController {
    @Autowired
    private CourseTimeableService cts;

    @RequestMapping(path = {"/CourseTimeable/insert"}, method = RequestMethod.POST)
    public String insert(@RequestBody(required = false) CourseTimeableVO vo) {
        StringBuilder errorMsg = new StringBuilder();
        if (vo.getCourseDate() == null) {
            errorMsg.append("課程日期不得為空"+System.lineSeparator());
        }
        if (vo.getSignUpDeadline() == null) {
            errorMsg.append("報名日期不得為空"+System.lineSeparator());
        }
        if (vo.getSignUpStartdate() == null) {
            errorMsg.append("截止日期不得為空"+System.lineSeparator());
        }
        if(errorMsg.length() > 0){
            return errorMsg.toString();
        }
        if(cts.addCourseTimeable(vo) != null)
            return "success";
        return "修改失敗";
    }
}