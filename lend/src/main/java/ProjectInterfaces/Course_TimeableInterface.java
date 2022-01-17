package ProjectInterfaces;

import java.sql.Timestamp;
import java.util.ArrayList;

public interface Course_TimeableInterface<Course_TimebleVO>{
    public void insert(Course_TimebleVO ctvo);        
    public void update(Course_TimebleVO ctvo);    
    public void delete(Integer course_timeable_id);    
    public ArrayList<Timestamp> selectByCourseId(Integer course_id);
}
