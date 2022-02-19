package web.CustomerService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ProjectInterfaces.CustomerServiceInterface;
import web.CustomerService.vo.CustomerServiceVO;

@Service
@Transactional
public class CSService {
    @Autowired
    private CustomerServiceInterface<CustomerServiceVO> dao;
    // private CustomerServiceDAO dao;
    // public CSService(Session session) {
    //     dao = new CustomerServiceDAO(session);
    // }
    public CustomerServiceVO addProblem(Integer cusotmerId, String messageTitle, String messageContext) {
        java.sql.Timestamp messageTime = new java.sql.Timestamp(System.currentTimeMillis());
        CustomerServiceVO csVO = new CustomerServiceVO();
        csVO.setCusotmerId(cusotmerId);
        csVO.setMessageTitle(messageTitle);
        csVO.setMessageTime(messageTime);
        csVO.setMessageContext(messageContext);
        dao.insert(csVO);
        return csVO;
    }
    public CustomerServiceVO addReply(Integer messageId, Integer cusotmerId, String messageTitle, String messageContext, String replyContext){
        CustomerServiceVO csVO = new CustomerServiceVO();
        csVO.setMessageId(messageId);
        csVO.setMessageTitle(messageTitle);
        csVO.setMessageContext(messageContext);
        csVO.setCusotmerId(cusotmerId);
        csVO.setReplyContext(replyContext);
        dao.update(csVO);
        return csVO;
    }
    public CustomerServiceVO getOneReply(Integer messageId){
        return dao.selectByMessageId(messageId);
    }
}
