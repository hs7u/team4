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
    public QAVO updateQA(Integer qa_id, String answer, String quession){
        QAVO qavo = new QAVO();
        qavo.setQa_id(qa_id);
        qavo.setQuession(quession);
        qavo.setQuession(quession);
        dao.update(qavo);
        return qavo;
    }
    public void deleteQA(Integer qa_id) {
        dao.delete(qa_id);
    }
    public QAVO selectByQAId(Integer qa_id) {
        return dao.selectByQAId(qa_id);
    }
}
