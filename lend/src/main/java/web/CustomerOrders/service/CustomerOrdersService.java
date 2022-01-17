package web.CustomerOrders.service;

import java.sql.Timestamp;

import ProjectInterfaces.CustomerOrderInterface;
import web.CustomerOrders.dao.CustomerOrderDAO;
import web.CustomerOrders.vo.CustomerOrdersVO;

public class CustomerOrdersService {
    private CustomerOrderInterface<CustomerOrdersVO> dao;
    public CustomerOrdersService(){
        dao = new CustomerOrderDAO();
    }
    public CustomerOrdersVO addOrder(Integer customer_id, Integer shipping_mothod_code,Integer order_delivery_charge, 
            Timestamp order_shipping_date,String recipient, String senders_address,String order_details){
        java.sql.Timestamp order_created_date = new java.sql.Timestamp(System.currentTimeMillis());
        CustomerOrdersVO coVo = new CustomerOrdersVO();
        coVo.setOrder_id(hashCode(customer_id, order_details));
        coVo.setCustomer_id(customer_id);
        coVo.setShipping_mothod_code(shipping_mothod_code);
        coVo.setOrder_created_date(order_created_date);
        coVo.setOrder_delivery_charge(order_delivery_charge);
        coVo.setOrder_shipping_date(order_shipping_date);
        coVo.setRecipient(recipient);
        coVo.setSenders_address(senders_address);
        coVo.setOrder_details(order_details);
        dao.insert(coVo);
        return coVo;
    }
    public CustomerOrdersVO updateCustomerOrder(Integer order_id, Integer customer_id, Integer shipping_mothod_code,Integer order_delivery_charge,
            Timestamp order_shipping_date,String recipient, String senders_address, String order_details){
        CustomerOrdersVO coVo = new CustomerOrdersVO();
        coVo.setOrder_id(order_id);
        coVo.setCustomer_id(customer_id);
        coVo.setShipping_mothod_code(shipping_mothod_code);
        coVo.setOrder_delivery_charge(order_delivery_charge);
        coVo.setOrder_shipping_date(order_shipping_date);
        coVo.setRecipient(recipient);
        coVo.setSenders_address(senders_address);
        coVo.setOrder_details(order_details);
        dao.update(coVo);
        return coVo;
    }
    public void deleteOrder(Integer order_id) {
        dao.delete(order_id);
    }
    public CustomerOrdersVO getOneOrder(Integer order_id){
        return dao.selectByOrderId(order_id); 
    }
    public void updateStatus(String status_name, Integer order_id, Byte status_code) {
        dao.updateStatus(status_name, order_id, status_code);
    }
    public int hashCode(Integer customer_id,String order_details) {
        final int prime = 31;
		int result = 1;
		result = result * prime + customer_id;
		result = result * prime + (order_details == null ? 0 : (order_details).hashCode()); 

		return result;
    }
}
