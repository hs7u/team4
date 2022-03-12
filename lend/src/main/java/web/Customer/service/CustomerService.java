package web.Customer.service;

import static web.CommonUtil.StaticUtil.MAIL_SUBJECT;
import static web.CommonUtil.StaticUtil.ATAG_HREF;
import static web.CommonUtil.StaticUtil.ATAG_AfterParam;

import java.sql.Date;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.TaskExecutor;
import org.springframework.mail.MailParseException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ProjectInterfaces.CustomerInterface;
import web.Customer.vo.CustomerVO;

@Service
@Transactional
public class CustomerService {
    @Autowired
    private CustomerInterface<CustomerVO> dao;
    @Autowired
    private JavaMailSender mailSender;      
    @Autowired
    private TaskExecutor taskExecutor;
    // private CustomerDAO dao;
    // private SessionFactory sf;
    // private Session session;
	// public CustomerService(Session session) {
    	// this.sf = HibernateUtil.getSessionfactory();
    	// this.session = this.sf.getCurrentSession();
    //     dao = new CustomerDAO(session);
    // }
    public String addCustomer(CustomerVO cVo, String code) {
        java.sql.Timestamp customerRegisterTime = new java.sql.Timestamp(System.currentTimeMillis());
        StringBuilder errorMsg = new StringBuilder();
        if(cVo.getCustomerName().trim().isEmpty())
            errorMsg.append("姓名不得為空"+System.lineSeparator());
        if(cVo.getCustomerEmail().trim().isEmpty())
            errorMsg.append("信箱不得為空"+System.lineSeparator());
        if(cVo.getCustomerPassword().trim().isEmpty())
            errorMsg.append("密碼不得為空"+System.lineSeparator());
        if(cVo.getCustomerPhone().trim().isEmpty())
            errorMsg.append("電話不得為空"+System.lineSeparator());
        if(cVo.getCustomerBirthday() == null)
            errorMsg.append("生日不得為空"+System.lineSeparator());
        if(cVo.getCustomerAddress().trim().isEmpty())
            errorMsg.append("地址不得為空"+System.lineSeparator());
        if(errorMsg.length() > 0){
            return errorMsg.toString();
        } 
        cVo.setCustomerRegisterTime(customerRegisterTime);
        Integer id = (Integer)dao.insert(cVo);
        if(id!= null){
            String text = "id/"+id+"/status/1/account/"+cVo.getCustomerEmail()+"/check/"+code;
            try {
                sendMail(ATAG_HREF+text+ATAG_AfterParam, cVo.getCustomerEmail(), MAIL_SUBJECT);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return "success";
        }
        return "fail";
    }
    public void oauth2User(CustomerVO vo) {
    	java.sql.Timestamp customerRegisterTime = new java.sql.Timestamp(System.currentTimeMillis());
        vo.setCustomerRegisterTime(customerRegisterTime);
    	dao.insert(vo);
    }
    public String updateCustomer(CustomerVO cVo, CustomerVO check){
        if(cVo.getCustomerName().trim().isEmpty())
            cVo.setCustomerName(check.getCustomerName());
        if(cVo.getCustomerEmail().trim().isEmpty())
            cVo.setCustomerEmail(check.getCustomerEmail());
        if(cVo.getCustomerPassword().trim().isEmpty())
            cVo.setCustomerPassword(check.getCustomerPassword());
        if(cVo.getCustomerPhone().trim().isEmpty())
            cVo.setCustomerPhone(check.getCustomerPhone());
        if(cVo.getCustomerBirthday() == null)
            cVo.setCustomerBirthday(check.getCustomerBirthday());
        if(cVo.getCustomerGender().trim().isEmpty())
            cVo.setCustomerGender(check.getCustomerGender());
        if(cVo.getCustomerAddress().trim().isEmpty())
            cVo.setCustomerAddress(check.getCustomerAddress());
        if(dao.update(cVo)){
            return "success";
        }
        return "false";
    }
    public void deleteCustomer(Integer customeId){
        dao.delete(customeId);
    }
    public void changeStatus(Integer customeId ,Byte statusCode){
        dao.changeStatus(customeId, statusCode);
    }
    public CustomerVO getOneCustomer(String customerEmail){
    	try {
			CustomerVO cVo = dao.selectByUserEmail(customerEmail);
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
    /*
    *   mail sending 
    */
    public void sendMail(final String text, final String to, final String subject) throws Exception {
        taskExecutor.execute( new Runnable() {
            public void run() {
                try {
                    sendMailSimple(text, to, subject);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
       });
    }
    private void sendMailSimple(String text, String to, String subject) throws Exception { 
        MimeMessage message = mailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(text, true);
        } catch (MessagingException e) {
            throw new MailParseException(e);
        }
        mailSender.send(message);
    }
}
