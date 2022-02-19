package web.Creditcrad.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ProjectInterfaces.CreditcradInterface;
import web.Creditcrad.vo.CreditcradVO;

@Service
@Transactional
public class CreditService {
    @Autowired
    private CreditcradInterface<CreditcradVO> dao;
    // private CreditcardDAO dao;
    // public CreditService(Session session) {
    //     dao = new CreditcardDAO(session);
    // }
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
