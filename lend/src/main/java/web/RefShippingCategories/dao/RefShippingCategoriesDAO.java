package web.RefShippingCategories.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import ProjectInterfaces.RefShippingCategoriesInterface;
import web.RefShippingCategories.vo.RefShippingCategoriesVO;


public class RefShippingCategoriesDAO implements RefShippingCategoriesInterface<RefShippingCategoriesVO> {
	private static DataSource ds = null;
	static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/ProjectDB");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
		private static final String INSERT = "INSERT INTO `TEAM4`.`Ref_Shipping_Categories`" 
				+"(`delivery_method_code`,`delivery_category_description`)" 
				+"VALUES" 
				+"(?,?);";
		private static final String UPDATE = "UPDATE `TEAM4`.`Ref_Shipping_Categories`"
			    +"SET"
			    +"`delivery_method_code` = ?,`delivery_category_description` = ?"
			    +"WHERE `delivery_method_code` = ?;";
		private static final String GET_ALL_SHIPPING = "SELECT * FROM TEAM4.Ref_Shipping_Categories WHERE `delivery_method_code` = ?;";
		public void insert(RefShippingCategoriesVO rVo){
	        try (Connection con = ds.getConnection();
	            PreparedStatement ps = con.prepareStatement(INSERT)) {
	            ps.setInt(1, rVo.getShippingMethodCode());
	            ps.setString(2, rVo.getShippingCategoryDescription());
	            ps.executeUpdate();
	        } catch (SQLException se) {
	            throw new RuntimeException("A database error occured. "
						+ se.getMessage());
	    } 
	}
		public void update(RefShippingCategoriesVO rVo){
	        try (Connection con = ds.getConnection();
	            PreparedStatement ps = con.prepareStatement(UPDATE)) {
	            ps.setInt(1, rVo.getShippingMethodCode());
	            ps.setString(2, rVo.getShippingCategoryDescription());
	            ps.executeUpdate();
	        } catch (SQLException se) {
	            throw new RuntimeException("A database error occured. "
						+ se.getMessage());
	    } 
	}
		public RefShippingCategoriesVO selectByShippingMethodCode(Integer shippingMethodCode) {

			RefShippingCategoriesVO rVo = new RefShippingCategoriesVO();
	        try (Connection con = ds.getConnection();
	            PreparedStatement ps = con.prepareStatement(GET_ALL_SHIPPING)) {
	            ps.setInt(1, shippingMethodCode);
	            ResultSet rs = ps.executeQuery();
	            while(rs.next()){
	                rVo.setShippingMethodCode(rs.getInt("delivery_method_code"));
	                rVo.setShippingCategoryDescription(rs.getString("delivery_category_description"));
	            }
	        } catch (SQLException se) {
	            throw new RuntimeException("A database error occured. "
	            + se.getMessage());
	        }
	        return rVo;
	    }
}
