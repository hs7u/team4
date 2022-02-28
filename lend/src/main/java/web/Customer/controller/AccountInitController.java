package web.Customer.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import web.Customer.service.CustomerService;

@RestController
public class AccountInitController {
    @Autowired
    private CustomerService cs;
    @RequestMapping(path = {"/Customer/init/id/{param1}/status/{param2}/account/{param3}/check/{param4}"})
    public String accountInit(@PathVariable("param1") Integer customeId, @PathVariable("param2") Byte statusCode,
                      @PathVariable("param3") String email,  @PathVariable("param4") String code, HttpSession session){
        if(((String)session.getAttribute(email)).equals(code)){
            cs.changeStatus(customeId, statusCode);
            session.removeAttribute(email);
            return "success";
        }
        return "account not found";
    }
}
