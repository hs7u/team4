package web.Creditcrad.service;

import ProjectInterfaces.CreditcradInterface;
import web.Creditcrad.dao.CreditcardDAO;
import web.Creditcrad.vo.CreditcradVO;

public class CreditService {
    private CreditcradInterface<CreditcradVO> dao;
    public CreditService() {
        dao = new CreditcardDAO();
    }
    public CreditcradVO addCreditcard(Integer creditcard_number, Integer customer_id, String cardholder_name,
            String cvv_code,String expire_month, String expire_year) {
        CreditcradVO cVo = new CreditcradVO();
        cVo.setCreditcard_number(creditcard_number);
        cVo.setCardholder_name(cardholder_name);
        cVo.setCustomer_id(customer_id);
        cVo.setCvv_code(cvv_code);
        cVo.setExpire_year(expire_year);
        cVo.setExpire_month(expire_month);
        dao.insert(cVo);
        return cVo;
    }
    public CreditcradVO updateCreditcard(Integer creditcard_number, Integer customer_id, String cardholder_name,
            String cvv_code,String expire_month, String expire_year){
        CreditcradVO cVo = new CreditcradVO();
        cVo.setCreditcard_number(creditcard_number);
        cVo.setCardholder_name(cardholder_name);
        cVo.setCustomer_id(customer_id);
        cVo.setCvv_code(cvv_code);
        cVo.setExpire_year(expire_year);
        cVo.setExpire_month(expire_month);
        dao.update(cVo);
        return cVo;
    }
    public void deleteCreditcard(Integer customer_id) {
        dao.delete(customer_id);
    }
    public CreditcradVO getOneCard(Integer customer_id){
        return dao.selectByCustomerId(customer_id);
    }
}
