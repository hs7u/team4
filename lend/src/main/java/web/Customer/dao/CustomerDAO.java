package web.Customer.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
// import java.util.List;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import ProjectInterfaces.CustomerInterface;
import web.Customer.vo.CustomerVO;

public class CustomerDAO implements CustomerInterface<CustomerVO>{
    private static DataSource ds = null;
    static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/ProjectDB");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
    private static final String INSERT_STMT = "INSERT INTO `TEAM4`.`Customer`"
    +"(`customer_id`,`customer_name`,`customer_email`,`customer_password`,`customer_phone`,`customer_birthday`,`customer_gender`,`customer_address`,`customer_register_time`)"
    +"VALUES(?,?,?,?,?,?,?,?,?)";
    // private static final String GET_ALL_STMT = "";
    private static final String GET_ONE_STMT = "SELECT * FROM TEAM4.Customer "
    +"WHERE `customer_email` = ? AND `customer_password` = ?;";
    private static final String DELETE = "DELETE FROM `TEAM4`.`Customer` WHERE `customer_id` = ?;";
    private static final String UPDATE = "UPDATE `TEAM4`.`Customer`"
    +"SET`customer_id` = ?,`customer_name` = ?,`customer_email` = ?,`customer_password` = ?,`customer_phone` = ?,`customer_birthday` = ?,`customer_gender` = ?,`customer_address` = ?"
    +"WHERE `customer_id` = ?;";
    private static final String CUSTOMER_STATUS = "UPDATE `TEAM4`.`Customer`"
    +"SET"
    +"`customer_status` = ?"
    +"WHERE `customer_id` = ?;";
    public void insert(CustomerVO customerVo){
        try (Connection con = ds.getConnection(); 
            PreparedStatement ps = con.prepareStatement(INSERT_STMT)){
            ps.setInt(1, customerVo.getCustomer_id());
            ps.setString(2, customerVo.getCustomer_name());
            ps.setString(3, customerVo.getCustomer_email());
            ps.setString(4, customerVo.getCustomer_password());
            ps.setString(5, customerVo.getCustomer_phone());
            ps.setDate(6, customerVo.getCustomer_birthday());
            ps.setString(7, customerVo.getCustomer_gender());
            ps.setString(8, customerVo.getCustomer_address());
            ps.setTimestamp(9, customerVo.getCustomer_register_time());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void update(CustomerVO customerVo){
        try (Connection con = ds.getConnection();
            PreparedStatement ps = con.prepareStatement(UPDATE)) {
            ps.setInt(1, customerVo.getCustomer_id());
            ps.setString(2, customerVo.getCustomer_name());
            ps.setString(3, customerVo.getCustomer_email());
            ps.setString(4, customerVo.getCustomer_password());
            ps.setString(5, customerVo.getCustomer_phone());
            ps.setDate(6, customerVo.getCustomer_birthday());
            ps.setString(7, customerVo.getCustomer_gender());
            ps.setString(8, customerVo.getCustomer_address());
            ps.setInt(9, customerVo.getCustomer_id());
            ps.executeUpdate();
        } catch (SQLException se) {
            throw new RuntimeException("A database error occured. "
					+ se.getMessage());
        }
    }
    public void delete(Integer customer_id){
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = ds.getConnection();
            con.setAutoCommit(false);
            ps = con.prepareStatement(DELETE);
            ps.setInt(1, customer_id);
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
    public void changeStatus(Integer customer_id ,Byte status_code){
        try (Connection con = ds.getConnection();
            PreparedStatement ps = con.prepareStatement(CUSTOMER_STATUS)) {
            ps.setByte(1, status_code);
            ps.setInt(2, customer_id);
            ps.executeUpdate();
        } catch (SQLException se) {
            throw new RuntimeException("A database error occured. "
					+ se.getMessage());
        }
    }
    public CustomerVO selectByUserEmailAndPassword(String customer_email, String customer_password){
        CustomerVO cVo = new CustomerVO();
        try (Connection con = ds.getConnection();
            PreparedStatement ps = con.prepareStatement(GET_ONE_STMT)){
            ps.setString(1, customer_email);
            ps.setString(2, customer_password);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                cVo.setCustomer_id(rs.getInt("customer_id"));
                cVo.setCustomer_name(rs.getString("customer_name"));
                cVo.setCustomer_email(rs.getString("customer_email"));
                cVo.setCustomer_password(rs.getString("customer_password"));
                cVo.setCustomer_phone(rs.getString("customer_phone"));
                cVo.setCustomer_birthday(rs.getDate("customer_birthday"));
                cVo.setCustomer_gender(rs.getString("customer_gender"));
                cVo.setCustomer_address(rs.getString("customer_address"));
                cVo.setCustomer_register_time(rs.getTimestamp("customer_register_time"));
                cVo.setCustomer_status(rs.getByte("customer_status"));
            }

        } catch (SQLException se) {
            throw new RuntimeException("A database error occured. "
					+ se.getMessage());
        }
        return cVo;
    }
    // public List<CustomerVO> getAll(){
    //     return null;
    // }
}
