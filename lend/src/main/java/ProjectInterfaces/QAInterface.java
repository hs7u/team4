package ProjectInterfaces;

public interface QAInterface <QAVO>{
    public void insert(QAVO qavo); 
    public void update(QAVO qavo);      
    public void delete(Integer qa_id);      
    public QAVO selectByQAId(Integer qa_id);
}
