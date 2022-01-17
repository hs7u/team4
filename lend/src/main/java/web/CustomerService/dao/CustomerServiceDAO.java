package web.CustomerService.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import ProjectInterfaces.CustomerServiceInterface;
import web.CustomerService.vo.CustomerServiceVO;

public class CustomerServiceDAO implements CustomerServiceInterface<CustomerServiceVO>{
    private static DataSource ds = null;
    static{
        try {
            Context ctx = new InitialContext();
            ds = (DataSource)ctx.lookup("java:comp/env/jdbc/ProjectDB");
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }
    private static final String INSERT = "INSERT INTO `TEAM4`.`Customer_Service`"
    +"(`cusotmer_id`,`message_time`,`message_title`,`message_context`)"
    +"VALUES"
    +"(?,?,?,?);";
    private static final String UPDATE = "UPDATE `TEAM4`.`Customer_Service`"
    +"SET"
    +"`message_id` = ?,`cusotmer_id` = ?,`message_title` = ?,`message_context` = ?,`reply_context` = ?"
    +"WHERE `message_id` = ?;";
    private static final String GET_ONE_STM = "SELECT * FROM TEAM4.Customer_Service WHERE `message_id` = ?;";
    public void insert(CustomerServiceVO csVO){
        try (Connection con = ds.getConnection();
         PreparedStatement ps = con.prepareStatement(INSERT)) {
            ps.setInt(1,csVO.getCusotmer_id());
            ps.setTimestamp(2,csVO.getMessage_time());
            ps.setString(3,csVO.getMessage_title());
            ps.setString(4,csVO.getMessage_context());
            ps.executeUpdate();
        } catch (SQLException se) {
            throw new RuntimeException("A database error occured. "
            + se.getMessage());
        }
    }
    public void update(CustomerServiceVO csVO){
        try (Connection con = ds.getConnection();
         PreparedStatement ps = con.prepareStatement(UPDATE)) {
            ps.setInt(1,csVO.getMessage_id());
            ps.setInt(2,csVO.getCusotmer_id());
            ps.setString(3,csVO.getMessage_title());
            ps.setString(4,csVO.getMessage_context());
            ps.setString(5,csVO.getReply_context());
            ps.setInt(6,csVO.getMessage_id());
            ps.executeUpdate();
        } catch (SQLException se) {
            throw new RuntimeException("A database error occured. "
            + se.getMessage());
        }
    }
    public CustomerServiceVO selectByMessageId(Integer message_id){
        CustomerServiceVO csVO = new CustomerServiceVO();
        try (Connection con = ds.getConnection();
         PreparedStatement ps = con.prepareStatement(GET_ONE_STM)) {
            ps.setInt(1, message_id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                csVO.setMessage_id(rs.getInt("message_id"));
                csVO.setCusotmer_id(rs.getInt("cusotmer_id"));
                csVO.setMessage_time(rs.getTimestamp("message_time"));
                csVO.setMessage_title(rs.getString("message_title"));
                csVO.setMessage_context(rs.getString("message_context"));
                csVO.setReply_context(rs.getString("reply_context"));
            }
        } catch (SQLException se) {
            throw new RuntimeException("A database error occured. "
            + se.getMessage());
        }
        return csVO;
    }
}
