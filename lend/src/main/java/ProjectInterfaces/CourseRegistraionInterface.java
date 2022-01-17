package ProjectInterfaces;

import java.util.ArrayList;

public interface CourseRegistraionInterface<CourseRegistraionVO> {
    public void insert(CourseRegistraionVO crVo); 
    // public void update(CourseRegistraionVO crVo);
    public void delete(Integer registration_id);
    public CourseRegistraionVO selectByCustomerId(Integer customer_id, Integer course_timeable_id);
    public ArrayList<CourseRegistraionVO> selectAllCustomerRegister(Integer customer_id);
    public ArrayList<CourseRegistraionVO> selectByTimeableId(Integer course_timeable_id);
}
