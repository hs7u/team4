package web.Customer.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import web.Customer.service.CustomerService;
import web.Customer.vo.CustomerVO;

import org.springframework.web.bind.annotation.RequestMethod;

@RestController
public class CustomerLoginController {
    @Autowired
    private CustomerService cs;
    @RequestMapping(path = {"/Customer/login"}, method=RequestMethod.POST)
    public String login(@RequestBody(required = false) CustomerVO vo, HttpSession session) {
        if(session.getAttribute("cuatomerAccount") == null){
            StringBuilder errorMsg = new StringBuilder();
            if (vo.getCustomerEmail().trim().isEmpty()) {
                errorMsg.append("帳號不得為空"+System.lineSeparator());
            }
            if (vo.getCustomerPassword().trim().isEmpty()) {
                errorMsg.append("密碼不得為空"+System.lineSeparator());
            }
            if(errorMsg.length() > 0){
                return errorMsg.toString();
            }      
            CustomerVO check = cs.getOneCustomer(vo.getCustomerEmail(), vo.getCustomerPassword());
            if(check != null && check.getCustomerStatus() != 0){
                session.setAttribute("customerAccount", check.getCustomerEmail());
                session.setAttribute("customerInfo", check);
                return "Login Success";
            }else{
                return "Account or Password incorrect";
            }
        }
        return "Already login";
    }
}
