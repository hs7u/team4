package ProjectInterfaces;

import java.sql.Timestamp;
import java.util.ArrayList;

public interface CourseTimeableInterface<CourseTimebleVO>{
    public void insert(Course_TimebleVO ctvo);        
    public void update(Course_TimebleVO ctvo);    
    public void delete(Integer courseTimeable_id);    
    public ArrayList<Timestamp> selectByCourseId(Integer courseId);
}
