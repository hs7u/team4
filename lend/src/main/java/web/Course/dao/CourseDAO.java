package web.Course.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import ProjectInterfaces.CourseInterface;
import web.Course.vo.CourseVO;

public class CourseDAO implements CourseInterface<CourseVO> {
    private static DataSource ds = null;
    static{
        try {
            Context ctx = new InitialContext();
            ds = (DataSource) ctx.lookup("java:comp/env/jdbc/ProjectDB");
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }
    private static final String INSERT = "INSERT INTO `TEAM4`.`Course`"
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
    +"WHERE `course_id` = ?;";
    public void insert(CourseVO cVo){
        try (Connection con = ds.getConnection();
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
        }
    }
    public void update(CourseVO cVo){
        try (Connection con = ds.getConnection();
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
        }
    }
    public void delete(Integer courseId){
        Connection con = null;
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
        }
    }
    public void changeState(Integer courseId, Byte courseState){
        try (Connection con = ds.getConnection();
            PreparedStatement ps = con.prepareStatement(CHANGE_STATE)) {
            ps.setByte(1, courseState);
            ps.setInt(2, courseId);
            ps.executeUpdate();
        } catch (SQLException se) {
            throw new RuntimeException("A database error occured. "
            + se.getMessage());
        }
    }
    public CourseVO selectByCourseId(Integer courseId){
        CourseVO cVo = new CourseVO();
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
                cVo.setCourse_state(rs.getByte("course_state"));
            }
        } catch (SQLException se) {
            throw new RuntimeException("A database error occured. "
            + se.getMessage());
        }
        return cVo;
    }
}
