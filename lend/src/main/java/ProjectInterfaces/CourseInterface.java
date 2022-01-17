package ProjectInterfaces;

public interface CourseInterface<CourseVO> {
    public void insert(CourseVO cVo);
    public void update(CourseVO cVo);
    public void delete(Integer courseId);
    public void changeState(Integer courseId, Byte courseStatus);
    public CourseVO selectByCourseId(Integer courseId);
}
