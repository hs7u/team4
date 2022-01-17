package web.CustomerService.service;

import ProjectInterfaces.CustomerServiceInterface;
import web.CustomerService.dao.CustomerServiceDAO;
import web.CustomerService.vo.CustomerServiceVO;

public class CSService {
    private CustomerServiceInterface<CustomerServiceVO> dao;
    public CSService() {
        dao = new CustomerServiceDAO();
    }
    public CustomerServiceVO addProblem(Integer cusotmer_id, String message_title, String message_context) {
        java.sql.Timestamp message_time = new java.sql.Timestamp(System.currentTimeMillis());
        CustomerServiceVO csVO = new CustomerServiceVO();
        csVO.setCusotmer_id(cusotmer_id);
        csVO.setMessage_title(message_title);
        csVO.setMessage_time(message_time);
        csVO.setMessage_context(message_context);
        dao.insert(csVO);
        return csVO;
    }
    public CustomerServiceVO addReply(Integer message_id, Integer cusotmer_id, String message_title, String message_context, String reply_context){
        CustomerServiceVO csVO = new CustomerServiceVO();
        csVO.setMessage_id(message_id);
        csVO.setMessage_title(message_title);
        csVO.setMessage_context(message_context);
        csVO.setCusotmer_id(cusotmer_id);
        csVO.setReply_context(reply_context);
        dao.update(csVO);
        return csVO;
    }
    public CustomerServiceVO getOneReply(Integer message_id){
        return dao.selectByMessageId(message_id);
    }
}
