package web.CustomerOrders.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import web.CustomerOrders.service.CustomerOrdersService;
import web.CustomerOrders.vo.CustomerOrdersVO;

@RestController
public class addOrderController {
    @Autowired
    private CustomerOrdersService cos;
    @RequestMapping(path = {"/Customer/Order/add"})
    public String insert(@RequestBody(required = false) CustomerOrdersVO coVo){
        return cos.addOrder(coVo);
    }
}
