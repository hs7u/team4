package web.Qa.dao;

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

import ProjectInterfaces.QAInterface;
import web.Qa.vo.QAVO;

@Repository
public class QADAO implements QAInterface<QAVO>{
    // @Autowired
    // private SessionFactory sf;
    @PersistenceContext
    private Session s;
    public Session getSession() {
		// return sf.getCurrentSession();
		return s;
	}
    // public QADAO(Session s){
    //     this.s = s;
    // }
    /* private static final String INSERT = "INSERT INTO `TEAM4`.`QA`"
    +"(`answer`,`quession`)"
    +"VALUES"
    +"(?,?);";
    private static final String UPDATE = "UPDATE `TEAM4`.`QA`"
    +"SET"
    +"`qa_id` = ?,`answer` = ?,`quession` = ?"
    +"WHERE `qa_id` = ?;";
    private static final String DELETE = "DELETE FROM `TEAM4`.`QA` WHERE `qa_id` = ?;";
    private static final String SELECT_BY_QAID = "SELECT * FROM TEAM4.QA WHERE `qa_id` = ?"; */
    public void insert(QAVO qavo){
        // Hibernate
        if(qavo != null){
			QAVO check = getSession().get(QAVO.class, qavo.getQaId());
			if(check == null){
				getSession().save(qavo);
			}
		}
        // DataSource Jdbc
        /* try (Connection con = ds.getConnection();
            PreparedStatement ps = con.prepareStatement(INSERT)) {
            ps.setString(1, qavo.getQuession());
            ps.setString(2, qavo.getAnswer());
            ps.executeUpdate();
        } catch (SQLException se) {
            throw new RuntimeException("A database error occured. "
					+ se.getMessage());
        } */
    } 
    public void update(QAVO qavo){
        // JPA CriteriaQuery
        CriteriaBuilder cb = getSession().getCriteriaBuilder();
        CriteriaUpdate<QAVO> cu = cb.createCriteriaUpdate(QAVO.class);
        Root<QAVO> root = cu.from(QAVO.class); 
        cu = cu.set(root.get("quession"), qavo.getQuession())
               .set(root.get("reply"), qavo.getReply())
               .where(cb.equal(root.get("qaId"), qavo.getQaId()));
        getSession().createQuery(cu).executeUpdate();
        // Hibernate
        /* if(qavo != null){
            QAVO update = getSession().get(QAVO.class, qavo.getQaId());
            if(update != null){
                update.setQuession(qavo.getQuession());
                update.setAnswer(qavo.getAnswer());
                getSession().save(update);
            }
        } */
        // DataSource Jdbc
        /* try (Connection con = ds.getConnection();
            PreparedStatement ps = con.prepareStatement(UPDATE)) {
            ps.setInt(1, qavo.getQaId());
            ps.setString(2, qavo.getQuession());
            ps.setString(3, qavo.getAnswer());
            ps.setInt(4, qavo.getQaId());
            ps.executeUpdate();
        } catch (SQLException se) {
            throw new RuntimeException("A database error occured. "
					+ se.getMessage());
        } */
    }      
    public void delete(Integer qaId){
        // JPA CriteriaQuery
        CriteriaBuilder cb = getSession().getCriteriaBuilder();
        CriteriaDelete<QAVO> cd = cb.createCriteriaDelete(QAVO.class);
        Root<QAVO> root = cd.from(QAVO.class);
        cd = cd.where(cb.equal(root.get("qaId"), qaId));
        getSession().createQuery(cd).executeUpdate();
        // Hibernate
        /* if(qaId != null){
			QAVO check = getSession().get(QAVO.class, qaId);
			if(check != null){
				getSession().delete(check);
			}
		} */
        // DataSource Jdbc
        /* Connection con = null;
        PreparedStatement ps = null;
        try {
            con = ds.getConnection();
            con.setAutoCommit(false);
            ps = con.prepareStatement(DELETE);
            ps.setInt(1, qaId);
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
    public QAVO selectByQAId(Integer qaId){
        // JPA CriteriaQuery
        CriteriaBuilder cb = getSession().getCriteriaBuilder();
        CriteriaQuery<QAVO> cq = cb.createQuery(QAVO.class);
        Root<QAVO> root = cq.from(QAVO.class);
        cq = cq.where(cb.equal(root.get("qaId"), qaId));
        return getSession().createQuery(cq).getSingleResult();
        // Hibernate
        /* if(qaId != null){
            return getSession().get(QAVO.class, qaId);
        }
        return null; */
        // DataSource Jdbc
       /*  QAVO qa = new QAVO();
        try (Connection con = ds.getConnection();
            PreparedStatement ps = con.prepareStatement(SELECT_BY_QAID)) {
            ps.setInt(1, qaId);
            ResultSet rs =  ps.executeQuery();
            while(rs.next()){
                qa.setQaId(rs.getInt("qa_id"));
                qa.setQuession(rs.getString("quession"));
                qa.setAnswer(rs.getString("answer"));
            }
        } catch (SQLException se) {
            throw new RuntimeException("A database error occured. "
					+ se.getMessage());
        }
        return qa; */
    }
}
