package ProjectInterfaces;

public interface CustomerOrderInterface<CustomerOrdersVO> {
    public void insert(CustomerOrdersVO coVo);
    public void update(CustomerOrdersVO coVo);
    public void delete(Integer order_id);
    public void updateStatus(String status_name, Integer order_id,Byte status_code);
    public CustomerOrdersVO selectByOrderId(Integer order_id);    
}
