package web.OrderDetail.service;

import java.util.List;

import com.fasterxml.jackson.databind.node.ObjectNode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ProjectInterfaces.OrderInteface;
import web.OrderDetail.vo.OrderDetailVO;

@Service
@Transactional
public class OrderService {
    @Autowired
    private OrderInteface<OrderDetailVO> dao;
    public String insert(OrderDetailVO vo){
        StringBuilder errorMsg = new StringBuilder();
        if (vo.getProductPrice() == null) {
            errorMsg.append("價格不得為空"+System.lineSeparator());
        }
        if (vo.getProductQuantity() == null) {
            errorMsg.append("數量不得為空"+System.lineSeparator());
            return errorMsg.toString();
        }
        if (vo.getProductPrice() <= 0) {
            errorMsg.append("價格不能小於0"+System.lineSeparator());
        }
        if (vo.getProductQuantity() <= 0) {
            errorMsg.append("數量不得為0"+System.lineSeparator());
        }
        if(errorMsg.length() <= 0){
            dao.insert(vo);
            return "success";
        }
        return errorMsg.toString();
    }
    public String update(OrderDetailVO vo){
        OrderDetailVO update = dao.getOneDetail(vo.getOrderDetailsId());
        if(update != null){
            if(vo.getProductPrice() <= 0 || vo.getProductPrice() == null)
                vo.setProductPrice(update.getProductPrice());
            if(vo.getProductQuantity() <= 0 || vo.getProductQuantity() == null)
                vo.setProductQuantity(update.getProductQuantity());
            dao.update(vo);
            return "success";
        }
        return "No such order";
    }
    public void delete(Integer orderDetailsId){
        dao.delete(orderDetailsId);
    }
    public void deleteWithProduct(Integer productId){
        dao.delete(productId);
    }
    public OrderDetailVO getOneDetail(Integer orderDetailsId){
        return dao.getOneDetail(orderDetailsId);
    }
    public List<ObjectNode> getAllDetail(Integer orderId){
        return dao.getAllDetail(orderId);
    }
}
