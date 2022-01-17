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
            ps.setInt(1, customerVo.getCustomerId());
            ps.setString(2, customerVo.getCustomerName());
            ps.setString(3, customerVo.getCustomerEmail());
            ps.setString(4, customerVo.getCustomerPassword());
            ps.setString(5, customerVo.getCustomerPhone());
            ps.setDate(6, customerVo.getCustomerBirthday());
            ps.setString(7, customerVo.getCustomerGender());
            ps.setString(8, customerVo.getCustomerAddress());
            ps.setTimestamp(9, customerVo.getCustomerRegisterTime());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void update(CustomerVO customerVo){
        try (Connection con = ds.getConnection();
            PreparedStatement ps = con.prepareStatement(UPDATE)) {
            ps.setInt(1, customerVo.getCustomerId());
            ps.setString(2, customerVo.getCustomerName());
            ps.setString(3, customerVo.getCustomerEmail());
            ps.setString(4, customerVo.getCustomerPassword());
            ps.setString(5, customerVo.getCustomerPhone());
            ps.setDate(6, customerVo.getCustomerBirthday());
            ps.setString(7, customerVo.getCustomerGender());
            ps.setString(8, customerVo.getCustomerAddress());
            ps.setInt(9, customerVo.getCustomerId());
            ps.executeUpdate();
        } catch (SQLException se) {
            throw new RuntimeException("A database error occured. "
					+ se.getMessage());
        }
    }
    public void delete(Integer customerId){
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = ds.getConnection();
            con.setAutoCommit(false);
            ps = con.prepareStatement(DELETE);
            ps.setInt(1, customerId);
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
    public void changeStatus(Integer customerId ,Byte statusCode){
        try (Connection con = ds.getConnection();
            PreparedStatement ps = con.prepareStatement(CUSTOMER_STATUS)) {
            ps.setByte(1, statusCode);
            ps.setInt(2, customerId);
            ps.executeUpdate();
        } catch (SQLException se) {
            throw new RuntimeException("A database error occured. "
					+ se.getMessage());
        }
    }
    public CustomerVO selectByUserEmailAndPassword(String customerEmail, String customerPassword){
        CustomerVO cVo = new CustomerVO();
        try (Connection con = ds.getConnection();
            PreparedStatement ps = con.prepareStatement(GET_ONE_STMT)){
            ps.setString(1, customerEmail);
            ps.setString(2, customerPassword);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                cVo.setCustomerId(rs.getInt("customer_id"));
                cVo.setCustomerName(rs.getString("customer_name"));
                cVo.setCustomerEmail(rs.getString("customer_email"));
                cVo.setCustomerPassword(rs.getString("customer_password"));
                cVo.setCustomerPhone(rs.getString("customer_phone"));
                cVo.setCustomerBirthday(rs.getDate("customer_birthday"));
                cVo.setCustomerGender(rs.getString("customer_gender"));
                cVo.setCustomerAddress(rs.getString("customer_address"));
                cVo.setCustomerRegisterTime(rs.getTimestamp("customer_register_time"));
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
