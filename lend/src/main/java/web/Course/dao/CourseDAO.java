package web.Course.dao;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;

/* import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource; */

import org.hibernate.Session;

import ProjectInterfaces.CourseInterface;
import web.Course.vo.CourseVO;

public class CourseDAO implements CourseInterface<CourseVO> {
    private Session s;
    public CourseDAO(Session s){
        this.s = s;
    }
    /* private static final String INSERT = "INSERT INTO `TEAM4`.`Course`"
    +"(`course_id`,`course_name`,`course_price`,`course_image`,`released_time`,`maxOfCourse`,`minOfCourse`,`course_location`,`signUp_startdate`,`signUp_deadline`,`course_describe`)"
    +"VALUES"
    +"(?,?,?,?,?,?,?,?,?,?,?);";
    private static final String UPDATE = "UPDATE `TEAM4`.`Course`"
    +"SET`course_id` = ?,`course_name` = ?,`course_price` = ?,`course_image` = ?,`maxOfCourse` = ?,`minOfCourse` = ?,`course_location` = ?,`signUp_startdate` = ?,`signUp_deadline` = ?,`course_describe` = ?"
    +"WHERE `course_id` = ?;";
    private static final String DELETE = "DELETE FROM `TEAM4`.`Course` WHERE `course_id` = ;";
    private static final String GET_ONE_STM = "SELECT * FROM TEAM4.Course WHERE `course_id` = ?;";
    private static final String CHANGE_STATE =  "UPDATE `TEAM4`.`Course`"
    +"`course_state` = ?"
    +"WHERE `course_id` = ?;"; */
    public void insert(CourseVO cVo){
        // Hibernate
        if(cVo != null && cVo.getCourseId() != null){
            CourseVO newCource = this.s.get(CourseVO.class, cVo.getCourseId());
            if(newCource == null){
                this.s.save(cVo);
            }
        }
        // DateSource Jdbc
        /* try (Connection con = ds.getConnection();
            PreparedStatement ps = con.prepareStatement(INSERT)) {
            ps.setInt(1, cVo.getCourseId());
            ps.setString(2, cVo.getCourseName());
            ps.setInt(3, cVo.getCoursePrice());
            ps.setBytes(4, cVo.getCourseImage());
            ps.setTimestamp(5, cVo.getReleasedTime());
            ps.setInt(6, cVo.getMaxOfCourse());
            ps.setInt(7, cVo.getMinOfCourse());
            ps.setString(8, cVo.getCourseLocation());
            ps.setTimestamp(9, cVo.getSignUpStartdate());
            ps.setTimestamp(10, cVo.getSignUpDeadline());
            ps.setString(11, cVo.getCourseDescribe());
            ps.executeUpdate();
        } catch (SQLException se) {
            throw new RuntimeException("A database error occured. "
            + se.getMessage());
        } */
    }
    public void update(CourseVO cVo){
       // JPA CriterQuery
       CriteriaBuilder cb = this.s.getCriteriaBuilder();
       CriteriaUpdate<CourseVO> cu = cb.createCriteriaUpdate(CourseVO.class);
       Root<CourseVO> root = cu.from(CourseVO.class);
       cu = cu.set(root.get("course_name"), cVo.getCourseName())
              .set(root.get("course_price"), cVo.getCoursePrice())
              .set(root.get("course_image"), cVo.getCourseImage())
              .set(root.get("maxOfCourse"), cVo.getMaxOfCourse())
              .set(root.get("minOfCourse"), cVo.getMinOfCourse())
              .set(root.get("course_location"), cVo.getCourseLocation())
              .set(root.get("course_describe"), cVo.getCourseDescribe())
              .where(cb.equal(root.get("course_id"), cVo.getCourseId()));
        this.s.createQuery(cu).executeUpdate();

       // Hibernate
       /* CourseVO courseVo = this.s.get(CourseVO.class, cVo.getCourseId());
       if(courseVo != null){
            courseVo.setCourseId(cVo.getCourseId());
            courseVo.setCourseName(cVo.getCourseName());
            courseVo.setCoursePrice(cVo.getCoursePrice());
            courseVo.setCourseImage(cVo.getCourseImage());
            courseVo.setMaxOfCourse(cVo.getMaxOfCourse());
            courseVo.setMinOfCourse(cVo.getMinOfCourse());
            courseVo.setCourseLocation(cVo.getCourseLocation());
            courseVo.setCourseDescribe(cVo.getCourseDescribe());
            this.s.save(courseVo);
       } */ 
       // DateSource Jdbc
       /*  try (Connection con = ds.getConnection();
            PreparedStatement ps = con.prepareStatement(UPDATE)) {
                ps.setInt(1, cVo.getCourseId());
                ps.setString(2, cVo.getCourseName());
                ps.setInt(3, cVo.getCoursePrice());
                ps.setBytes(4, cVo.getCourseImage());
                ps.setInt(5, cVo.getMaxOfCourse());
                ps.setInt(6, cVo.getMinOfCourse());
                ps.setString(7, cVo.getCourseLocation());
                ps.setTimestamp(8, cVo.getSignUpStartdate());
                ps.setTimestamp(9, cVo.getSignUpDeadline());
                ps.setString(10, cVo.getCourseDescribe());
                ps.setInt(11, cVo.getCourseId());
                ps.executeUpdate();
        } catch (SQLException se) {
            throw new RuntimeException("A database error occured. "
            + se.getMessage());
        } */
    }
    public void delete(Integer courseId){
        // JPA CriterQuery
        CriteriaBuilder cb = this.s.getCriteriaBuilder();
        CriteriaDelete<CourseVO> cd = cb.createCriteriaDelete(CourseVO.class);
        Root<CourseVO> root = cd.from(CourseVO.class);
        cd = cd.where(cb.equal(root.get("course_id"), courseId));
        this.s.createQuery(cd).executeUpdate();
        // Hibernate
        /* if(courseId != null){
            CourseVO cVo = this.s.get(CourseVO.class, courseId);
            if(cVo != null){
                this.s.delete(cVo);
            }
        } */
        // DateSource Jdbc
        /* Connection con = null;
        PreparedStatement ps = null;
        try {
            con = ds.getConnection();
            con.setAutoCommit(false);
            ps = con.prepareStatement(DELETE);
            ps.setInt(1, courseId);
            ps.executeUpdate();
            con.commit();
            con.setAutoCommit(true);    
        } catch (SQLException se) {
            if(con != null){
                try {
                    con.rollback();
                } catch (SQLException e) {
                    throw new RuntimeException("rollback error occured. "
					+ e.getMessage());        
                }
            }
            throw new RuntimeException("A database error occured. "
					+ se.getMessage());
        } finally{
            if(con != null){
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace(System.err);
                }
            }
            if(ps != null){
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace(System.err);
                }
            }
        } */
    }
    public void changeState(Integer courseId, Byte courseState){
        // JPA CriterQuery
        CriteriaBuilder cb = this.s.getCriteriaBuilder();
        CriteriaUpdate<CourseVO> cu = cb.createCriteriaUpdate(CourseVO.class);
        Root<CourseVO> root = cu.from(CourseVO.class);
        cu = cu.set(root.get("course_status"), courseState)
               .where(cb.equal(root.get("course_id"), courseId));
        this.s.createQuery(cu).executeUpdate();

        // Hibernate
        /* CourseVO cVo = this.s.get(CourseVO.class, courseId);
        if(cVo != null){
            cVo.setCourseState(courseState);
            this.s.save(cVo);
        } */
        // DateSource Jdbc
        /* try (Connection con = ds.getConnection();
            PreparedStatement ps = con.prepareStatement(CHANGE_STATE)) {
            ps.setByte(1, courseState);
            ps.setInt(2, courseId);
            ps.executeUpdate();
        } catch (SQLException se) {
            throw new RuntimeException("A database error occured. "
            + se.getMessage());
        } */
    }
    public CourseVO selectByCourseId(Integer courseId){
        // JPA CriterQuery
        CriteriaBuilder cb = this.s.getCriteriaBuilder();
        CriteriaQuery<CourseVO> cq = cb.createQuery(CourseVO.class);
        Root<CourseVO> root = cq.from(CourseVO.class);
        cq = cq.where(cb.equal(root.get("course_id"), courseId));
        
        try {
			return this.s.createQuery(cq).getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
        // Hibernate
        /* return this.s.get(CourseVO.class, courseId); */
        // DateSource Jdbc
        /* CourseVO cVo = new CourseVO();
        try (Connection con = ds.getConnection();
            PreparedStatement ps = con.prepareStatement(GET_ONE_STM)) {
            ps.setInt(1, courseId);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                cVo.setCourseId(rs.getInt("course_id"));
                cVo.setCourseName(rs.getString("course_name"));
                cVo.setCoursePrice(rs.getInt("course_price"));
                cVo.setCourseImage(rs.getBytes("course_image"));
                cVo.setReleasedTime(rs.getTimestamp("released_time"));
                cVo.setMaxOfCourse(rs.getInt("maxOfCourse"));
                cVo.setMinOfCourse(rs.getInt("minOfCourse"));
                cVo.setCourseLocation(rs.getString("course_location"));
                cVo.setSignUpStartdate(rs.getTimestamp("signUp_startdate"));
                cVo.setSignUpDeadline(rs.getTimestamp("signUp_deadline"));
                cVo.setCourseDescribe(rs.getString("course_describe"));
                cVo.setCourseState(rs.getByte("course_state"));
            }
        } catch (SQLException se) {
            throw new RuntimeException("A database error occured. "
            + se.getMessage());
        }
        return cVo; */
    }
}
