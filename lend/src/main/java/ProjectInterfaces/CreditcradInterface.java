package ProjectInterfaces;

public interface CreditcradInterface<CreditcradVO> {
    public void insert(CreditcradVO cVo);
    public void update(CreditcradVO cVo);
    public void delete(Integer customer_id);
    public CreditcradVO selectByCustomerId(Integer customer_id);
}
