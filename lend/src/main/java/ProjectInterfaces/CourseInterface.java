package ProjectInterfaces;

import java.util.List;

public interface CourseInterface<CourseVO> {
    public void insert(CourseVO cVo);
    public Boolean update(CourseVO cVo);
    public void delete(Integer courseId);
    public void changeState(Integer courseId, Byte courseStatus);
    public CourseVO selectByCourseId(Integer courseId);
    public List<CourseVO> getAll();
}
