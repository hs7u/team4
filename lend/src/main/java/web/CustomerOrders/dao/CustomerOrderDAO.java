package web.CustomerOrders.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import ProjectInterfaces.CustomerOrderInterface;
import web.CustomerOrders.vo.CustomerOrdersVO;

public class CustomerOrderDAO implements CustomerOrderInterface<CustomerOrdersVO>{
    private static DataSource ds = null;
    static{
        try {
            Context ctx = new InitialContext();
            ds = (DataSource) ctx.lookup("java:comp/env/jdbc/ProjectDB");
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }
    private static final String INSERT_STMT = "INSERT INTO `TEAM4`.`Customer_Orders`"
    +"(`order_id`,`customer_id`,`shipping_method_code`,`order_created_date`,`order_delivery_charge`,`order_shipping_date`,`recipient`,`senders_address`,`order_detials`)"
    +"VALUES"
    +"(?,?,?,?,?,?,?,?,?);";
    private static final String UPDATE = "UPDATE `TEAM4`.`Customer_Orders`"
    +"SET"
    +"`order_id` = ?,`customer_id` = ?,`shipping_mothod_code` = ?,`order_delivery_charge` = ?,`order_shipping_date`,`recipient` = ?,`senders_address` = ?,`order_details` = ?"
    +"WHERE `order_id` = ?;";
    private static final String DELETE = "DELETE FROM `TEAM4`.`Customer_Orders` WHERE `order_id` = ?;";
    private static final String GET_ONE_STMT = "SELECT * FROM TEAM4.Customer_Orders WHERE `order_id` = ?";
    private static final String UPDATEORDERSTATUS = "UPDATE `TEAM4`.`Customer_Orders`"
    +"SET"
    +"order_status` = ?"
    +"WHERE `order_id` = ?;";
    private static final String UPDATEPAYMENTSTATUS = "UPDATE `TEAM4`.`Customer_Orders`"
    +"SET"
    +"payment_status` = ?"
    +"WHERE `order_id` = ?;";
    private static final String UPDATESHIPPINGSTATUS = "UPDATE `TEAM4`.`Customer_Orders`"
    +"SET"
    +"`shipping_status` = ?"
    +"WHERE `order_id` = ?;";
    private static final String RETURNORDER = "UPDATE `TEAM4`.`Customer_Orders`"
    +"SET"
    +"`return_status` = ?"
    +"WHERE `order_id` = ?;";
    public void insert(CustomerOrdersVO coVo){
        try (Connection con = ds.getConnection();
            PreparedStatement ps = con.prepareStatement(INSERT_STMT)) {
            ps.setInt(1, coVo.getOrder_id());
            ps.setInt(2, coVo.getCustomer_id());
            ps.setInt(3, coVo.getShipping_mothod_code());
            ps.setTimestamp(4, coVo.getOrder_created_date());
            ps.setInt(5, coVo.getOrder_delivery_charge());
            ps.setTimestamp(6, coVo.getOrder_shipping_date());
            ps.setString(7, coVo.getRecipint());
            ps.setString(8, coVo.getSenders_address());
            ps.setString(9, coVo.getOrder_details());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void update(CustomerOrdersVO coVo){
        try (Connection con = ds.getConnection();
            PreparedStatement ps = con.prepareStatement(UPDATE)) {
            ps.setInt(1, coVo.getOrder_id());
            ps.setInt(2, coVo.getCustomer_id());
            ps.setInt(3, coVo.getShipping_mothod_code());
            ps.setInt(4, coVo.getOrder_delivery_charge());
            ps.setTimestamp(5, coVo.getOrder_shipping_date());
            ps.setString(6, coVo.getRecipint());    
            ps.setString(7, coVo.getSenders_address());    
            ps.setString(8, coVo.getOrder_details());
            ps.setInt(9, coVo.getCustomer_id());
            ps.executeUpdate();
        } catch (SQLException se) {
            throw new RuntimeException("A database error occured. "
					+ se.getMessage());
        }
    }
    public void delete(Integer order_id){
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = ds.getConnection();
            con.setAutoCommit(false);
            ps = con.prepareStatement(DELETE);
            ps.setInt(1, order_id);
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
    public void updateStatus(String status_name, Integer order_id, Byte status_code) {
        String sql = null;
        switch (status_name) {
            case "order_status":
                sql = UPDATEORDERSTATUS;
                break;
            case "payment_status":
                sql = UPDATEPAYMENTSTATUS;
                break;
            case "shipping_status":
                sql = UPDATESHIPPINGSTATUS;
                break;
            case "return_status":
                sql = RETURNORDER;
                break;
            default:
                break;
        }
        try (Connection con = ds.getConnection();
            PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setByte(1, status_code);
            ps.setInt(2, order_id);
            ps.executeUpdate();
        } catch (SQLException se) {
            throw new RuntimeException("A database error occured. "
            + se.getMessage());
        }
    }
    public CustomerOrdersVO selectByOrderId(Integer order_id){
        CustomerOrdersVO coVo = new CustomerOrdersVO();
        try (Connection con = ds.getConnection();
            PreparedStatement ps = con.prepareStatement(GET_ONE_STMT)) {
            ps.setInt(1, order_id);
            ResultSet rs =  ps.executeQuery();
            while (rs.next()) {
                coVo.setOrder_id(rs.getInt("order_id"));
                coVo.setCustomer_id(rs.getInt("customer_id"));
                coVo.setShipping_mothod_code(rs.getInt("shipping_mothod_code"));
                coVo.setOrder_created_date(rs.getTimestamp("order_created_date")); 
                coVo.setOrder_delivery_charge(rs.getInt("order_delivery_charge"));
                coVo.setOrder_shipping_date(rs.getTimestamp("order_shipping_date")); 
                coVo.setRecipient(rs.getString("recipient"));
                coVo.setSenders_address(rs.getString("senders_address"));
                coVo.setOrder_details(rs.getString("order_details"));
                coVo.setOrder_status(rs.getByte("order_status"));
                coVo.setPayment_status(rs.getByte("payment_status"));
                coVo.setShipping_status(rs.getByte("shipping_status"));
                coVo.setReturn_status(rs.getByte("return_status"));
            }
        } catch (SQLException se) {
            throw new RuntimeException("A database error occured. "
					+ se.getMessage());
        }
        return coVo;
    }
}
