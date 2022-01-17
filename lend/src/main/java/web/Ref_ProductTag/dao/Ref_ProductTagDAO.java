package web.Ref_ProductTag.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import ProjectInterfaces.Ref_ProductTagInterface;
import web.Ref_ProductTag.vo.Ref_ProductTagVO;

public class Ref_ProductTagDAO implements Ref_ProductTagInterface<Ref_ProductTagVO>{
    private static DataSource ds = null;
    static{
        try {
            Context ctx = new InitialContext();
            ds = (DataSource) ctx.lookup("java:comp/env/jdbc/ProjectDB");
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }
    private static final String INSERT = "INSERT INTO `TEAM4`.`Ref_Product_Tag`"
    +"(`product_category_code`,`product_id`)"
    +"VALUES"
    +"(?,?);";
    private static final String UPDATE = "UPDATE `TEAM4`.`Ref_Product_Tag`"
    +"SET"
    +"`serial_number` = ?,`product_category_code` = ?,`product_id` = ?"
    +"WHERE `serial_number` = ?;";
    private static final String GET_ALL_TAG = "SELECT * FROM TEAM4.Ref_Product_Tag WHERE `product_id` = ?;";
    public void insert(Ref_ProductTagVO rVo){
        try (Connection con = ds.getConnection();
            PreparedStatement ps = con.prepareStatement(INSERT)) {
            ps.setInt(1, rVo.getProduct_category_code());
            ps.setInt(2, rVo.getProduct_id());
            ps.executeUpdate();
        } catch (SQLException se) {
            throw new RuntimeException("A database error occured. "
            + se.getMessage());
        }
    }
    public void update(Ref_ProductTagVO rVo){
        try (Connection con = ds.getConnection();
            PreparedStatement ps = con.prepareStatement(UPDATE)) {
            ps.setInt(1, rVo.getSerial_number());
            ps.setInt(2, rVo.getProduct_category_code());
            ps.setInt(3, rVo.getProduct_id());
            ps.setInt(4, rVo.getSerial_number());
            ps.executeUpdate();
        } catch (SQLException se) {
            throw new RuntimeException("A database error occured. "
            + se.getMessage());
        }
    }
    public ArrayList<Integer> selectByProductId(Integer product_id){
        ArrayList<Integer> list = new ArrayList<Integer>();
        try (Connection con = ds.getConnection();
            PreparedStatement ps = con.prepareStatement(GET_ALL_TAG)) {
            ps.setInt(1, product_id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                list.add(rs.getInt("product_category_code"));
            }
        } catch (SQLException se) {
            throw new RuntimeException("A database error occured. "
            + se.getMessage());
        }
        return list;
    }
}
