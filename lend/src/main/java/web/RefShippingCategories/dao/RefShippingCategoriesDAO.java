package web.RefShippingCategories.dao;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;

/* import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource; */

import org.hibernate.Session;

import ProjectInterfaces.RefShippingCategoriesInterface;
import web.RefShippingCategories.vo.RefShippingCategoriesVO;


public class RefShippingCategoriesDAO implements RefShippingCategoriesInterface<RefShippingCategoriesVO> {
	private Session s;
	public RefShippingCategoriesDAO(Session s){
		this.s = s;
	}
	/* private static final String INSERT = "INSERT INTO `TEAM4`.`Ref_Shipping_Categories`" 
			+"(`delivery_method_code`,`delivery_category_description`)" 
			+"VALUES" 
			+"(?,?);";
	private static final String UPDATE = "UPDATE `TEAM4`.`Ref_Shipping_Categories`"
			+"SET"
			+"`delivery_method_code` = ?,`delivery_category_description` = ?"
			+"WHERE `delivery_method_code` = ?;";
	private static final String GET_ALL_SHIPPING = "SELECT * FROM TEAM4.Ref_Shipping_Categories WHERE `delivery_method_code` = ?;"; */
	public void insert(RefShippingCategoriesVO rVo){
		// Hibernate
		if(rVo != null){
			RefShippingCategoriesVO check = this.s.get(RefShippingCategoriesVO.class, rVo.getShippingMethodCode());
			if(check == null){
				this.s.save(rVo);
			}
		}
		// DataSource Jdbc
		/* try (Connection con = ds.getConnection();
			PreparedStatement ps = con.prepareStatement(INSERT)) {
			ps.setInt(1, rVo.getShippingMethodCode());
			ps.setString(2, rVo.getShippingCategoryDescription());
			ps.executeUpdate();
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
	    }  */
	}
	public void update(RefShippingCategoriesVO rVo){
		// JPA CriteriaQuery
		CriteriaBuilder cb = this.s.getCriteriaBuilder();
		CriteriaUpdate<RefShippingCategoriesVO> cu = cb.createCriteriaUpdate(RefShippingCategoriesVO.class);
		Root<RefShippingCategoriesVO> root = cu.from(RefShippingCategoriesVO.class);
		cu = cu.set(root.get("shippingCategoryDescription"), rVo.getShippingCategoryDescription())
			   .where(cb.equal(root.get("shippingMethodCode"), rVo.getShippingMethodCode()));
		this.s.createQuery(cu).executeUpdate();
		// Hibernate
		/* if(rVo != null){
			RefShippingCategoriesVO update = this.s.get(RefShippingCategoriesVO.class, rVo.getShippingMethodCode());
			if(update != null){
				update.setShippingCategoryDescription(rVo.getShippingCategoryDescription());
				this.s.save(update);
			}
		} */
		// DataSource Jdbc
		/* try (Connection con = ds.getConnection();
			PreparedStatement ps = con.prepareStatement(UPDATE)) {
			ps.setInt(1, rVo.getShippingMethodCode());
			ps.setString(2, rVo.getShippingCategoryDescription());
			ps.executeUpdate();
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
	    } */ 
	}
	public RefShippingCategoriesVO selectByShippingMethodCode(Integer shippingMethodCode) {
		// JPA CriteriaQuery
		CriteriaBuilder cb = this.s.getCriteriaBuilder();
		CriteriaQuery<RefShippingCategoriesVO> cq = cb.createQuery(RefShippingCategoriesVO.class);
		Root<RefShippingCategoriesVO> root = cq.from(RefShippingCategoriesVO.class);
		cq = cq.where(cb.equal(root.get("shippingMethodCode"), shippingMethodCode));
		return this.s.createQuery(cq).getSingleResult();
		// Hibernate
		/* if(shippingMethodCode != null){
			return this.s.get(RefShippingCategoriesVO.class, shippingMethodCode);
		}
		return null; */
		// DataSource Jdbc
		/* RefShippingCategoriesVO rVo = new RefShippingCategoriesVO();
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
		return rVo; */
	}
}
