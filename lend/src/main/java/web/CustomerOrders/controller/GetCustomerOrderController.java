package web.CustomerOrders.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import web.Customer.vo.CustomerVO;
import web.CustomerOrders.service.CustomerOrdersService;

@RestController
public class GetCustomerOrderController {
    @Autowired
    private CustomerOrdersService cos;
    @RequestMapping(path = {"/Customer/check/orders"})
    public ResponseEntity<?> getCustomerOrderDetail(HttpSession session){
        return new ResponseEntity<>(cos.getCustomerAllOrder(
                                    ((CustomerVO)session.getAttribute("customerInfo")).getCustomerId()
                                    ), HttpStatus.OK);
    }
}
