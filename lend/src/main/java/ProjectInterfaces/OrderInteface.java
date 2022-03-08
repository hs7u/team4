package ProjectInterfaces;

import java.util.List;

import com.fasterxml.jackson.databind.node.ObjectNode;

public interface OrderInteface<OrderDetailVO> {
    public void insert(OrderDetailVO vo);
    public void update(OrderDetailVO vo);
    public void delete(Integer orderDetailsId);
    public void deleteWithProduct(Integer productId);
    public OrderDetailVO getOneDetail(Integer orderDetailsId);
    public List<ObjectNode> getAllDetail(Integer orderId);
}
