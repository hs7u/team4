package ProjectInterfaces;

public interface CourseInterface<CourseVO> {
    public void insert(CourseVO cVo);
    public void update(CourseVO cVo);
    public void delete(Integer course_id);
    public void changeState(Integer course_id, Byte course_status);
    public CourseVO selectByCourseId(Integer course_id);
}
