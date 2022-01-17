package web.Qa.service;

import ProjectInterfaces.QAInterface;
import web.Qa.dao.QADAO;
import web.Qa.vo.QAVO;

public class QAService {
    private QAInterface<QAVO> dao;
    public QAService() {
        dao = new QADAO();
    }
    public QAVO addQA(String answer, String quession) {
        QAVO qavo = new QAVO();
        qavo.setQuession(quession);
        qavo.setQuession(quession);
        dao.insert(qavo);
        return qavo;
    }
    public QAVO updateQA(Integer qaId, String answer, String quession){
        QAVO qavo = new QAVO();
        qavo.setQaId(qaId);
        qavo.setQuession(quession);
        qavo.setQuession(quession);
        dao.update(qavo);
        return qavo;
    }
    public void deleteQA(Integer qaId) {
        dao.delete(qaId);
    }
    public QAVO selectByQAId(Integer qaId) {
        return dao.selectByQAId(qaId);
    }
}
