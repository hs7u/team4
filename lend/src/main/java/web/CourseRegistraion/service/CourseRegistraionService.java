package web.CourseRegistraion.service;

import java.util.ArrayList;

import ProjectInterfaces.CourseRegistraionInterface;
import web.CourseRegistraion.dao.CourseRegistraionDAO;
import web.CourseRegistraion.vo.CourseRegistraionVO;

public class CourseRegistraionService {
    private CourseRegistraionInterface<CourseRegistraionVO> dao;
    public CourseRegistraionService(){
        dao = new CourseRegistraionDAO();
    }
    public CourseRegistraionVO registCourse(Integer customer_id, Integer course_id,
    Integer course_timeable_id, Integer numOfPeople){
        CourseRegistraionVO crVo = new CourseRegistraionVO();
        crVo.setRegistration_id(hashCode(customer_id, course_id, course_timeable_id, numOfPeople));
        crVo.setCustomer_id(customer_id);
        crVo.setCourse_id(course_id);
        crVo.setCourse_timeable_id(course_timeable_id);
        crVo.setNumOfPeople(numOfPeople);
        dao.insert(crVo);
        return crVo;
    }
    public void deleteRegist(Integer registration_id){
        dao.delete(registration_id);
    }
    public CourseRegistraionVO selectOneCURegist(Integer customer_id, Integer course_timeable_id){
        return dao.selectByCustomerId(customer_id, course_timeable_id);
    }
    public ArrayList<CourseRegistraionVO> selectAllCURegist(Integer customer_id){
        return dao.selectAllCustomerRegister(customer_id);
    }
    public ArrayList<CourseRegistraionVO> selectSameTIRegist(Integer course_timeable_id){
        return dao.selectByTimeableId(course_timeable_id);
    }
    public int hashCode(Integer customer_id, Integer course_id, Integer course_timeable_id, Integer numOfPeople) {
        final int prime = 31;
		int result = 1;
        result = result * prime + customer_id + course_id;
        result = result * prime + course_timeable_id + numOfPeople;
        
		return result;
    }
}
