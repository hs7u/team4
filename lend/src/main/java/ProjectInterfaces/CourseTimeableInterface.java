package ProjectInterfaces;

import java.sql.Timestamp;
import java.util.ArrayList;

public interface CourseTimeableInterface<CourseTimebleVO>{
    public void insert(CourseTimebleVO ctvo);        
    public void update(CourseTimebleVO ctvo);    
    public void delete(Integer courseTimeableId);    
    public ArrayList<Timestamp> selectByCourseId(Integer courseId);
}
