package ProjectInterfaces;

import java.util.ArrayList;

public interface CourseRegistraionInterface<CourseRegistraionVO> {
    public void insert(CourseRegistraionVO crVo); 
    // public void update(CourseRegistraionVO crVo);
    public void delete(Integer registrationId);
    public CourseRegistraionVO selectByCustomerId(Integer customerId, Integer courseTimeableId);
    public ArrayList<CourseRegistraionVO> selectAllCustomerRegister(Integer customerId);
    public ArrayList<CourseRegistraionVO> selectByTimeableId(Integer courseTimeableId);
}
