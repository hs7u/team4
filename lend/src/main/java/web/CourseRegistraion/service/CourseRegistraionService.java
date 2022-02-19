package web.CourseRegistraion.service;

import java.util.ArrayList;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ProjectInterfaces.CourseRegistraionInterface;
import web.CourseRegistraion.dao.CourseRegistraionDAO;
import web.CourseRegistraion.vo.CourseRegistraionVO;

@Service
public class CourseRegistraionService {
    @Autowired
    private CourseRegistraionDAO dao;
    // private CourseRegistraionInterface<CourseRegistraionVO> dao;
    // public CourseRegistraionService(Session session){
    //     dao = new CourseRegistraionDAO(session);
    // }
    public CourseRegistraionVO registCourse(Integer customerId, Integer courseId,
    Integer courseTimeableId, Integer numOfPeople){
        CourseRegistraionVO crVo = new CourseRegistraionVO();
        crVo.setRegistrationId(hashCode(customerId, courseId, courseTimeableId, numOfPeople));
        crVo.setCustomerId(customerId);
        crVo.setCourseId(courseId);
        crVo.setCourseTimeableId(courseTimeableId);
        crVo.setNumOfPeople(numOfPeople);
        dao.insert(crVo);
        return crVo;
    }
    public void deleteRegist(Integer registrationId){
        dao.delete(registrationId);
    }
    public CourseRegistraionVO selectOneCURegist(Integer customerId, Integer courseTimeableId){
        return dao.selectByCustomerId(customerId, courseTimeableId);
    }
    public ArrayList<CourseRegistraionVO> selectAllCURegist(Integer customerId){
        return dao.selectAllCustomerRegister(customerId);
    }
    public ArrayList<CourseRegistraionVO> selectSameTIRegist(Integer courseTimeableId){
        return dao.selectByTimeableId(courseTimeableId);
    }
    public int hashCode(Integer customerId, Integer courseId, Integer courseTimeableId, Integer numOfPeople) {
        final int prime = 31;
		int result = 1;
        result = result * prime + customerId + courseId;
        result = result * prime + courseTimeableId + numOfPeople;
        
		return result;
    }
}
