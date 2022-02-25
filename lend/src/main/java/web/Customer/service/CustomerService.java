package web.Customer.service;

import java.sql.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ProjectInterfaces.CustomerInterface;
import web.Customer.vo.CustomerVO;

@Service
@Transactional
public class CustomerService {
    @Autowired
    private CustomerInterface<CustomerVO> dao;
    // private CustomerDAO dao;
    // private SessionFactory sf;
    // private Session session;
	// public CustomerService(Session session) {
    	// this.sf = HibernateUtil.getSessionfactory();
    	// this.session = this.sf.getCurrentSession();
    //     dao = new CustomerDAO(session);
    // }
    public String addCustomer(CustomerVO cVo) {
        java.sql.Timestamp customerRegisterTime = new java.sql.Timestamp(System.currentTimeMillis());
        StringBuilder errorMsg = new StringBuilder();
        if(cVo.getCustomerName().trim().isEmpty()){
            errorMsg.append("姓名不得為空"+System.lineSeparator());
        }
        if(cVo.getCustomerEmail().trim().isEmpty()){
            errorMsg.append("信箱不得為空"+System.lineSeparator());
        }
        if(cVo.getCustomerPassword().trim().isEmpty()){
            errorMsg.append("密碼不得為空"+System.lineSeparator());
        }
        if(cVo.getCustomerPhone().trim().isEmpty()){
            errorMsg.append("電話不得為空"+System.lineSeparator());
        }
        if(cVo.getCustomerBirthday() == null){
            errorMsg.append("生日不得為空"+System.lineSeparator());
        }
        if(cVo.getCustomerAddress().trim().isEmpty()){
            errorMsg.append("地址不得為空"+System.lineSeparator());
        }
        if(errorMsg.length() > 0){
            return errorMsg.toString();
        } 
        cVo.setCustomerRegisterTime(customerRegisterTime);
        return dao.insert(cVo);
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
    	try {
			CustomerVO cVo = dao.selectByUserEmailAndPassword(customerEmail, customerPassword);
			return cVo;
		} catch (HibernateException e) {
			e.printStackTrace();
		}
    	return null;
    }
    public List<CustomerVO> getAllCustomer() {
        return dao.getAll();
    }
    public Long countCustomer() {
        return dao.countCustomer();
    }
}
