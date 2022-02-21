package web.Mail.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import web.Customer.vo.CustomerVO;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;



//@Repository
public class MailDao {	
	
//	@Autowired
//	SessionFactory factory ;

    public MailDao() {
    }
    
    // 更改驗證狀態碼(欄位沒有)
    public void changeVerification(String type , String email , String hash) {
    	String CustomerVO = "CustomerVO";
    	
    	String hql = "From " + CustomerVO + " WHERE email= :memail and hash= :mhash and verification = :mverification ";
//    	Session session = factory.getCurrentSession();
    	CustomerVO customerVO = new CustomerVO();
//    	customerVO = (customerVO) session.createQuery(hql)
//					               						.setParameter("customerEmail", customerEmail)
//					               						.setParameter("mhash", hash)					               											               						
//					               						.getSingleResult();
//    	session.update(customerVO);    	
	}   
}
