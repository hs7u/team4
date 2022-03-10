package web.CustomerOrders.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

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

import ProjectInterfaces.CustomerOrderInterface;
import web.CustomerOrders.vo.CustomerOrdersVO;
import web.OrderDetail.vo.OrderDetailVO;

@Repository
public class CustomerOrderDAO implements CustomerOrderInterface<CustomerOrdersVO>{
    // @Autowired
    // private SessionFactory sf;
    @PersistenceContext
    private Session s;
    public Session getSession() {
		// return sf.getCurrentSession();
		return s;
	}
    // public CustomerOrderDAO(Session s){
    //     this.s = s;
    // }
   /*  private static final String INSERT_STMT = "INSERT INTO `TEAM4`.`Customer_Orders`"
    +"(`order_id`,`customer_id`,`shipping_method_code`,`order_created_date`,`order_delivery_charge`,`order_shipping_date`,`recipient`,`senders_address`,`order_detials`)"
    +"VALUES"
    +"(?,?,?,?,?,?,?,?,?);";
    private static final String UPDATE = "UPDATE `TEAM4`.`Customer_Orders`"
    +"SET"
    +"`order_id` = ?,`customer_id` = ?,`shipping_method_code` = ?,`order_delivery_charge` = ?,`order_shipping_date`,`recipient` = ?,`senders_address` = ?,`order_details` = ?"
    +"WHERE `order_id` = ?;";
    private static final String DELETE = "DELETE FROM `TEAM4`.`Customer_Orders` WHERE `order_id` = ?;";
    private static final String GET_ONE_STMT = "SELECT * FROM TEAM4.Customer_Orders WHERE `order_id` = ?";
    private static final String UPDATEORDERSTATUS = "UPDATE `TEAM4`.`Customer_Orders`"
    +"SET"
    +"order_status` = ?"
    +"WHERE `order_id` = ?;";
    private static final String UPDATEPAYMENTSTATUS = "UPDATE `TEAM4`.`Customer_Orders`"
    +"SET"
    +"payment_status` = ?"
    +"WHERE `order_id` = ?;";
    private static final String UPDATESHIPPINGSTATUS = "UPDATE `TEAM4`.`Customer_Orders`"
    +"SET"
    +"`shipping_status` = ?"
    +"WHERE `order_id` = ?;";
    private static final String RETURNORDER = "UPDATE `TEAM4`.`Customer_Orders`"
    +"SET"
    +"`return_status` = ?"
    +"WHERE `order_id` = ?;"; */
    public Serializable insert(CustomerOrdersVO coVo){
        // Hibernate
        if(coVo != null){
            // CustomerOrdersVO newOrder = getSession().get(CustomerOrdersVO.class, coVo.getOrderId());
            // if(newOrder == null){
//               getSession().persist(coVo);
           return getSession().save(coVo);
            // }
        }
        return null;
        // Datasource
        /* try (Connection con = ds.getConnection();
            PreparedStatement ps = con.prepareStatement(INSERT_STMT)) {
            ps.setInt(1, coVo.getOrderId());
            ps.setInt(2, coVo.getCustomerId());
            ps.setInt(3, coVo.getShippingMethodCode());
            ps.setTimestamp(4, coVo.getOrderCreatedDate());
            ps.setInt(5, coVo.getOrderDeliveryCharge());
            ps.setTimestamp(6, coVo.getOrderShippingDate());
            ps.setString(7, coVo.getRecipint());
            ps.setString(8, coVo.getSendersAddress());
            ps.setString(9, coVo.getOrderDetails());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } */
    }
    public void update(CustomerOrdersVO coVo){
        // JPA CriteriaQuery
        CriteriaBuilder cb = getSession().getCriteriaBuilder();
        CriteriaUpdate<CustomerOrdersVO> cu = cb.createCriteriaUpdate(CustomerOrdersVO.class);
        Root<CustomerOrdersVO> root = cu.from(CustomerOrdersVO.class);
        cu = cu.set(root.get("orderId"), coVo.getOrderId())
               .set(root.get("customerId"), coVo.getCustomerId())
               .set(root.get("shippingMethodCode"), coVo.getShippingMethodCode())
               .set(root.get("orderDeliveryCharge"), coVo.getOrderDeliveryCharge())
               .set(root.get("orderShippingDate"), coVo.getOrderShippingDate())
               .set(root.get("recipient"), coVo.getRecipient())
               .set(root.get("sendersAddress"), coVo.getSendersAddress())
               .set(root.get("orderDetials"), coVo.getOrderDetails());
        getSession().createQuery(cu).executeUpdate();
        // Hibernate
        /* if(coVo != null){
            CustomerOrdersVO order = getSession().get(CustomerOrdersVO.class, coVo.getOrderId());
            if(order != null){
                order.setOrderId(coVo.getOrderId());
                order.setCustomerId(coVo.getCustomerId());
                order.setShippingMethodCode(coVo.getShippingMethodCode());
                order.setOrderDeliveryCharge(coVo.getOrderDeliveryCharge());
                order.setOrderShippingDate(coVo.getOrderShippingDate());
                order.setRecipient(coVo.getRecipint());
                order.setSendersAddress(coVo.getSendersAddress());
                order.setOrderDetails(coVo.getOrderDetails());
                getSession().save(order);
            }
        } */
        // Datasource
        /* try (Connection con = ds.getConnection();
            PreparedStatement ps = con.prepareStatement(UPDATE)) {
            ps.setInt(1, coVo.getOrderId());
            ps.setInt(2, coVo.getCustomerId());
            ps.setInt(3, coVo.getShippingMethodCode());
            ps.setInt(4, coVo.getOrderDeliveryCharge());
            ps.setTimestamp(5, coVo.getOrderShippingDate());
            ps.setString(6, coVo.getRecipint());    
            ps.setString(7, coVo.getSendersAddress());    
            ps.setString(8, coVo.getOrderDetails());
            ps.setInt(9, coVo.getCustomerId());
            ps.executeUpdate();
        } catch (SQLException se) {
            throw new RuntimeException("A database error occured. "
					+ se.getMessage());
        } */
    }
    public void delete(Integer orderId){
        // JPA CriteriaQuery
        CriteriaBuilder cb = getSession().getCriteriaBuilder();
        CriteriaDelete<CustomerOrdersVO> cd = cb.createCriteriaDelete(CustomerOrdersVO.class);
        Root<CustomerOrdersVO> root = cd.from(CustomerOrdersVO.class);
        cd = cd.where(cb.equal(root.get("orderId"), orderId));
        getSession().createQuery(cd).executeUpdate();
        // Hibernate
       /*  if(orderId != null){
            CustomerOrdersVO newOrder = getSession().get(CustomerOrdersVO.class, orderId);
            if(newOrder != null){
                getSession().delete(newOrder);
            }
        } */
       // Datasource
       /*  Connection con = null;
        PreparedStatement ps = null;
        try {
            con = ds.getConnection();
            con.setAutoCommit(false);
            ps = con.prepareStatement(DELETE);
            ps.setInt(1, orderId);
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
            if(con != null){
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace(System.err);
                }
            }
            if(ps != null){
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace(System.err);
                }
            }
        } */
    }
    public void deleteOrderByProductId(Integer productId){
        // JPA CriteriaQuery
        CriteriaBuilder cb = getSession().getCriteriaBuilder();
        CriteriaDelete<CustomerOrdersVO> cd = cb.createCriteriaDelete(CustomerOrdersVO.class);
        Root<CustomerOrdersVO> root = cd.from(CustomerOrdersVO.class);
        cd = cd.where(cb.equal(root.get("productId"), productId));
        getSession().createQuery(cd).executeUpdate();
    }
    public void updateStatus(String statusName, Integer orderId, Byte statusCode) {
        // JPA CriteriaQuery
        CriteriaBuilder cb = getSession().getCriteriaBuilder();
        CriteriaUpdate<CustomerOrdersVO> cu = cb.createCriteriaUpdate(CustomerOrdersVO.class);
        Root<CustomerOrdersVO> root = cu.from(CustomerOrdersVO.class);
        cu = cu.set(root.get(statusName), statusCode)
               .where(cb.equal(root.get("orderId"), orderId));
        getSession().createQuery(cu).executeUpdate();
        // Hibernate
        /* if(orderId != null){
            CustomerOrdersVO coVo = getSession().get(CustomerOrdersVO.class, orderId);
            if(coVo != null){
                switch (statusName) {
                    case "order_status":
                        coVo.setOrderStatus(statusCode);
                        break;
                    case "payment_status":
                        coVo.setPaymentStatus(statusCode);
                        break;
                    case "shipping_status":
                        coVo.setShippingStatus(statusCode);
                        break;
                    case "return_status":
                        coVo.setReturnStatus(statusCode);
                        break;
                    default:
                        break;
                }
                getSession().save(coVo);
            }
        } */
        // Datasource
        /* String sql = null;
        switch (statusName) {
            case "order_status":
                sql = UPDATEORDERSTATUS;
                break;
            case "payment_status":
                sql = UPDATEPAYMENTSTATUS;
                break;
            case "shipping_status":
                sql = UPDATESHIPPINGSTATUS;
                break;
            case "return_status":
                sql = RETURNORDER;
                break;
            default:
                break;
        }
        try (Connection con = ds.getConnection();
            PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setByte(1, statusCode);
            ps.setInt(2, orderId);
            ps.executeUpdate();
        } catch (SQLException se) {
            throw new RuntimeException("A database error occured. "
            + se.getMessage());
        } */
    }
    public CustomerOrdersVO selectByOrderId(Integer orderId){
        // JPA CriteriaQuery
        CriteriaBuilder cb = getSession().getCriteriaBuilder();
        CriteriaQuery<CustomerOrdersVO> cq = cb.createQuery(CustomerOrdersVO.class);
        Root<CustomerOrdersVO> root = cq.from(CustomerOrdersVO.class);
        cq = cq.where(cb.equal(root.get("orderId"), orderId));
        return getSession().createQuery(cq).getSingleResult();
        // Hibernate
        /* if(orderId != null){
            return getSession().get(CustomerOrdersVO.class, orderId);
        }
        return null; */
        // Datasource
        /* CustomerOrdersVO coVo = new CustomerOrdersVO();
        try (Connection con = ds.getConnection();
            PreparedStatement ps = con.prepareStatement(GET_ONE_STMT)) {
            ps.setInt(1, orderId);
            ResultSet rs =  ps.executeQuery();
            while (rs.next()) {
                coVo.setOrderId(rs.getInt("order_id"));
                coVo.setCustomerId(rs.getInt("customer_id"));
                coVo.setShippingMethodCode(rs.getInt("shipping_method_code"));
                coVo.setOrderCreatedDate(rs.getTimestamp("order_created_date")); 
                coVo.setOrderDeliveryCharge(rs.getInt("order_delivery_charge"));
                coVo.setOrderShippingDate(rs.getTimestamp("order_shipping_date")); 
                coVo.setRecipient(rs.getString("recipient"));
                coVo.setSendersAddress(rs.getString("senders_address"));
                coVo.setOrderDetails(rs.getString("order_details"));
                coVo.setOrderStatus(rs.getByte("order_status"));
                coVo.setPaymentStatus(rs.getByte("payment_status"));
                coVo.setShippingStatus(rs.getByte("shipping_status"));
                coVo.setReturnStatus(rs.getByte("return_status"));
            }
        } catch (SQLException se) {
            throw new RuntimeException("A database error occured. "
					+ se.getMessage());
        }
        return coVo; */
    }
    public List<CustomerOrdersVO> getAll(){
    	// JPA CtiteriaQuery
        CriteriaBuilder cb = getSession().getCriteriaBuilder();
        CriteriaQuery<CustomerOrdersVO> cq = cb.createQuery(CustomerOrdersVO.class);
        Root<CustomerOrdersVO> root = cq.from(CustomerOrdersVO.class);
        cq = cq.select(root);
        return getSession().createQuery(cq).getResultList();
    }
    public Long countOrder(){
        // JPA CriteriaQuery
        CriteriaBuilder cb = getSession().getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<CustomerOrdersVO> root = cq.from(CustomerOrdersVO.class);
        cq = cq.select(cb.count(root));
        return getSession().createQuery(cq).getSingleResult();
    }
	public List<CustomerOrdersVO> getCustomerAllOrder(Integer customerId) {
        // JPA CtiteriaQuery
        CriteriaBuilder cb = getSession().getCriteriaBuilder();
        CriteriaQuery<CustomerOrdersVO> cq = cb.createQuery(CustomerOrdersVO.class);
        Root<CustomerOrdersVO> root = cq.from(CustomerOrdersVO.class);
        cq = cq.select(root).where(cb.equal(root.get("customerId"), customerId));
        return getSession().createQuery(cq).getResultList();
    }
}
