package web.Favorite.dao;

/* import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException; */
import java.util.ArrayList;

import javax.persistence.PersistenceContext;
/* import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException; */
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
/* import javax.sql.DataSource;

import org.hibernate.Hibernate; */
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import ProjectInterfaces.FavoriteInterface;
import web.Favorite.vo.FavoriteVO;

@Repository
public class FavoriteDAO implements FavoriteInterface<FavoriteVO>{
    // @Autowired
    // private SessionFactory sf;
    @PersistenceContext
    private Session s;
    public Session getSession() {
		// return sf.getCurrentSession();
		return s;
	}
    // public FavoriteDAO(Session s){
    //     this.s = s;
    // }
   /*  private static final String INSERT = "INSERT INTO `TEAM4`.`Favorite`"
    +"(`customer_id`,`product_id`)"
    +"VALUES"
    +"(?,?);";
    private static final String DELETE = "DELETE FROM `TEAM4`.`Favorite` WHERE `customer_id` = ? AND `product_id` = ?;";
    private static final String GET_ALL_STM = "SELECT `Favorite`.`product_id` FROM `TEAM4`.`Favorite` WHERE `customer_id` = ?;"; */
    public void insert(FavoriteVO fVo){
        // Hibernate
        if(fVo.getCustomerId() != null && fVo.getProductId() != null){
            FavoriteVO newFvo = getSession().get(FavoriteVO.class, fVo.getFavoriteId());
            if(newFvo == null){
                getSession().save(newFvo);
            }
        }
        // DateSource Jdbc
        /* try (Connection con = ds.getConnection();
            PreparedStatement ps = con.prepareStatement(INSERT)) {
            ps.setInt(1, fVo.getCustomerId());
            ps.setInt(2, fVo.getProductId());
            ps.executeUpdate();
        } catch (SQLException se) {
            throw new RuntimeException("A database error occured. "
            + se.getMessage());
        } */
    }
    public void delete(Integer customerId, Integer productId){
        // JPA CriteriaQuery
        CriteriaBuilder cb = getSession().getCriteriaBuilder();
        CriteriaDelete<FavoriteVO> cd = cb.createCriteriaDelete(FavoriteVO.class);
        Root<FavoriteVO> root = cd.from(FavoriteVO.class);
        cd = cd.where(cb.and(cb.equal(root.get("customerId"), customerId), 
                      cb.equal(root.get("productId"), productId)));
        getSession().createQuery(cd).executeUpdate();
        // Datasource Jdbc
        /* Connection con = null;
        PreparedStatement ps = null;
        try {
            con = ds.getConnection();
            con.setAutoCommit(false);
            ps = con.prepareStatement(DELETE);
            ps.setInt(1, customerId);
            ps.setInt(2, productId);
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
    public ArrayList<Integer> selectByCustomerId(Integer customerId){
    //  JPA CriteriaQuery
        CriteriaBuilder cb = getSession().getCriteriaBuilder();
        CriteriaQuery<FavoriteVO> cq = cb.createQuery(FavoriteVO.class);
        Root<FavoriteVO> root = cq.from(FavoriteVO.class);
        cq = cq.where(cb.equal(root.get("customerId"), customerId));
        ArrayList<Integer> clist = new ArrayList<Integer>();
        for(FavoriteVO sel : getSession().createQuery(cq).getResultList()){
            clist.add(sel.getProductId());
        }
        return clist;


    //  DataSoirce Jdbc
    /*  ArrayList<Integer> list = new ArrayList<Integer>();
        try (Connection con = ds.getConnection();
            PreparedStatement ps = con.prepareStatement(GET_ALL_STM)) {
            ps.setInt(1, customerId);
            ResultSet rs =  ps.executeQuery();
            while(rs.next()){
                list.add(rs.getInt("product_id"));
            }
        } catch (SQLException se) {
            throw new RuntimeException("A database error occured. "
            + se.getMessage());
        }
        return list;
    */
    }
}
