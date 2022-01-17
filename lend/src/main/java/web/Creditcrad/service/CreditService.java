package web.Creditcrad.service;

import ProjectInterfaces.CreditcradInterface;
import web.Creditcrad.dao.CreditcardDAO;
import web.Creditcrad.vo.CreditcradVO;

public class CreditService {
    private CreditcradInterface<CreditcradVO> dao;
    public CreditService() {
        dao = new CreditcardDAO();
    }
    public CreditcradVO addCreditcard(Integer creditcardNumber, Integer customerId, String cardholderName,
            String cvvCode,String expireMonth, String expireYear) {
        CreditcradVO cVo = new CreditcradVO();
        cVo.setCreditcardNumber(creditcardNumber);
        cVo.setCardholderName(cardholderName);
        cVo.setCustomerId(customerId);
        cVo.setCvvCode(cvvCode);
        cVo.setExpireYear(expireYear);
        cVo.setExpireMonth(expireMonth);
        dao.insert(cVo);
        return cVo;
    }
    public CreditcradVO updateCreditcard(Integer creditcardNumber, Integer customerId, String cardholderName,
            String cvvCode,String expireMonth, String expireYear){
        CreditcradVO cVo = new CreditcradVO();
        cVo.setCreditcardNumber(creditcardNumber);
        cVo.setCardholderName(cardholderName);
        cVo.setCustomerId(customerId);
        cVo.setCvvCode(cvvCode);
        cVo.setExpireYear(expireYear);
        cVo.setExpireMonth(expireMonth);
        dao.update(cVo);
        return cVo;
    }
    public void deleteCreditcard(Integer customerId) {
        dao.delete(customerId);
    }
    public CreditcradVO getOneCard(Integer customerId){
        return dao.selectByCustomerId(customerId);
    }
}
