package web.Customer.service;

import java.sql.Date;

import ProjectInterfaces.CustomerInterface;
import web.Customer.dao.CustomerDAO;
import web.Customer.vo.CustomerVO;

public class CustomerService {
    private CustomerInterface<CustomerVO> dao;
    public CustomerService() {
        dao = new CustomerDAO();
    }
    public CustomerVO addCustomer(String customerName, String customerEmail, String customerPassword,
            String customerPhone, Date customerBirthday, String customerGender, String customerAddress) {
        java.sql.Timestamp customerRegisterTime = new java.sql.Timestamp(System.currentTimeMillis());
        CustomerVO cVo = new CustomerVO();
        cVo.setCustomer_id(hashCode(customerName, customerEmail));
        cVo.setCustomerName(customerName);
        cVo.setCustomerEmail(customerEmail);
        cVo.setCustomerPassword(customerPassword);
        cVo.setCustomerPhone(customerPhone);
        cVo.setCustomerBirthday(customerBirthday);
        cVo.setCustomerGender(customerGender);
        cVo.setCustomerAddress(customerAddress);
        cVo.setCustomerRegisterTime(customerRegisterTime);
        dao.insert(cVo);

        return cVo;
    }
    public CustomerVO updateCustomer(Integer customer_id, String customerName, String customerEmail, String customerPassword,
            String customerPhone, Date customerBirthday, String customerGender, String customerAddress, Byte customer_status){
        CustomerVO cVo = new CustomerVO();
        cVo.setCustomer_id(customer_id);
        cVo.setCustomerName(customerName);
        cVo.setCustomerEmail(customerEmail);
        cVo.setCustomerPassword(customerPassword);
        cVo.setCustomerPhone(customerPhone);
        cVo.setCustomerBirthday(customerBirthday);
        cVo.setCustomerGender(customerGender);
        cVo.setCustomerAddress(customerAddress);
        cVo.setCustomer_status(customer_status);
        dao.update(cVo);
        return cVo;
    }
    public void deleteCustomer(Integer customer_id){
        dao.delete(customer_id);
    }
    public void changeStatus(Integer customer_id ,Byte status_code){
        dao.changeStatus(customer_id, status_code);
    }
    public CustomerVO getOneCustomer(String customerEmail,String customerPassword){
        return dao.selectByUserEmailAndPassword(customerEmail, customerPassword);
    }
    public int hashCode(String customerName,String customerEmail) {
        final int prime = 31;
		int result = 1;
		result = result * prime + (customerName == null ? 0 : (customerName).hashCode()); 
		result = result * prime + (customerEmail == null ? 0 : (customerEmail).hashCode()); 
        
		return result;
    }
}
