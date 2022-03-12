package web.Customer.dao;
/* import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException; */

import java.io.Serializable;
import java.util.List;

import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;
// import javax.sql.DataSource;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import ProjectInterfaces.CustomerInterface;
import web.Customer.vo.CustomerVO;

@Repository
public class CustomerDAO implements CustomerInterface<CustomerVO>{
    // @Autowired
    // private SessionFactory sf;
    @PersistenceContext
    private Session s;
    public Session getSession() {
		// return sf.getCurrentSession();
		return s;
	}
    // public CustomerDAO(Session s){
    //      getSession() = s;
    // }
   
    /* private static final String INSERT_STMT = "INSERT INTO `TEAM4`.`Customer`"
    +"(`customer_id`,`customer_name`,`customer_email`,`customer_password`,`customer_phone`,`customer_birthday`,`customer_gender`,`customer_address`,`customer_register_time`)"
    +"VALUES(?,?,?,?,?,?,?,?,?)";
    private static final String GET_ALL_STMT = "";
    private static final String GET_ONE_STMT = "SELECT * FROM TEAM4.Customer "
    +"WHERE `customer_email` = ? AND `customer_password` = ?;";
    private static final String DELETE = "DELETE FROM `TEAM4`.`Customer` WHERE `customer_id` = ?;";
    private static final String UPDATE = "UPDATE `TEAM4`.`Customer`"
    +"SET`customer_id` = ?,`customer_name` = ?,`customer_email` = ?,`customer_password` = ?,`customer_phone` = ?,`customer_birthday` = ?,`customer_gender` = ?,`customer_address` = ?"
    +"WHERE `customer_id` = ?;";
    private static final String CUSTOMER_STATUS = "UPDATE `TEAM4`.`Customer`"
    +"SET"
    +"`customer_status` = ?"
    +"WHERE `customer_id` = ?;"; */
    
