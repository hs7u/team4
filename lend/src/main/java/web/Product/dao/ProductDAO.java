package web.Product.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import ProjectInterfaces.ProductInterface;
import web.Product.vo.ProductVO;

public class ProductDAO implements ProductInterface<ProductVO>{
    private static DataSource ds = null;
    static{
        try {
            Context ctx = new InitialContext();
            ds = (DataSource) ctx.lookup("java:comp/env/jdbc/ProjectDB");
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }
    private static final String INSERT_STMT = "INSERT INTO `TEAM4`.`Product`"
    +"(`product_id`,`product_category_code`,`product_price`,`product_name`,`product_image`,`product_description`,`product_inventory`,`product_sold`,`released_time`,`customization`,`custom_product_price`)"
    +"VALUES"
    +"(?,?,?,?,?,?,?,?,?,?,?);";
    private static final String GET_ONE_STMT = "SELECT * FROM TEAM4.Product WHERE `product_id` = ?;";
    private static final String DELETE = "DELETE FROM `TEAM4`.`Product`WHERE `product_id` = ?;";
    private static final String UPDATE = "UPDATE `TEAM4`.`Product`"
    +"SET "
    +"`product_id` = ?,`product_category_code` = ?,`product_price` = ?,`product_name` = ?,`product_image` = ?,`product_description` = ?,`product_inventory` = ?,`product_sold` = ?,`released_time` = ?,`customization` = ?,`custom_product_price` = ?"
    +"WHERE `product_id` = ?;";
    private static final String PRODUCT_SOLD = "UPDATE `TEAM4`.`Product`"
    +"SET"
    +"`product_sold` = ?,"
    +"WHERE `product_id` = ?;";
    private static final String CHANGE_STATUS = "UPDATE `TEAM4`.`Product`"
    +"SET"
    +"`product_status` = ?"
    +"WHERE `product_id` = ?;";
    public void insert(ProductVO pVo){
        try (Connection con = ds.getConnection();
            PreparedStatement ps = con.prepareStatement(INSERT_STMT)) {
            ps.setInt(1, pVo.getProduct_id());
            ps.setInt(2, pVo.getProduct_category_code());
            ps.setInt(3, pVo.getProduct_price());
            ps.setString(4, pVo.getProduct_name());
            ps.setBytes(5, pVo.getProduct_image());
            ps.setString(6, pVo.getProduct_description());
            ps.setInt(7, pVo.getProduct_inventory());
            ps.setInt(8, pVo.getProduct_sold());
            ps.setTimestamp(9, pVo.getReleased_time());
            ps.setByte(10, pVo.getCustomization());
            ps.setInt(11, pVo.getCustomer_product_price());
            ps.executeUpdate();
        } catch (SQLException se) {
            throw new RuntimeException("A database error occured. "
            + se.getMessage());
        }
    }
    public void update(ProductVO pVo){
        try (Connection con = ds.getConnection();
            PreparedStatement ps = con.prepareStatement(UPDATE)) {
            ps.setInt(1, pVo.getProduct_id());
            ps.setInt(2, pVo.getProduct_category_code());
            ps.setInt(3, pVo.getProduct_price());
            ps.setString(4, pVo.getProduct_name());
            ps.setBytes(5, pVo.getProduct_image());
            ps.setString(6, pVo.getProduct_description());
            ps.setInt(7, pVo.getProduct_inventory());
            ps.setInt(8, pVo.getProduct_sold());
            ps.setTimestamp(9, pVo.getReleased_time());
            ps.setByte(10, pVo.getCustomization());
            ps.setInt(11, pVo.getCustomer_product_price());
            ps.setInt(12, pVo.getProduct_id());
            ps.executeUpdate();
        } catch (SQLException se) {
            throw new RuntimeException("A database error occured. "
            + se.getMessage());
        }
    }
    public void delete(Integer product_id){
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = ds.getConnection();
            con.setAutoCommit(false);
            ps = con.prepareStatement(DELETE);
            ps.setInt(1, product_id);
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
        }finally{
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
    public void sold(Integer product_id, Integer sold){
        try (Connection con = ds.getConnection();
            PreparedStatement ps = con.prepareStatement(PRODUCT_SOLD)) {
            ps.setInt(1, sold);
            ps.setInt(2, product_id);
            ps.executeUpdate();
        } catch (SQLException se) {
            throw new RuntimeException("A database error occured. "
            + se.getMessage());
        }
    }
    public void changeStatus(Integer product_id, Byte status_code){
        try (Connection con = ds.getConnection();
            PreparedStatement ps = con.prepareStatement(CHANGE_STATUS)) {
            ps.setByte(1, status_code);
            ps.setInt(2, product_id);
            ps.executeUpdate();
        } catch (SQLException se) {
            throw new RuntimeException("A database error occured. "
            + se.getMessage());
        }
    }
    public ProductVO selectByProductName(String product_name){
        ProductVO pVo = new ProductVO();
        try (Connection con = ds.getConnection();
            PreparedStatement ps = con.prepareStatement(GET_ONE_STMT)) {
            ps.setString(1, product_name);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                pVo.setProduct_id(rs.getInt("product_id"));
		        pVo.setProduct_category_code(rs.getInt("product_category_code"));
		        pVo.setProduct_price(rs.getInt("product_price"));
		        pVo.setProduct_name(rs.getString("product_name"));
		        pVo.setProduct_image(rs.getBytes("product_image"));
		        pVo.setProduct_description(rs.getString("product_description"));
		        pVo.setProduct_inventory(rs.getInt("product_inventory"));
		        pVo.setProduct_sold(rs.getInt("product_sold"));
		        pVo.setReleased_time(rs.getTimestamp("released_time"));
		        pVo.setCustomization(rs.getByte("customization"));
		        pVo.setCustomer_product_price(rs.getInt("customer_product_price"));
		        pVo.setProduct_status(rs.getByte("product_status"));
            }
        } catch (SQLException se) {
            throw new RuntimeException("A database error occured. "
            + se.getMessage());
        }
        return pVo;
    }
}
