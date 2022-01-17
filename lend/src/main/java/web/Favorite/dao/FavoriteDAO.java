package web.Favorite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import ProjectInterfaces.FavoriteInterface;
import web.Favorite.vo.FavoriteVO;

public class FavoriteDAO implements FavoriteInterface<FavoriteVO>{
    private static DataSource ds = null;
    static{
        try {
            Context ctx = new InitialContext();
            ds = (DataSource) ctx.lookup("java:comp/env/jdbc/ProjectDB");
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }
    private static final String INSERT = "INSERT INTO `TEAM4`.`Favorite`"
    +"(`customer_id`,`product_id`)"
    +"VALUES"
    +"(?,?);";
    private static final String DELETE = "DELETE FROM `TEAM4`.`Favorite` WHERE `customer_id` = ? AND `product_id` = ?;";
    private static final String GET_ALL_STM = "SELECT `Favorite`.`product_id` FROM `TEAM4`.`Favorite` WHERE `customer_id` = ?;";
    public void insert(FavoriteVO fVo){
        try (Connection con = ds.getConnection();
            PreparedStatement ps = con.prepareStatement(INSERT)) {
            ps.setInt(1, fVo.getCustomer_id());
            ps.setInt(2, fVo.getProduct_id());
            ps.executeUpdate();
        } catch (SQLException se) {
            throw new RuntimeException("A database error occured. "
            + se.getMessage());
        }
    }
    public void delete(Integer customer_id, Integer product_id){
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = ds.getConnection();
            con.setAutoCommit(false);
            ps = con.prepareStatement(DELETE);
            ps.setInt(1, customer_id);
            ps.setInt(2, product_id);
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
    public ArrayList<Integer> selectByCustomerId(Integer customer_id){
        ArrayList<Integer> list = new ArrayList<Integer>();
        try (Connection con = ds.getConnection();
            PreparedStatement ps = con.prepareStatement(GET_ALL_STM)) {
            ps.setInt(1, customer_id);
            ResultSet rs =  ps.executeQuery();
            while(rs.next()){
                list.add(rs.getInt("product_id"));
            }
        } catch (SQLException se) {
            throw new RuntimeException("A database error occured. "
            + se.getMessage());
        }
        return list;
    }
}
