package ProjectInterfaces;

import java.io.Serializable;
import java.util.List;

import web.OrderDetail.vo.OrderDetailVO;

public interface CustomerOrderInterface<CustomerOrdersVO> {
    public Serializable insert(CustomerOrdersVO coVo);
    public void update(CustomerOrdersVO coVo);
    public void delete(Integer orderId);
    public void deleteOrderByProductId(Integer productId);
    public void updateStatus(String statusName, Integer orderId,Byte statusCode);
    public CustomerOrdersVO selectByOrderId(Integer orderId);
    public List<CustomerOrdersVO> getAll();
    public Long countOrder(); 
    public List<OrderDetailVO> getAllDetail(Integer orderId);
}
