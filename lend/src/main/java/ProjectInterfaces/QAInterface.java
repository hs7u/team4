package ProjectInterfaces;

public interface QAInterface <QAVO>{
    public void insert(QAVO qavo); 
    public void update(QAVO qavo);      
    public void delete(Integer qaId);      
    public QAVO selectByQAId(Integer qaId);
}
