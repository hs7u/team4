package web.Customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import web.Customer.service.CustomerService;

@RestController
public class AccountInitController {
    @Autowired
    private CustomerService cs;
    @RequestMapping(path = {"/Customer/init/id/{param1}/status/{param2}"})
    public void init(@PathVariable("param1") Integer customeId, @PathVariable("param2") Byte statusCode){
        cs.changeStatus(customeId, statusCode);
    }
}
