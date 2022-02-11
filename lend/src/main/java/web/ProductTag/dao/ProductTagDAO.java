package web.ProductTag.dao;

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

import ProjectInterfaces.ProductTagInterface;
import web.ProductTag.vo.ProductTagVO;

public class ProductTagDAO implements ProductTagInterface<ProductTagVO>{
    private Session s;
    public ProductTagDAO(Session s){
        this.s = s;
    }
    /* private static final String INSERT = "INSERT INTO `TEAM4`.`Product_Tag`"
    +"(`product_category_code`,`product_label_name`)"
    +"VALUES"
    +"(?,?);";
    private static final String UPDATE = "UPDATE `TEAM4`.`Product_Tag`"
    +"SET"
    +"`product_category_code` = ?,`product_label_name` = ?"
    +"WHERE `product_category_code` = ?;";
    private static final String GET_ONE_TAG = "SELECT * FROM TEAM4.Product_Tag WHERE `product_category_code` = ?;"; */
    public void insert(ProductTagVO pVo){
        // Hibernate
        if(pVo != null){
            ProductTagVO check = this.s.get(ProductTagVO.class, pVo.getProductCategoryCode());
            if(check == null){
                this.s.save(pVo);
            }
        }
        // DataSource Jdbc
        /* try (Connection con = ds.getConnection();
            PreparedStatement ps = con.prepareStatement(INSERT)) {
            ps.setInt(1, pVo.getProductCategoryCode());
            ps.setString(2, pVo.getProductTagName());
            ps.executeUpdate();
        } catch (SQLException se) {
            throw new RuntimeException("A database error occured. "
            + se.getMessage());
        } */
    }
    public void update(ProductTagVO pVo){
        // JPA CriteriaQuery
        CriteriaBuilder cb = this.s.getCriteriaBuilder();
        CriteriaUpdate<ProductTagVO> cu = cb.createCriteriaUpdate(ProductTagVO.class);
        Root<ProductTagVO> root = cu.from(ProductTagVO.class);
        cu = cu.set(root.get("productTagName"), pVo.getProductTagName())
               .where(cb.equal(root.get("productCategoryCode"), pVo.getProductCategoryCode()));
        this.s.createQuery(cu).executeUpdate();
        // Hibernate
        /* if(pVo != null){
            ProductTagVO check = this.s.get(ProductTagVO.class, pVo.getProductCategoryCode());
            if(check != null){
                check.setProductTagName(pVo.getProductTagName());
                this.s.save(check);
            }
        } */
        // DataSource Jdbc
        /* try (Connection con = ds.getConnection();
            PreparedStatement ps = con.prepareStatement(UPDATE)) {
            ps.setInt(1, pVo.getProductCategoryCode());
            ps.setString(2, pVo.getProductTagName());
            ps.setInt(3, pVo.getProductCategoryCode());
            ps.executeUpdate();
        } catch (SQLException se) {
            throw new RuntimeException("A database error occured. "
            + se.getMessage());
        } */
    }
    public ProductTagVO selectOneTag(Integer productCategoryCode){
        // JPA CriteriaQuery
        CriteriaBuilder cb = this.s.getCriteriaBuilder();
        CriteriaQuery<ProductTagVO> cq = cb.createQuery(ProductTagVO.class);
        Root<ProductTagVO> root = cq.from(ProductTagVO.class);
        cq = cq.where(cb.equal(root.get("productCategoryCode"), productCategoryCode));
        return this.s.createQuery(cq).getSingleResult();
        // Hibernate
        /* if(productCategoryCode != null){
            return this.s.get(ProductTagVO.class, productCategoryCode);
        }
        return null; */
        // DataSource Jdbc
        /* ProductTagVO pVo = new ProductTagVO();
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
        return pVo; */
    }
}
