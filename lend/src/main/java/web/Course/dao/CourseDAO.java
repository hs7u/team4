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
            ps.setInt(1, cVo.getCourse_id());
            ps.setString(2, cVo.getCourse_name());
            ps.setInt(3, cVo.getCourse_price());
            ps.setBytes(4, cVo.getCourse_image());
            ps.setTimestamp(5, cVo.getReleased_time());
            ps.setInt(6, cVo.getMaxOfCourse());
            ps.setInt(7, cVo.getMinOfCourse());
            ps.setString(8, cVo.getCourse_location());
            ps.setTimestamp(9, cVo.getSignUp_startdate());
            ps.setTimestamp(10, cVo.getSignUp_deadline());
            ps.setString(11, cVo.getCourse_describe());
            ps.executeUpdate();
        } catch (SQLException se) {
            throw new RuntimeException("A database error occured. "
            + se.getMessage());
        }
    }
    public void update(CourseVO cVo){
        try (Connection con = ds.getConnection();
            PreparedStatement ps = con.prepareStatement(UPDATE)) {
                ps.setInt(1, cVo.getCourse_id());
                ps.setString(2, cVo.getCourse_name());
                ps.setInt(3, cVo.getCourse_price());
                ps.setBytes(4, cVo.getCourse_image());
                ps.setInt(5, cVo.getMaxOfCourse());
                ps.setInt(6, cVo.getMinOfCourse());
                ps.setString(7, cVo.getCourse_location());
                ps.setTimestamp(8, cVo.getSignUp_startdate());
                ps.setTimestamp(9, cVo.getSignUp_deadline());
                ps.setString(10, cVo.getCourse_describe());
                ps.setInt(11, cVo.getCourse_id());
                ps.executeUpdate();
        } catch (SQLException se) {
            throw new RuntimeException("A database error occured. "
            + se.getMessage());
        }
    }
    public void delete(Integer course_id){
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = ds.getConnection();
            con.setAutoCommit(false);
            ps = con.prepareStatement(DELETE);
            ps.setInt(1, course_id);
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
    public void changeState(Integer course_id, Byte course_state){
        try (Connection con = ds.getConnection();
            PreparedStatement ps = con.prepareStatement(CHANGE_STATE)) {
            ps.setByte(1, course_state);
            ps.setInt(2, course_id);
            ps.executeUpdate();
        } catch (SQLException se) {
            throw new RuntimeException("A database error occured. "
            + se.getMessage());
        }
    }
    public CourseVO selectByCourseId(Integer course_id){
        CourseVO cVo = new CourseVO();
        try (Connection con = ds.getConnection();
            PreparedStatement ps = con.prepareStatement(GET_ONE_STM)) {
            ps.setInt(1, course_id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                cVo.setCourse_id(rs.getInt("course_id"));
                cVo.setCourse_name(rs.getString("course_name"));
                cVo.setCourse_price(rs.getInt("course_price"));
                cVo.setCourse_image(rs.getBytes("course_image"));
                cVo.setReleased_time(rs.getTimestamp("released_time"));
                cVo.setMaxOfCourse(rs.getInt("maxOfCourse"));
                cVo.setMinOfCourse(rs.getInt("minOfCourse"));
                cVo.setCourse_location(rs.getString("course_location"));
                cVo.setSignUp_startdate(rs.getTimestamp("signUp_startdate"));
                cVo.setSignUp_deadline(rs.getTimestamp("signUp_deadline"));
                cVo.setCourse_describe(rs.getString("course_describe"));
                cVo.setCourse_state(rs.getByte("course_state"));
            }
        } catch (SQLException se) {
            throw new RuntimeException("A database error occured. "
            + se.getMessage());
        }
        return cVo;
    }
}
