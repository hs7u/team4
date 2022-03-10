package ProjectInterfaces;

import java.util.ArrayList;

import web.CourseTimeable.vo.CourseTimeableVO;

public interface CourseTimeableInterface<CourseTimebleVO>{
    public void insert(CourseTimebleVO ctvo);        
    public void update(CourseTimebleVO ctvo);    
    public void delete(Integer courseTimeableId);    
    public ArrayList<CourseTimeableVO> selectByCourseId(Integer courseId);
    public CourseTimeableVO selectByTimeableId(Integer courseTimeableId);
}
