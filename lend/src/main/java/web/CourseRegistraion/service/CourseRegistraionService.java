package web.CourseRegistraion.service;

import java.io.Serializable;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ProjectInterfaces.CourseRegistraionInterface;
import web.CourseRegistraion.vo.CourseRegistraionVO;

@Service
@Transactional
public class CourseRegistraionService {
    @Autowired
    private CourseRegistraionInterface<CourseRegistraionVO> dao;
    // private CourseRegistraionDAO dao;
    // public CourseRegistraionService(Session session){
    //     dao = new CourseRegistraionDAO(session);
    // }
    public Serializable registCourse(CourseRegistraionVO crVo){
        return dao.insert(crVo);
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
