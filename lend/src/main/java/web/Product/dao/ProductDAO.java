package web.Product.dao;

import java.util.ArrayList;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

/* import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource; */

import ProjectInterfaces.ProductInterface;
import web.Product.vo.ProductVO;

public class ProductDAO implements ProductInterface<ProductVO>{
    private Session s;
    public ProductDAO(Session s){
        this.s = s;
    }
    /* private static final String INSERT_STMT = "INSERT INTO `TEAM4`.`Product`"
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
    +"WHERE `product_id` = ?;"; */
    public void insert(ProductVO pVo){
        // Hibernate
        if(pVo != null){
            ProductVO newProduct = this.s.get(ProductVO.class, pVo.getProductId());
            if(newProduct == null){
                this.s.save(pVo);
            }
        }
        // DateSource Jdbc
        /* try (Connection con = ds.getConnection();
            PreparedStatement ps = con.prepareStatement(INSERT_STMT)) {
            ps.setInt(1, pVo.getProductId());
            ps.setInt(2, pVo.getProductCategoryCode());
            ps.setInt(3, pVo.getProductPrice());
            ps.setString(4, pVo.getProductName());
            ps.setBytes(5, pVo.getProductImage());
            ps.setString(6, pVo.getProductDescription());
            ps.setInt(7, pVo.getProductInventory());
            ps.setInt(8, pVo.getProductSold());
            ps.setTimestamp(9, pVo.getReleasedTime());
            ps.setByte(10, pVo.getCustomization());
            ps.setInt(11, pVo.getCustomerProductPrice());
            ps.executeUpdate();
        } catch (SQLException se) {
            throw new RuntimeException("A database error occured. "
            + se.getMessage());
        } */
    }
    public void update(ProductVO pVo){
        // JPA Criteria
        CriteriaBuilder cb = this.s.getCriteriaBuilder();
        CriteriaUpdate<ProductVO> cu = cb.createCriteriaUpdate(ProductVO.class);
        Root<ProductVO> root = cu.from(ProductVO.class);
        cu = cu.set(root.get("product_id"), pVo.getProductId())
               .set(root.get("product_category_code"), pVo.getProductCategoryCode())
               .set(root.get("product_price"), pVo.getProductPrice())
               .set(root.get("product_name"), pVo.getProductName())
               .set(root.get("product_image"), pVo.getProductImage())
               .set(root.get("product_description"), pVo.getProductDescription())
               .set(root.get("product_inventory"), pVo.getProductInventory())
               .set(root.get("product_sold"), pVo.getProductSold())
               .set(root.get("released_time"), pVo.getReleasedTime())
               .set(root.get("customization"), pVo.getCustomization())
               .set(root.get("custom_product_price"), pVo.getCustomerProductPrice())
               .set(root.get("product_status"), pVo.getProductStatus());
        this.s.createQuery(cu).executeUpdate();
        // Hibernate
        /* ProductVO productVo = this.s.get(ProductVO.class, pVo.getProductId());
        if(productVo != null){
            productVo.setProductId(pVo.getProductId());
            productVo.setProductCategoryCode(pVo.getProductCategoryCode());
            productVo.setProductPrice(pVo.getProductPrice());
            productVo.setProductName(pVo.getProductName());
            productVo.setProductImage(pVo.getProductImage());
            productVo.setProductDescription(pVo.getProductDescription());
            productVo.setProductInventory(pVo.getProductInventory());
            productVo.setProductSold(pVo.getProductSold());
            productVo.setReleasedTime(pVo.getReleasedTime());
            productVo.setCustomization(pVo.getCustomization());
            productVo.setCustomerProductPrice(pVo.getCustomerProductPrice());
            this.s.save(productVo);
        } */
        // DateSource Jdbc
        /* try (Connection con = ds.getConnection();
            PreparedStatement ps = con.prepareStatement(UPDATE)) {
            ps.setInt(1, pVo.getProductId());
            ps.setInt(2, pVo.getProductCategoryCode());
            ps.setInt(3, pVo.getProductPrice());
            ps.setString(4, pVo.getProductName());
            ps.setBytes(5, pVo.getProductImage());
            ps.setString(6, pVo.getProductDescription());
            ps.setInt(7, pVo.getProductInventory());
            ps.setInt(8, pVo.getProductSold());
            ps.setTimestamp(9, pVo.getReleasedTime());
            ps.setByte(10, pVo.getCustomization());
            ps.setInt(11, pVo.getCustomerProductPrice());
            ps.setInt(12, pVo.getProductId());
            ps.executeUpdate();
        } catch (SQLException se) {
            throw new RuntimeException("A database error occured. "
            + se.getMessage());
        } */
    }
    public void delete(Integer productId){
        // JPA Criteria
        CriteriaBuilder cb = this.s.getCriteriaBuilder();
        CriteriaDelete<ProductVO> cd = cb.createCriteriaDelete(ProductVO.class);
        Root<ProductVO> root = cd.from(ProductVO.class);
        cd = cd.where(cb.equal(root.get("product_id"), productId));
        this.s.createQuery(cd).executeUpdate();
        // Hibernate
        ProductVO pVo = this.s.get(ProductVO.class, productId);
        if(pVo != null){
            this.s.delete(pVo);
        }
        // DateSource Jdbc
        /* Connection con = null;
        PreparedStatement ps = null;
        try {
            con = ds.getConnection();
            con.setAutoCommit(false);
            ps = con.prepareStatement(DELETE);
            ps.setInt(1, productId);
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
        } */
    }
    public void sold(Integer productId, Integer sold){
        // JPA Criteria
        // Hibernate
        ProductVO pVo = this.s.get(ProductVO.class, productId);
        if(pVo != null){
            pVo.setProductSold(sold);
            this.s.save(pVo);
        }
        // DateSource Jdbc
        /* try (Connection con = ds.getConnection();
            PreparedStatement ps = con.prepareStatement(PRODUCT_SOLD)) {
            ps.setInt(1, sold);
            ps.setInt(2, productId);
            ps.executeUpdate();
        } catch (SQLException se) {
            throw new RuntimeException("A database error occured. "
            + se.getMessage());
        } */
    }
    public void changeStatus(Integer productId, Byte statusCode){
        // JPA Criteria
        CriteriaBuilder cb = this.s.getCriteriaBuilder();
        CriteriaUpdate<ProductVO> cu = cb.createCriteriaUpdate(ProductVO.class);
        Root<ProductVO> root = cu.from(ProductVO.class);
        cu = cu.where(cb.and(cb.equal(root.get("product_id"), productId),
                             cb.equal(root.get("product_status"), statusCode)
                            )
                     );
        this.s.createQuery(cu).executeUpdate();
        // Hibernate
        /* ProductVO pVo = this.s.get(ProductVO.class, productId);
        if(pVo != null){
            pVo.setProductStatus(statusCode);
            this.s.save(pVo);
        } */
        // DateSource Jdbc
        /* try (Connection con = ds.getConnection();
            PreparedStatement ps = con.prepareStatement(CHANGE_STATUS)) {
            ps.setByte(1, statusCode);
            ps.setInt(2, productId);
            ps.executeUpdate();
        } catch (SQLException se) {
            throw new RuntimeException("A database error occured. "
            + se.getMessage());
        } */
    }
    public ProductVO selectByProductName(String productName){
        // JPA Criteria
        CriteriaBuilder cb = this.s.getCriteriaBuilder();
        CriteriaQuery<ProductVO> cq = cb.createQuery(ProductVO.class);
        Root<ProductVO> root = cq.from(ProductVO.class);
        
        cq = cq.where(cb.like(root.get("product_name"), "%"+productName+"%"));
        
        try {
			return this.s.createQuery(cq).getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
        // DateSource Jdbc
        /* ProductVO pVo = new ProductVO();
        try (Connection con = ds.getConnection();
            PreparedStatement ps = con.prepareStatement(GET_ONE_STMT)) {
            ps.setString(1, productName);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                pVo.setProductId(rs.getInt("product_id"));
		        pVo.setProductCategoryCode(rs.getInt("product_category_code"));
		        pVo.setProductPrice(rs.getInt("product_price"));
		        pVo.setProductName(rs.getString("product_name"));
		        pVo.setProductImage(rs.getBytes("product_image"));
		        pVo.setProductDescription(rs.getString("product_description"));
		        pVo.setProductInventory(rs.getInt("product_inventory"));
		        pVo.setProductSold(rs.getInt("product_sold"));
		        pVo.setReleasedTime(rs.getTimestamp("released_time"));
		        pVo.setCustomization(rs.getByte("customization"));
		        pVo.setCustomerProductPrice(rs.getInt("customer_product_price"));
		        pVo.setProductStatus(rs.getByte("product_status"));
            }
        } catch (SQLException se) {
            throw new RuntimeException("A database error occured. "
            + se.getMessage());
        }
        return pVo; */
    }
    public ArrayList<ProductVO> getAllProduct(){
        // JPA CtiteriaQuery
        CriteriaBuilder cb = this.s.getCriteriaBuilder();
        CriteriaQuery<ProductVO> cq = cb.createQuery(ProductVO.class);
        Root<ProductVO> root = cq.from(ProductVO.class);
        cq = cq.select(root);
        ArrayList<ProductVO> list = new ArrayList<ProductVO>();
        for(ProductVO pVo : this.s.createQuery(cq).getResultList()){
            list.add(pVo);
        }
        return list;
    }
}
