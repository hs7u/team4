package web.Creditcrad.dao;

import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
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
import org.springframework.stereotype.Repository;

import ProjectInterfaces.CreditcradInterface;
import web.Creditcrad.vo.CreditcradVO;

@Repository
public class CreditcardDAO implements CreditcradInterface<CreditcradVO>{
    // @Autowired
    // private SessionFactory sf;
    @PersistenceContext
    private Session s;
    public Session getSession() {
		// return sf.getCurrentSession();
		return s;
	}
    // public CreditcardDAO(Session s){
    //     this.s = s;
    // }
    /* private static final String INSERT = "INSERT INTO `TEAM4`.`Creditcard_Info`"
    +"(`creditcard_number`,`customer_id`,`cvv_code`,`expire_year`,`expire_month`,`cardholder_name`)"
    +"VALUES"
    +"(?,?,?,?,?,?);";
    private static final String UPDATE = "UPDATE `TEAM4`.`Creditcard_Info`"
    +"SET"
    +"`creditcard_number` = ?,`customer_id` = ?,`cvv_code` = ?,`expire_year` = ?,`expire_month` = ?,`cardholder_name` = ?"
    +"WHERE `customer_id` = ?;";
    private static final String DELETE = "DELETE FROM `TEAM4`.`Creditcard_Info` WHERE `customer_id` = ?;";
    private static final String GET_ONE_STM = "SELECT * FROM TEAM4.Creditcard_Info WHERE `customer_id` = ?;"; */
    public void insert(CreditcradVO cVo){
        // Hibernate
        if(cVo != null){
            CreditcradVO card = getSession().get(CreditcradVO.class, cVo.getCreditcardNumber());
            if(card == null){
                getSession().save(cVo);
            }
        }
        // DateSource Jdbc
        /* try (Connection con = ds.getConnection();
            PreparedStatement ps = con.prepareStatement(INSERT)) {
            ps.setInt(1, cVo.getCreditcardNumber());
            ps.setInt(2, cVo.getCustomerId());
            ps.setString(3, cVo.getCvvCode());
            ps.setString(4, cVo.getExpireYear());
            ps.setString(5, cVo.getExpireMonth());
            ps.setString(6, cVo.getCardholderName());
            ps.executeUpdate();
        } catch (SQLException se) {
            throw new RuntimeException("A database error occured. "
            + se.getMessage());
        } */
    }
    public void update(CreditcradVO cVo){
        // JPA CriterQuery
        CriteriaBuilder cb = getSession().getCriteriaBuilder();
        CriteriaUpdate<CreditcradVO> cu = cb.createCriteriaUpdate(CreditcradVO.class);
        Root<CreditcradVO> root = cu.from(CreditcradVO.class);
        cu = cu.set(root.get("customer_id"), cVo.getCustomerId())
               .set(root.get("cardholder_name"), cVo.getCvvCode())
               .set(root.get("cvv_code"), cVo.getExpireYear())
               .set(root.get("expire_month"), cVo.getExpireMonth())
               .set(root.get("expire_year"), cVo.getCardholderName())
               .where(cb.equal(root.get("creditcard_number"), cVo.getCreditcardNumber()));
        getSession().createQuery(cu).executeUpdate();
        // Hibernate
        /* CreditcradVO card = getSession().get(CreditcradVO.class, cVo.getCreditcardNumber());
        if(card != null){
            card.setCreditcardNumber(cVo.getCreditcardNumber());
            card.setCustomerId(cVo.getCustomerId());
            card.setCvvCode(cVo.getCvvCode());
            card.setExpireYear(cVo.getExpireYear());
            card.setExpireMonth(cVo.getExpireMonth());
            card.setCardholderName(cVo.getCardholderName());
            getSession().save(card);
        } */
        // DateSource Jdbc
        /* try (Connection con = ds.getConnection();
            PreparedStatement ps = con.prepareStatement(UPDATE)) {
            ps.setInt(1, cVo.getCreditcardNumber());
            ps.setInt(2, cVo.getCustomerId());
            ps.setString(3, cVo.getCvvCode());
            ps.setString(4, cVo.getExpireYear());
            ps.setString(5, cVo.getExpireMonth());
            ps.setString(6, cVo.getCardholderName());
            ps.setInt(7, cVo.getCustomerId());
            ps.executeUpdate();
        } catch (SQLException se) {
            throw new RuntimeException("A database error occured. "
            + se.getMessage());
        } */
    }
    public void delete(Integer customerId){
        // JPA CriterQuery
        CriteriaBuilder cb = getSession().getCriteriaBuilder();
        CriteriaDelete<CreditcradVO> cd = cb.createCriteriaDelete(CreditcradVO.class);
        Root<CreditcradVO> root = cd.from(CreditcradVO.class);
        cd = cd.where(cb.equal(root.get("customer_id"), customerId));
        getSession().createQuery(cd).executeUpdate();
        // Hibernate
        /* if(customerId != null){
            CreditcradVO cVo = getSession().get(CreditcradVO.class, customerId);
            if(cVo != null){
                getSession().delete(cVo);
            }
        } */
        // DateSource Jdbc
        /* Connection con = null;
        PreparedStatement ps = null;
        try {
            con = ds.getConnection();
            con.setAutoCommit(false);
            ps = con.prepareStatement(DELETE);
            ps.setInt(1, customerId);
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
        } finally{
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
    public CreditcradVO selectByCustomerId(Integer customerId){
        // JPA CriterQuery
        CriteriaBuilder cb = getSession().getCriteriaBuilder();
        CriteriaQuery<CreditcradVO> cq = cb.createQuery(CreditcradVO.class);
        Root<CreditcradVO> root = cq.from(CreditcradVO.class);
        cq = cq.where(cb.equal(root.get("customer_id"), customerId));
        try {
			return getSession().createQuery(cq).getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
        // Hibernate
        /* if(customerId != null){
            CreditcradVO cVo = getSession().get(CreditcradVO.class, customerId);
            if(cVo != null){
                return cVo;
            }
        }
        return null; */
        // DateSource Jdbc
        /* CreditcradVO cVo = new CreditcradVO();
        try (Connection con = ds.getConnection();
            PreparedStatement ps = con.prepareStatement(GET_ONE_STM)) {
            ps.setInt(1, customerId);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                cVo.setCreditcardNumber(rs.getInt("creditcard_number"));
                cVo.setCardholderName(rs.getString("cardholder_name"));
                cVo.setCustomerId(rs.getInt("customer_id"));
                cVo.setCvvCode(rs.getString("cvv_code"));
                cVo.setExpireYear(rs.getString("expire_year"));
                cVo.setExpireMonth(rs.getString("expire_month"));
            }
        } catch (SQLException se) {
            throw new RuntimeException("A database error occured. "
            + se.getMessage());
        }
        return cVo; */
    }
}
