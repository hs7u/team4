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
    public String addCourse(CourseVO cVo) {
        java.sql.Timestamp releasedTime = new java.sql.Timestamp(System.currentTimeMillis());
		StringBuilder errorMsg = new StringBuilder();
        if(cVo.getCourseName().trim().isEmpty()){
            errorMsg.append("課程名稱: 請勿空白"+System.lineSeparator());
        }else if (cVo.getCourseName().trim().length() < 4) {
            errorMsg.append("課程名稱: 只能是中、英文字母、數字和_ , 且長度必需在4到10之間");
        }
        if(cVo.getCourseDescribe().trim().isEmpty()){
            errorMsg.append("課程描述: 請勿空白"+System.lineSeparator());
        }
        if(cVo.getCourseLocation().trim().isEmpty()){
            errorMsg.append("上課地點: 請勿空白"+System.lineSeparator());
        }
        if(cVo.getCourseImage() == null){
            errorMsg.append("請上傳課程圖片"+System.lineSeparator());
        }
        if(cVo.getCoursePrice() == null){
            errorMsg.append("課程價格: 請填數字"+System.lineSeparator());
        }
        if(cVo.getMaxOfCourse()== null){
            errorMsg.append("額滿人數: 請填數字"+System.lineSeparator());
        }
        if(cVo.getMinOfCourse()== null){
            errorMsg.append("開課人數: 請填數字"+System.lineSeparator());
        }
        if(errorMsg.length() > 0){
            return errorMsg.toString();
        } 
		cVo.setReleasedTime(releasedTime);
        Integer id = (Integer)dao.insert(cVo);
        if(id!= null){
            return "success";
        }
        return "fail";
    }
    public Boolean update(CourseVO vo, CourseVO check){
        if(check != null){
            if(vo.getCourseName().trim().isEmpty())
                vo.setCourseName(check.getCourseName());
            if(vo.getCoursePrice() == null)
                vo.setCoursePrice(check.getCoursePrice());
            if(vo.getCourseImage() == null)
                vo.setCourseImage(check.getCourseImage());
            if(vo.getMaxOfCourse() == null)
                vo.setMaxOfCourse(check.getMaxOfCourse());
            if(vo.getMinOfCourse() == null)
                vo.setMinOfCourse(check.getMinOfCourse());
            if(vo.getCourseLocation().trim().isEmpty())
                vo.setCourseLocation(check.getCourseLocation());
            if(vo.getCourseDescribe().trim().isEmpty())
                vo.setCourseDescribe(check.getCourseDescribe());
            return dao.update(vo);
        }
        return false;
    }
    public void delete(Integer courseId){
        dao.delete(courseId);
    }
    public void changeStatus(Integer courseId, Byte courseState){
        dao.changeStatus(courseId, courseState);
    }
    public CourseVO getOneCourse(Integer courseId){
        return dao.getOneCourse(courseId);
    }
    public List<CourseVO> getALL(){
    	return dao.getAll();
    }
    public Long countCourse() {
        return dao.countCourse();
    }
}
