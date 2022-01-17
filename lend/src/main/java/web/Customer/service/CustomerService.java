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
    public CustomerVO addCustomer(String customer_name, String customer_email, String customer_password,
            String customer_phone, Date customer_birthday, String customer_gender, String customer_address) {
        java.sql.Timestamp customer_register_time = new java.sql.Timestamp(System.currentTimeMillis());
        CustomerVO cVo = new CustomerVO();
        cVo.setCustomer_id(hashCode(customer_name, customer_email));
        cVo.setCustomer_name(customer_name);
        cVo.setCustomer_email(customer_email);
        cVo.setCustomer_password(customer_password);
        cVo.setCustomer_phone(customer_phone);
        cVo.setCustomer_birthday(customer_birthday);
        cVo.setCustomer_gender(customer_gender);
        cVo.setCustomer_address(customer_address);
        cVo.setCustomer_register_time(customer_register_time);
        dao.insert(cVo);

        return cVo;
    }
    public CustomerVO updateCustomer(Integer customer_id, String customer_name, String customer_email, String customer_password,
            String customer_phone, Date customer_birthday, String customer_gender, String customer_address, Byte customer_status){
        CustomerVO cVo = new CustomerVO();
        cVo.setCustomer_id(customer_id);
        cVo.setCustomer_name(customer_name);
        cVo.setCustomer_email(customer_email);
        cVo.setCustomer_password(customer_password);
        cVo.setCustomer_phone(customer_phone);
        cVo.setCustomer_birthday(customer_birthday);
        cVo.setCustomer_gender(customer_gender);
        cVo.setCustomer_address(customer_address);
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
    public CustomerVO getOneCustomer(String customer_email,String customer_password){
        return dao.selectByUserEmailAndPassword(customer_email, customer_password);
    }
    public int hashCode(String customer_name,String customer_email) {
        final int prime = 31;
		int result = 1;
		result = result * prime + (customer_name == null ? 0 : (customer_name).hashCode()); 
		result = result * prime + (customer_email == null ? 0 : (customer_email).hashCode()); 
        
		return result;
    }
}
