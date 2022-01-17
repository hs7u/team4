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
        cVo.setCustomerId(hashCode(customerName, customerEmail));
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
    public CustomerVO updateCustomer(Integer customeId, String customerName, String customerEmail, String customerPassword,
            String customerPhone, Date customerBirthday, String customerGender, String customerAddress, Byte customerStatus){
        CustomerVO cVo = new CustomerVO();
        cVo.setCustomerId(customeId);
        cVo.setCustomerName(customerName);
        cVo.setCustomerEmail(customerEmail);
        cVo.setCustomerPassword(customerPassword);
        cVo.setCustomerPhone(customerPhone);
        cVo.setCustomerBirthday(customerBirthday);
        cVo.setCustomerGender(customerGender);
        cVo.setCustomerAddress(customerAddress);
        cVo.setCustomerStatus(customerStatus);
        dao.update(cVo);
        return cVo;
    }
    public void deleteCustomer(Integer customeId){
        dao.delete(customeId);
    }
    public void changeStatus(Integer customeId ,Byte statusCode){
        dao.changeStatus(customeId, statusCode);
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