    public Serializable insert(CustomerVO customerVo){
        // JPA CriteriaQuery
       CriteriaBuilder cb = getSession().getCriteriaBuilder();
       CriteriaQuery<Long> cq = cb.createQuery(Long.class);
       Root<CustomerVO> root = cq.from(CustomerVO.class);
       cq = cq.select(cb.count(root)).where(cb.equal(root.get("customerEmail"), customerVo.getCustomerEmail()));
       Long result = getSession().createQuery(cq).getSingleResult();
       if(result == 0){
            return getSession().save(customerVo);
       }
       return null;
        // Hibernate
        // CustomerVO cVo =  getSession().get(CustomerVO.class, customerVo.getCustomerId());
        // if(cVo == null){
        //         getSession().save(customerVo);
        //         return "success";
        // }
        // return "fail";
        // DateSource Jdbc
        /* try (Connection con = ds.getConnection(); 
             PreparedStatement ps = con.prepareStatement(INSERT_STMT)){
             ps.setInt(1, customerVo.getCustomerId());
             ps.setString(2, customerVo.getCustomerName());
             ps.setString(3, customerVo.getCustomerEmail());
             ps.setString(4, customerVo.getCustomerPassword());
             ps.setString(5, customerVo.getCustomerPhone());
             ps.setDate(6, customerVo.getCustomerBirthday());
             ps.setString(7, customerVo.getCustomerGender());
             ps.setString(8, customerVo.getCustomerAddress());
             ps.setTimestamp(9, customerVo.getCustomerRegisterTime());
             ps.executeUpdate();
         } catch (SQLException e) {
             e.printStackTrace();
         } */
        
    }
    public Boolean update(CustomerVO customerVo){
        //JPA CriterQuery
        CriteriaBuilder cb =  getSession().getCriteriaBuilder();
        CriteriaUpdate<CustomerVO> cu = cb.createCriteriaUpdate(CustomerVO.class);
        Root<CustomerVO> root = cu.from(CustomerVO.class);
        cu = cu.set(root.get("customerId"),customerVo.getCustomerId())
               .set(root.get("customerName"),customerVo.getCustomerName())
               .set(root.get("customerEmail"),customerVo.getCustomerEmail())
               .set(root.get("customerPassword"),customerVo.getCustomerPassword())
               .set(root.get("customerPhone"),customerVo.getCustomerPhone())
               .set(root.get("customerBirthday"),customerVo.getCustomerBirthday())
               .set(root.get("customerGender"),customerVo.getCustomerGender())
               .set(root.get("customerAddress"),customerVo.getCustomerAddress())
               .where(cb.equal(root.get("customerId"), customerVo.getCustomerId()));
          
        return getSession().createQuery(cu).executeUpdate() > 0 ? true : false;
        
        // Hibernate
        /* 
            CustomerVO cVo =  getSession().get(CustomerVO.class, customerVo.getCustomerEmail());
            if(cVo != null){
                cVo.setCustomerId(customerVo.getCustomerId());
                cVo.setCustomerName(customerVo.getCustomerName());
                cVo.setCustomerEmail(customerVo.getCustomerEmail());
                cVo.setCustomerPassword(customerVo.getCustomerPassword());
                cVo.setCustomerPhone(customerVo.getCustomerPhone());
                cVo.setCustomerBirthday(customerVo.getCustomerBirthday());
                cVo.setCustomerGender(customerVo.getCustomerGender());
                cVo.setCustomerAddress(customerVo.getCustomerAddress());
                 getSession().save(cVo);
                return true;
            }
            return false;
        */
        
        // DateSource Jdbc
        /* try (Connection con = ds.getConnection();
            PreparedStatement ps = con.prepareStatement(UPDATE)) {
            ps.setInt(1, customerVo.getCustomerId());
            ps.setString(2, customerVo.getCustomerName());
            ps.setString(3, customerVo.getCustomerEmail());
            ps.setString(4, customerVo.getCustomerPassword());
            ps.setString(5, customerVo.getCustomerPhone());
            ps.setDate(6, customerVo.getCustomerBirthday());
            ps.setString(7, customerVo.getCustomerGender());
            ps.setString(8, customerVo.getCustomerAddress());
            ps.setInt(9, customerVo.getCustomerId());
            ps.executeUpdate();
        } catch (SQLException se) {
            throw new RuntimeException("A database error occured. "
					+ se.getMessage());
        } */
        
    }
    public void delete(Integer customerId){
       // JPA CriterQurey
        CriteriaBuilder cb =  getSession().getCriteriaBuilder();
        CriteriaDelete<CustomerVO> cd = cb.createCriteriaDelete(CustomerVO.class);
        Root<CustomerVO> root = cd.from(CustomerVO.class);
        cd = cd.where(cb.equal(root.get("customerId"),customerId));
         getSession().createQuery(cd).executeUpdate();

       // Hibernate
       /* 
          if(customerId != null){ 
             CustomerVO cVo =  getSession().get(CustomerVO.class, customerId);
             if(cVo != null) {
                  getSession().delete(cVo);
                 return true
             }
             return false;
          }
          return false;
        */
        
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
    public void changeStatus(Integer customerId ,Byte statusCode){
        // JPA CriteriaQuery
        CriteriaBuilder cb =  getSession().getCriteriaBuilder();
        CriteriaUpdate<CustomerVO> cu = cb.createCriteriaUpdate(CustomerVO.class);
        Root<CustomerVO> root = cu.from(CustomerVO.class);
        cu = cu.set(root.get("customerStatus"), statusCode)
               .where(cb.equal(root.get("customerId"), customerId));
         getSession().createQuery(cu).executeUpdate();

        // Hibernate
        /* 
        if(customerId != null){
            CustomerVO cVo =  getSession().get(CustomerVO.class, customerId);
            if(cVo != null){
                cVo.setCustomerStatus(statusCode);
                 getSession().save(cVo);
                return true;
            }
            return false;
        }
        return false;
        */

        // DateSource Jdbc
        /* try (Connection con = ds.getConnection();
            PreparedStatement ps = con.prepareStatement(CUSTOMER_STATUS)) {
            ps.setByte(1, statusCode);
            ps.setInt(2, customerId);
            ps.executeUpdate();
        } catch (SQLException se) {
            throw new RuntimeException("A database error occured. "
					+ se.getMessage());
        } */
    }
    public CustomerVO selectByUserEmail(String customerEmail){
        // JPA CriterQuery
        CriteriaBuilder cb =  getSession().getCriteriaBuilder();
        CriteriaQuery<CustomerVO> cq = cb.createQuery(CustomerVO.class);
        Root<CustomerVO> root = cq.from(CustomerVO.class);
        
        cq = cq.where(cb.equal(root.get("customerEmail"), customerEmail));
		try {
			return  getSession().createQuery(cq).getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
        // DateSource Jdbc
        /* CustomerVO cVo = new CustomerVO();
        try (Connection con = ds.getConnection();
            PreparedStatement ps = con.prepareStatement(GET_ONE_STMT)){
            ps.setString(1, customerEmail);
            ps.setString(2, customerPassword);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                cVo.setCustomerId(rs.getInt("customer_id"));
                cVo.setCustomerName(rs.getString("customer_name"));
                cVo.setCustomerEmail(rs.getString("customer_email"));
                cVo.setCustomerPassword(rs.getString("customer_password"));
                cVo.setCustomerPhone(rs.getString("customer_phone"));
                cVo.setCustomerBirthday(rs.getDate("customer_birthday"));
                cVo.setCustomerGender(rs.getString("customer_gender"));
                cVo.setCustomerAddress(rs.getString("customer_address"));
                cVo.setCustomerRegisterTime(rs.getTimestamp("customer_register_time"));
                cVo.setCustomerStatus(rs.getByte("customer_status"));
            }

        } catch (SQLException se) {
            throw new RuntimeException("A database error occured. "
					+ se.getMessage());
        }
        return cVo; */
    }
    public List<CustomerVO> getAll(){
        // JPA CriteriaQuery
        CriteriaBuilder cb =  getSession().getCriteriaBuilder();
        CriteriaQuery<CustomerVO> cq = cb.createQuery(CustomerVO.class);
        Root<CustomerVO> root = cq.from(CustomerVO.class);
        cq = cq.select(root);
        return  getSession().createQuery(cq).getResultList();
    }
    public Long countCustomer(){
        // JPA CriteriaQuery
        CriteriaBuilder cb = getSession().getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<CustomerVO> root = cq.from(CustomerVO.class);
        cq = cq.select(cb.count(root));
        return getSession().createQuery(cq).getSingleResult();
    }
}