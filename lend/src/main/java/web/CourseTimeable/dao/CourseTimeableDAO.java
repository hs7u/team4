package web.CourseTimeable.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import ProjectInterfaces.Course_TimeableInterface;
import web.CourseTimeable.vo.CourseTimeableVO;

public class CourseTimeableDAO implements CourseTimeableInterface<CourseTimeableVO>{
    private static DataSource ds = null;
    static{
        try {
            Context ctx = new InitialContext();
            ds = (DataSource)ctx.lookup("java:comp/env/jdbc/ProjectDB");
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }
    private static final String INSERT ="INSERT INTO `TEAM4`.`Course_Timeable`"
    +"(`course_id`,`course_date`)"
    +"VALUES"
    +"(?,?);";
    private static final String UPDATE ="UPDATE `TEAM4`.`Course_Timeable`"
    +"SET"
    +"`course_timeable_id` = ?,`course_id` = ?,`course_date` = ?"
    +"WHERE `course_timeable_id` = ?;";
    private static final String DELETE ="DELETE FROM `TEAM4`.`Course_Timeable` WHERE `course_timele_id` = ?;";
    private static final String selectByCourseId ="SELECT `course_date` FROM TEAM4.Course_Timeable WHERE `course_id` = ?;";
    public void insert(CourseTimeableVO ctvo){
        try (Connection con = ds.getConnection();
            PreparedStatement ps = con.prepareStatement(INSERT)) {
            ps.setInt(1, ctvo.getCourseId());
            ps.setTimestamp(2, ctvo.getCourseDate());
            ps.executeUpdate();
        } catch (SQLException se) {
            throw new RuntimeException("A database error occured. "
					+ se.getMessage());
        }
    }        
    public void update(CourseTimeableVO ctvo){
        try (Connection con = ds.getConnection();
            PreparedStatement ps = con.prepareStatement(UPDATE)) {
            ps.setInt(1, ctvo.getCourseTimeableId());
            ps.setInt(2, ctvo.getCourseId());
            ps.setTimestamp(3, ctvo.getCourseDate());
            ps.setInt(4, ctvo.getCourseTimeableId());
            ps.executeUpdate();
        } catch (SQLException se) {
            throw new RuntimeException("A database error occured. "
					+ se.getMessage());
        }
    }    
    public void delete(Integer courseTimeableId){
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = ds.getConnection();
            con.setAutoCommit(false);
            ps = con.prepareStatement(DELETE);
            ps.setInt(1, courseTimeableId);
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
            if(ps != null){
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace(System.err);
                }
            }
            if(con != null){
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace(System.err);
                }
            }
        }
    }    
    public ArrayList<Timestamp> selectByCourseId(Integer courseId){
        ArrayList<Timestamp> list = new ArrayList<Timestamp>();
        try (Connection con = ds.getConnection();
            PreparedStatement ps = con.prepareStatement(selectByCourseId)) {
            ps.setInt(1, courseId);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                list.add(rs.getTimestamp("course_date"));
            }
        } catch (SQLException se) {
            throw new RuntimeException("A database error occured. "
					+ se.getMessage());
        }
        return list;
    }
}
