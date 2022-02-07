package web.CustomerOrders.service;

import java.sql.Timestamp;

import org.hibernate.Session;

import ProjectInterfaces.CustomerOrderInterface;
import web.CustomerOrders.dao.CustomerOrderDAO;
import web.CustomerOrders.vo.CustomerOrdersVO;

public class CustomerOrdersService {
    private CustomerOrderInterface<CustomerOrdersVO> dao;
    public CustomerOrdersService(Session session){
        dao = new CustomerOrderDAO(session);
    }
    public CustomerOrdersVO addOrder(Integer customerId, Integer shippingMethodCode,Integer orderDeliveryCharge, 
            Timestamp orderShippingDate,String recipient, String sendersAddress,String orderDetails){
        java.sql.Timestamp orderCreatedDate = new java.sql.Timestamp(System.currentTimeMillis());
        CustomerOrdersVO coVo = new CustomerOrdersVO();
        coVo.setOrderId(hashCode(customerId, orderDetails));
        coVo.setCustomerId(customerId);
        coVo.setShippingMethodCode(shippingMethodCode);
        coVo.setOrderCreatedDate(orderCreatedDate);
        coVo.setOrderDeliveryCharge(orderDeliveryCharge);
        coVo.setOrderShippingDate(orderShippingDate);
        coVo.setRecipient(recipient);
        coVo.setSendersAddress(sendersAddress);
        coVo.setOrderDetails(orderDetails);
        dao.insert(coVo);
        return coVo;
    }
    public CustomerOrdersVO updateCustomerOrder(Integer orderId, Integer customerId, Integer shippingMethodCode,Integer orderDeliveryCharge,
            Timestamp orderShippingDate,String recipient, String sendersAddress, String orderDetails){
        CustomerOrdersVO coVo = new CustomerOrdersVO();
        coVo.setOrderId(orderId);
        coVo.setCustomerId(customerId);
        coVo.setShippingMethodCode(shippingMethodCode);
        coVo.setOrderDeliveryCharge(orderDeliveryCharge);
        coVo.setOrderShippingDate(orderShippingDate);
        coVo.setRecipient(recipient);
        coVo.setSendersAddress(sendersAddress);
        coVo.setOrderDetails(orderDetails);
        dao.update(coVo);
        return coVo;
    }
    public void deleteOrder(Integer orderId) {
        dao.delete(orderId);
    }
    public CustomerOrdersVO getOneOrder(Integer orderId){
        return dao.selectByOrderId(orderId); 
    }
    public void updateStatus(String status_name, Integer orderId, Byte statusCode) {
        dao.updateStatus(status_name, orderId, statusCode);
    }
    public int hashCode(Integer customerId,String orderDetails) {
        final int prime = 31;
		int result = 1;
		result = result * prime + customerId;
		result = result * prime + (orderDetails == null ? 0 : (orderDetails).hashCode()); 

		return result;
    }
}
