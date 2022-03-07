package ProjectInterfaces;

import java.util.List;

public interface OrderInteface<OrderDetailVO> {
    public void insert(OrderDetailVO vo);
    public void update(OrderDetailVO vo);
    public void delete(Integer orderDetailsId);
    public void deleteWithProduct(Integer productId);
    public OrderDetailVO getOneDetail(Integer orderDetailsId);
    public List<OrderDetailVO> getAllDetail(Integer orderId);
}
