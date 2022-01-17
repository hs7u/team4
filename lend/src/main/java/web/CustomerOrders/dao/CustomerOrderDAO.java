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
    +"`order_id` = ?,`customer_id` = ?,`shipping_method_code` = ?,`order_delivery_charge` = ?,`order_shipping_date`,`recipient` = ?,`senders_address` = ?,`order_details` = ?"
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
            ps.setInt(1, coVo.getOrderId());
            ps.setInt(2, coVo.getCustomerId());
            ps.setInt(3, coVo.getShippingMethodCode());
            ps.setTimestamp(4, coVo.getOrderCreatedDate());
            ps.setInt(5, coVo.getOrderDeliveryCharge());
            ps.setTimestamp(6, coVo.getOrderShippingDate());
            ps.setString(7, coVo.getRecipint());
            ps.setString(8, coVo.getSendersAddress());
            ps.setString(9, coVo.getOrderDetails());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void update(CustomerOrdersVO coVo){
        try (Connection con = ds.getConnection();
            PreparedStatement ps = con.prepareStatement(UPDATE)) {
            ps.setInt(1, coVo.getOrderId());
            ps.setInt(2, coVo.getCustomerId());
            ps.setInt(3, coVo.getShippingMethodCode());
            ps.setInt(4, coVo.getOrderDeliveryCharge());
            ps.setTimestamp(5, coVo.getOrderShippingDate());
            ps.setString(6, coVo.getRecipint());    
            ps.setString(7, coVo.getSendersAddress());    
            ps.setString(8, coVo.getOrderDetails());
            ps.setInt(9, coVo.getCustomerId());
            ps.executeUpdate();
        } catch (SQLException se) {
            throw new RuntimeException("A database error occured. "
					+ se.getMessage());
        }
    }
    public void delete(Integer orderId){
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = ds.getConnection();
            con.setAutoCommit(false);
            ps = con.prepareStatement(DELETE);
            ps.setInt(1, orderId);
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
    public void updateStatus(String statusName, Integer orderId, Byte statusCode) {
        String sql = null;
        switch (statusName) {
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
            ps.setByte(1, statusCode);
            ps.setInt(2, orderId);
            ps.executeUpdate();
        } catch (SQLException se) {
            throw new RuntimeException("A database error occured. "
            + se.getMessage());
        }
    }
    public CustomerOrdersVO selectByOrderId(Integer orderId){
        CustomerOrdersVO coVo = new CustomerOrdersVO();
        try (Connection con = ds.getConnection();
            PreparedStatement ps = con.prepareStatement(GET_ONE_STMT)) {
            ps.setInt(1, orderId);
            ResultSet rs =  ps.executeQuery();
            while (rs.next()) {
                coVo.setOrderId(rs.getInt("order_id"));
                coVo.setCustomerId(rs.getInt("customer_id"));
                coVo.setShippingMethodCode(rs.getInt("shipping_method_code"));
                coVo.setOrderCreatedDate(rs.getTimestamp("order_created_date")); 
                coVo.setOrderDeliveryCharge(rs.getInt("order_delivery_charge"));
                coVo.setOrderShippingDate(rs.getTimestamp("order_shipping_date")); 
                coVo.setRecipient(rs.getString("recipient"));
                coVo.setSendersAddress(rs.getString("senders_address"));
                coVo.setOrderDetails(rs.getString("order_details"));
                coVo.setOrderStatus(rs.getByte("order_status"));
                coVo.setPaymentStatus(rs.getByte("payment_status"));
                coVo.setShippingStatus(rs.getByte("shipping_status"));
                coVo.setReturnStatus(rs.getByte("return_status"));
            }
        } catch (SQLException se) {
            throw new RuntimeException("A database error occured. "
					+ se.getMessage());
        }
        return coVo;
    }
}
