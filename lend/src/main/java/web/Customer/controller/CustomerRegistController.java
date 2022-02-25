package web.Customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import web.Customer.service.CustomerService;
import web.Customer.vo.CustomerVO;

import org.springframework.web.bind.annotation.RequestMethod;

@RestController
public class CustomerRegistController {
    @Autowired
    private CustomerService cs;
    @RequestMapping(path = {"/Customer/regist"}, method=RequestMethod.POST)
    public String regist(@RequestBody(required = false) CustomerVO vo ) {
        return cs.addCustomer(vo);
    }
}
