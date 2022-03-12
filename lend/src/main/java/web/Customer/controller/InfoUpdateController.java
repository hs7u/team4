package web.Customer.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import web.Customer.service.CustomerService;
import web.Customer.vo.CustomerVO;

@RestController
public class InfoUpdateController {
    @Autowired
    private CustomerService cs;
    @PostMapping(path = {"/Customer/info/update"})
    public ResponseEntity<String> update(@RequestBody(required = false) CustomerVO vo, HttpSession session){
        CustomerVO check = (CustomerVO)session.getAttribute("customerInfo");
        return new ResponseEntity<>(cs.updateCustomer(vo, check), HttpStatus.OK);
    }
}
