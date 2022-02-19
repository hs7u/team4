package web.RefProductTag.dao;

/* import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource; */
import java.util.ArrayList;

import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import ProjectInterfaces.RefProductTagInterface;
import web.RefProductTag.vo.RefProductTagVO;

@Repository
public class RefProductTagDAO implements RefProductTagInterface<RefProductTagVO>{
    // @Autowired
    // private SessionFactory sf;
    @PersistenceContext
    private Session s;
    public Session getSession() {
		// return sf.getCurrentSession();
		return s;
	}
    // public RefProductTagDAO(Session s){
    //     getSession() = s;
    // }
    /* private static final String INSERT = "INSERT INTO `TEAM4`.`Ref_Product_Tag`"
    +"(`product_category_code`,`product_id`)"
    +"VALUES"
    +"(?,?);";
    private static final String UPDATE = "UPDATE `TEAM4`.`Ref_Product_Tag`"
    +"SET"
    +"`serial_number` = ?,`product_category_code` = ?,`product_id` = ?"
    +"WHERE `serial_number` = ?;";
    private static final String GET_ALL_TAG = "SELECT * FROM TEAM4.Ref_Product_Tag WHERE `product_id` = ?;"; */
    public void insert(RefProductTagVO rVo){
        // Hibernate
        if(rVo != null){
            RefProductTagVO check = getSession().get(RefProductTagVO.class, rVo.getSerialNumber());
            if(check == null){
                getSession().save(rVo);
            }
        }
        // DataSource Jdbc
        /* try (Connection con = ds.getConnection();
            PreparedStatement ps = con.prepareStatement(INSERT)) {
            ps.setInt(1, rVo.getProductCategoryCode());
            ps.setInt(2, rVo.getProductId());
            ps.executeUpdate();
        } catch (SQLException se) {
            throw new RuntimeException("A database error occured. "
            + se.getMessage());
        } */
    }
    public void update(RefProductTagVO rVo){
        // JPA CriteriaQuery
        CriteriaBuilder cb = getSession().getCriteriaBuilder();
        CriteriaUpdate<RefProductTagVO> cu = cb.createCriteriaUpdate(RefProductTagVO.class);
        Root<RefProductTagVO> root = cu.from(RefProductTagVO.class);
        cu = cu.set(root.get("productCategoryCode"), rVo.getProductCategoryCode())
               .set(root.get("productId"), rVo.getProductId())
               .where(cb.equal(root.get("serialNumber"), rVo.getSerialNumber()));
        getSession().createQuery(cu).executeUpdate();
        // Hibernate
        /* if(rVo != null){
            RefProductTagVO check = getSession().get(RefProductTagVO.class, rVo.getSerialNumber());
            if(check != null){
                check.setProductCategoryCode(rVo.getProductCategoryCode());
                check.setProductId(rVo.getProductId());
                getSession().save(check);
            }
        } */
        // DataSource Jdbc
        /* try (Connection con = ds.getConnection();
            PreparedStatement ps = con.prepareStatement(UPDATE)) {
            ps.setInt(1, rVo.getSerialNumber());
            ps.setInt(2, rVo.getProductCategoryCode());
            ps.setInt(3, rVo.getProductId());
            ps.setInt(4, rVo.getSerialNumber());
            ps.executeUpdate();
        } catch (SQLException se) {
            throw new RuntimeException("A database error occured. "
            + se.getMessage());
        } */
    }
    public ArrayList<Integer> selectByProductId(Integer productId){
        // JPA CriteriaQuery
        CriteriaBuilder cb = getSession().getCriteriaBuilder();
        CriteriaQuery<RefProductTagVO> cq = cb.createQuery(RefProductTagVO.class);
        Root<RefProductTagVO> root = cq.from(RefProductTagVO.class);
        cq = cq.where(cb.equal(root.get("productId"), productId));
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(RefProductTagVO rVo : getSession().createQuery(cq).getResultList()){
            list.add(rVo.getProductCategoryCode());
        }
        return list;
        // DataSource Jdbc
        /* ArrayList<Integer> list = new ArrayList<Integer>();
        try (Connection con = ds.getConnection();
            PreparedStatement ps = con.prepareStatement(GET_ALL_TAG)) {
            ps.setInt(1, productId);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                list.add(rs.getInt("product_category_code"));
            }
        } catch (SQLException se) {
            throw new RuntimeException("A database error occured. "
            + se.getMessage());
        }
        return list; */
    }
}
