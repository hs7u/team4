package ProjectInterfaces;

public interface CustomerInterface<CustomerVO> {
    public void insert(CustomerVO customerVo);
    public void update(CustomerVO customerVo);
    public void delete(Integer customer_id);
    public void changeStatus(Integer customer_id ,Byte status_code);
    public CustomerVO selectByUserEmailAndPassword(String customer_email, String customer_password); 
    // public List<CustomerVO> getAll();
}
