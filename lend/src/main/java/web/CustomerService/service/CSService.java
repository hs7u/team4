package web.CustomerService.service;

import ProjectInterfaces.CustomerServiceInterface;
import web.CustomerService.dao.CustomerServiceDAO;
import web.CustomerService.vo.CustomerServiceVO;

public class CSService {
    private CustomerServiceInterface<CustomerServiceVO> dao;
    public CSService() {
        dao = new CustomerServiceDAO();
    }
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
