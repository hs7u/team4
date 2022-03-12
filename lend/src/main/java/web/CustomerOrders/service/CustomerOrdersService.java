package web.CustomerOrders.service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ProjectInterfaces.CustomerOrderInterface;
import web.CustomerOrders.vo.CustomerOrdersVO;

@Service
@Transactional
public class CustomerOrdersService {
    @Autowired
    private CustomerOrderInterface<CustomerOrdersVO> dao;
    // private CustomerOrderDAO dao;
    // public CustomerOrdersService(Session session){
    //     dao = new CustomerOrderDAO(session);
    // }
    public String addOrder(CustomerOrdersVO coVo){
        java.sql.Timestamp date = new java.sql.Timestamp(System.currentTimeMillis());
        StringBuilder errorMsg = new StringBuilder();
        coVo.setOrderCreatedDate(date);
        coVo.setOrderShippingDate(date);
        if(coVo.getOrderDeliveryCharge() == null)
            errorMsg.append("運費不得為空"+System.lineSeparator());
        if(coVo.getOrderDeliveryCharge() <= 0)
            errorMsg.append("運費不得為0"+System.lineSeparator());
        if(coVo.getOrderShippingDate() == null)
            errorMsg.append("日期不得為空"+System.lineSeparator());
        if(coVo.getRecipient().isEmpty())
            errorMsg.append("取貨人不得為空"+System.lineSeparator());
        if(coVo.getSendersAddress().isEmpty())
            errorMsg.append("地址不得為空"+System.lineSeparator());
        if(coVo.getOrderDetails().isEmpty())
            errorMsg.append("細節不得為空"+System.lineSeparator());
        if(errorMsg.length() <= 0){
            return dao.insert(coVo).toString();
        }
        return errorMsg.toString();
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
    public void deleteOrderByProductId(Integer productId) {
        dao.delete(productId);
    }
    public CustomerOrdersVO getOneOrder(Integer orderId){
        return dao.selectByOrderId(orderId); 
    }
    public void updateStatus(String status_name, Integer orderId, Byte statusCode) {
        dao.updateStatus(status_name, orderId, statusCode);
    }
    public Long countOrder(){
        return dao.countOrder();
    }
    public List<CustomerOrdersVO> getAll(){
    	return dao.getAll();
    }
    public List<CustomerOrdersVO> getCustomerAllOrder(Integer customerId){
    	return dao.getCustomerAllOrder(customerId);
    }
}
