package ProjectInterfaces;

import java.util.List;

public interface CustomerInterface<CustomerVO> {
    public String insert(CustomerVO customerVo);
    public void update(CustomerVO customerVo);
    public void delete(Integer customerId);
    public void changeStatus(Integer customerId ,Byte statusCode);
    public CustomerVO selectByUserEmailAndPassword(String customerEmail, String customerPassword); 
    public List<CustomerVO> getAll();
    public Long countCustomer();
}
