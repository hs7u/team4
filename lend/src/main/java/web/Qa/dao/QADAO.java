package web.Qa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import ProjectInterfaces.QAInterface;
import web.Qa.vo.QAVO;

public class QADAO implements QAInterface<QAVO>{
    private static DataSource ds = null;
    static{
        try {
            Context ctx = new InitialContext();
            ds = (DataSource)ctx.lookup("java:comp/env/jdbc/ProjectDB");
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }
    private static final String INSERT = "INSERT INTO `TEAM4`.`QA`"
    +"(`answer`,`quession`)"
    +"VALUES"
    +"(?,?);";
    private static final String UPDATE = "UPDATE `TEAM4`.`QA`"
    +"SET"
    +"`qa_id` = ?,`answer` = ?,`quession` = ?"
    +"WHERE `qa_id` = ?;";
    private static final String DELETE = "DELETE FROM `TEAM4`.`QA` WHERE `qa_id` = ?;";
    private static final String SELECT_BY_QAID = "SELECT * FROM TEAM4.QA WHERE `qa_id` = ?";
    public void insert(QAVO qavo){
        try (Connection con = ds.getConnection();
            PreparedStatement ps = con.prepareStatement(INSERT)) {
            ps.setString(1, qavo.getQuession());
            ps.setString(2, qavo.getAnswer());
            ps.executeUpdate();
        } catch (SQLException se) {
            throw new RuntimeException("A database error occured. "
					+ se.getMessage());
        }
    } 
    public void update(QAVO qavo){
        try (Connection con = ds.getConnection();
            PreparedStatement ps = con.prepareStatement(UPDATE)) {
            ps.setInt(1, qavo.getQaId());
            ps.setString(2, qavo.getQuession());
            ps.setString(3, qavo.getAnswer());
            ps.setInt(4, qavo.getQaId());
            ps.executeUpdate();
        } catch (SQLException se) {
            throw new RuntimeException("A database error occured. "
					+ se.getMessage());
        }
    }      
    public void delete(Integer qaId){
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = ds.getConnection();
            con.setAutoCommit(false);
            ps = con.prepareStatement(DELETE);
            ps.setInt(1, qaId);
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
    public QAVO selectByQAId(Integer qaId){
        QAVO qa = new QAVO();
        try (Connection con = ds.getConnection();
            PreparedStatement ps = con.prepareStatement(SELECT_BY_QAID)) {
            ps.setInt(1, qaId);
            ResultSet rs =  ps.executeQuery();
            while(rs.next()){
                qa.setQaId(rs.getInt("qa_id"));
                qa.setQuession(rs.getString("quession"));
                qa.setAnswer(rs.getString("answer"));
            }
        } catch (SQLException se) {
            throw new RuntimeException("A database error occured. "
					+ se.getMessage());
        }
        return qa;
    }
}
