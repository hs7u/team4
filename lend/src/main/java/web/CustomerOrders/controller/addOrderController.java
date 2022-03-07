package web.CustomerOrders.controller;

import ecpay.payment.integration.AllInOne;
import ecpay.payment.integration.domain.AioCheckOutALL;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import web.Customer.vo.CustomerVO;
import web.CustomerOrders.service.CustomerOrdersService;
import web.CustomerOrders.vo.CustomerOrdersVO;
import web.OrderDetail.service.OrderService;
import web.OrderDetail.vo.OrderDetailVO;

@Controller
public class addOrderController {
    @Autowired
    private CustomerOrdersService cos;
    @Autowired
    private OrderService os;
    public static AllInOne all;
    private String pattern = "yyyy/MM/dd HH:mm:ss";//2022/03/07 09:35:50
    @RequestMapping(path = {"/Customer/Order/checkout"})
    public String insert(@RequestBody(required = false) List<Map<String, String>> orderDetail, HttpSession session){
        CustomerVO currentCustomer = (CustomerVO)session.getAttribute("customerInfo");
        CustomerOrdersVO order = new CustomerOrdersVO();
        order.setCustomerId(currentCustomer.getCustomerId());
        order.setShippingMethodCode(11);
        order.setRecipient(currentCustomer.getCustomerName());
        order.setSendersAddress(currentCustomer.getCustomerAddress());
        
        String result = cos.addOrder(order);
        if(result.matches("-?\\d+")){
            CustomerOrdersVO currentOrder = cos.getOneOrder(Integer.valueOf(result));
            Integer amount = orderDetail.stream().mapToInt(e -> Integer.valueOf(e.get("productPrice"))).sum();
            String itemName = orderDetail.stream().map(e -> e.get("productName")).collect(Collectors.joining("#"));
            
            for(Map<String, String> detail : orderDetail){
                OrderDetailVO singVo = new OrderDetailVO();
                singVo.setOrderId(currentOrder.getOrderId());
                singVo.setProductId(Integer.parseInt(detail.get("productId")));
                singVo.setProductPrice(Integer.parseInt(detail.get("productPrice")));
                singVo.setProductQuantity(Integer.parseInt(detail.get("productQuantity")));
                os.insert(singVo);
            }

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            String date = simpleDateFormat.format(currentOrder.getOrderCreatedDate().getTime());
            AioCheckOutALL obj = new AioCheckOutALL();
            obj.setMerchantTradeNo("studio4art"+currentOrder.getOrderId());
            obj.setMerchantTradeDate(date);
            obj.setTotalAmount(amount.toString());
            obj.setTradeDesc(currentOrder.getOrderDetails());
            obj.setItemName(itemName);
            obj.setReturnURL("http://211.23.128.214:5000");
            obj.setNeedExtraPaidInfo("N");
            return all.aioCheckOut(obj, null);
        }
        return result;
    }
}
