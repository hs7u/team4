package ProjectInterfaces;

public interface CreditcradInterface<CreditcradVO> {
    public void insert(CreditcradVO cVo);
    public void update(CreditcradVO cVo);
    public void delete(Integer customerId);
    public CreditcradVO selectByCustomerId(Integer customerId);
}
