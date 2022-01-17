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
            ps.setInt(1,csVO.getCusotmerId());
            ps.setTimestamp(2,csVO.getMessageTime());
            ps.setString(3,csVO.getMessageTitle());
            ps.setString(4,csVO.getMessageContext());
            ps.executeUpdate();
        } catch (SQLException se) {
            throw new RuntimeException("A database error occured. "
            + se.getMessage());
        }
    }
    public void update(CustomerServiceVO csVO){
        try (Connection con = ds.getConnection();
         PreparedStatement ps = con.prepareStatement(UPDATE)) {
            ps.setInt(1,csVO.getMessageId());
            ps.setInt(2,csVO.getCusotmerId());
            ps.setString(3,csVO.getMessageTitle());
            ps.setString(4,csVO.getMessageContext());
            ps.setString(5,csVO.getReplyContext());
            ps.setInt(6,csVO.getMessageId());
            ps.executeUpdate();
        } catch (SQLException se) {
            throw new RuntimeException("A database error occured. "
            + se.getMessage());
        }
    }
    public CustomerServiceVO selectByMessageId(Integer messageId){
        CustomerServiceVO csVO = new CustomerServiceVO();
        try (Connection con = ds.getConnection();
         PreparedStatement ps = con.prepareStatement(GET_ONE_STM)) {
            ps.setInt(1, messageId);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                csVO.setMessageId(rs.getInt("message_id"));
                csVO.setCusotmerId(rs.getInt("cusotmer_id"));
                csVO.setMessageTime(rs.getTimestamp("message_time"));
                csVO.setMessageTitle(rs.getString("message_title"));
                csVO.setMessageContext(rs.getString("message_context"));
                csVO.setReplyContext(rs.getString("reply_context"));
            }
        } catch (SQLException se) {
            throw new RuntimeException("A database error occured. "
            + se.getMessage());
        }
        return csVO;
    }
}
