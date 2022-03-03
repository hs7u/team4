package ProjectInterfaces;

import java.io.Serializable;
import java.util.List;

public interface CourseInterface<CourseVO> {
    public Serializable insert(CourseVO cVo);
    public Boolean update(CourseVO cVo);
    public void delete(Integer courseId);
    public void changeStatus(Integer courseId, Byte courseStatus);
    public CourseVO getOneCourse(Integer courseId);
    public List<CourseVO> getAll();
    public Long countCourse();
}
