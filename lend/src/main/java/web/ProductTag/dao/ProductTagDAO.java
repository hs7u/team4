package web.ProductTag.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import ProjectInterfaces.ProductTagInterface;
import web.ProductTag.vo.ProductTagVO;

public class ProductTagDAO implements ProductTagInterface<ProductTagVO>{
    private static DataSource ds = null;
    static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/ProjectDB");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
    private static final String INSERT = "INSERT INTO `TEAM4`.`Product_Tag`"
    +"(`product_category_code`,`product_label_name`)"
    +"VALUES"
    +"(?,?);";
    private static final String UPDATE = "UPDATE `TEAM4`.`Product_Tag`"
    +"SET"
    +"`product_category_code` = ?,`product_label_name` = ?"
    +"WHERE `product_category_code` = ?;";
    private static final String GET_ONE_TAG = "SELECT * FROM TEAM4.Product_Tag WHERE `product_category_code` = ?;";
    public void insert(ProductTagVO pVo){
        try (Connection con = ds.getConnection();
            PreparedStatement ps = con.prepareStatement(INSERT)) {
            ps.setInt(1, pVo.getProductCategoryCode());
            ps.setString(2, pVo.getProductTagName());
            ps.executeUpdate();
        } catch (SQLException se) {
            throw new RuntimeException("A database error occured. "
            + se.getMessage());
        }
    }
    public void update(ProductTagVO pVo){
        try (Connection con = ds.getConnection();
            PreparedStatement ps = con.prepareStatement(UPDATE)) {
            ps.setInt(1, pVo.getProductCategoryCode());
            ps.setString(2, pVo.getProductTagName());
            ps.setInt(3, pVo.getProductCategoryCode());
            ps.executeUpdate();
        } catch (SQLException se) {
            throw new RuntimeException("A database error occured. "
            + se.getMessage());
        }
    
    }
    public ProductTagVO selectOneTag(Integer productCategoryCode){
        ProductTagVO pVo = new ProductTagVO();
        try (Connection con = ds.getConnection();
            PreparedStatement ps = con.prepareStatement(GET_ONE_TAG)) {
            ps.setInt(1, productCategoryCode);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                pVo.setProductCategoryCode(rs.getInt("product_category_code"));
                pVo.setProductTagName(rs.getString("product_tag_name"));
            }
        } catch (SQLException se) {
            throw new RuntimeException("A database error occured. "
            + se.getMessage());
        }
    
        return pVo;
    }
}
