package ProjectInterfaces;

import java.util.List;

public interface CourseInterface<CourseVO> {
    public void insert(CourseVO cVo);
    public void update(CourseVO cVo);
    public void delete(Integer courseId);
    public void changeStatus(Integer courseId, Byte courseStatus);
    public CourseVO getOneCourse(Integer courseId);
    public List<CourseVO> getAll();
}
