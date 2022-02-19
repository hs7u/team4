package web.CustomerService.dao;

import javax.persistence.PersistenceContext;
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
import org.springframework.stereotype.Repository;

import ProjectInterfaces.CustomerServiceInterface;
import web.CustomerService.vo.CustomerServiceVO;

@Repository
public class CustomerServiceDAO implements CustomerServiceInterface<CustomerServiceVO>{
    // @Autowired
    // private SessionFactory sf;
    @PersistenceContext
    private Session s;
    public Session getSession() {
		// return sf.getCurrentSession();
		return s;
	}
    // public CustomerServiceDAO(Session s){
    //     this.s = s;
    // }
    /* private static final String INSERT = "INSERT INTO `TEAM4`.`Customer_Service`"
    +"(`cusotmer_id`,`message_time`,`message_title`,`message_context`)"
    +"VALUES"
    +"(?,?,?,?);";
    private static final String UPDATE = "UPDATE `TEAM4`.`Customer_Service`"
    +"SET"
    +"`message_id` = ?,`cusotmer_id` = ?,`message_title` = ?,`message_context` = ?,`reply_context` = ?"
    +"WHERE `message_id` = ?;";
    private static final String GET_ONE_STM = "SELECT * FROM TEAM4.Customer_Service WHERE `message_id` = ?;"; */
    public void insert(CustomerServiceVO csVO){
       // Hibernate
       if(csVO != null){
           CustomerServiceVO check = getSession().get(CustomerServiceVO.class, csVO.getMessageId());
           if(check == null){
               getSession().save(csVO);
           }
       }
       // Datasource Jdbc
       /*  try (Connection con = ds.getConnection();
         PreparedStatement ps = con.prepareStatement(INSERT)) {
            ps.setInt(1,csVO.getCusotmerId());
            ps.setTimestamp(2,csVO.getMessageTime());
            ps.setString(3,csVO.getMessageTitle());
            ps.setString(4,csVO.getMessageContext());
            ps.executeUpdate();
        } catch (SQLException se) {
            throw new RuntimeException("A database error occured. "
            + se.getMessage());
        } */
    }
    public void update(CustomerServiceVO csVO){
        // JPA CriteriaQuety
        CriteriaBuilder cb = getSession().getCriteriaBuilder();
        CriteriaUpdate<CustomerServiceVO> cu = cb.createCriteriaUpdate(CustomerServiceVO.class);
        Root<CustomerServiceVO> root = cu.from(CustomerServiceVO.class);
        cu = cu.set(root.get("messageTitle"), csVO.getMessageTitle())
               .set(root.get("messageContext"), csVO.getMessageContext())
               .set(root.get("replyContext"), csVO.getReplyContext())
               .where(cb.equal(root.get("messageId"), csVO.getMessageId()));
        getSession().createQuery(cu).executeUpdate();
        // Hibernate
        /* if(csVO != null){
            CustomerServiceVO update = getSession().get(CustomerServiceVO.class, csVO.getMessageId());
            if(update != null){
                update.setMessageTitle(csVO.getMessageTitle());
                update.setMessageContext(csVO.getMessageContext());
                update.setReplyContext(csVO.getReplyContext());
                getSession().save(update);    
            }
        } */
        // Datasource Jdbc
        /* try (Connection con = ds.getConnection();
         PreparedStatement ps = con.prepareStatement(UPDATE)) {
            ps.setInt(1,csVO.getMessageId());
            ps.setInt(2,csVO.getCusotmerId());
            ps.setString(3,csVO.getMessageTitle());
            ps.setString(4,csVO.getMessageContext());
            ps.setString(5,csVO.getReplyContext());
            ps.setInt(6,csVO.getMessageId());
            ps.executeUpdate();
        } catch (SQLException se) {
            throw new RuntimeException("A database error occured. "
            + se.getMessage());
        } */
    }
    public CustomerServiceVO selectByMessageId(Integer messageId){
        // JPA CriteriaQuety
        CriteriaBuilder cb = getSession().getCriteriaBuilder();
        CriteriaQuery<CustomerServiceVO> cq = cb.createQuery(CustomerServiceVO.class);
        Root<CustomerServiceVO> root = cq.from(CustomerServiceVO.class);
        cq = cq.where(cb.equal(root.get("messageId"), messageId));
        return getSession().createQuery(cq).getSingleResult();
        // Hibernate
        /* if(messageId != null){
            return getSession().get(CustomerServiceVO.class, messageId);
        }
        return null; */
        // Datasource Jdbc
        /* CustomerServiceVO csVO = new CustomerServiceVO();
        try (Connection con = ds.getConnection();
         PreparedStatement ps = con.prepareStatement(GET_ONE_STM)) {
            ps.setInt(1, messageId);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                csVO.setMessageId(rs.getInt("message_id"));
                csVO.setCusotmerId(rs.getInt("cusotmer_id"));
                csVO.setMessageTime(rs.getTimestamp("message_time"));
                csVO.setMessageTitle(rs.getString("message_title"));
                csVO.setMessageContext(rs.getString("message_context"));
                csVO.setReplyContext(rs.getString("reply_context"));
            }
        } catch (SQLException se) {
            throw new RuntimeException("A database error occured. "
            + se.getMessage());
        }
        return csVO; */
    }
}