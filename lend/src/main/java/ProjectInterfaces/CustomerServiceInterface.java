package ProjectInterfaces;

public interface CustomerServiceInterface<CustomerServiceVO> {
    public void insert(CustomerServiceVO csVO);
    public void update(CustomerServiceVO csVO);
    public CustomerServiceVO selectByMessageId(Integer messageId);
}
