package ProjectInterfaces;

import java.util.List;

public interface CustomerOrderInterface<CustomerOrdersVO> {
    public void insert(CustomerOrdersVO coVo);
    public void update(CustomerOrdersVO coVo);
    public void delete(Integer orderId);
    public void updateStatus(String statusName, Integer orderId,Byte statusCode);
    public CustomerOrdersVO selectByOrderId(Integer orderId);
    public List<CustomerOrdersVO> getAll();
    public Long countOrder(); 
}
