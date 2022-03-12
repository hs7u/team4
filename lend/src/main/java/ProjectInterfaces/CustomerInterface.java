package ProjectInterfaces;

import java.io.Serializable;
import java.util.List;

public interface CustomerInterface<CustomerVO> {
    public Serializable insert(CustomerVO customerVo);
    public Boolean update(CustomerVO customerVo);
    public void delete(Integer customerId);
    public void changeStatus(Integer customerId ,Byte statusCode);
    public CustomerVO selectByUserEmail(String customerEmail); 
    public List<CustomerVO> getAll();
    public Long countCustomer();
}
