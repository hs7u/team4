package web.Customer.controller;

import static web.CommonUtil.projectUtil.getCode;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
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
    @Autowired
    private PasswordEncoder passwordEncoder;
    ScheduledExecutorService ses = Executors.newScheduledThreadPool(10);
    @RequestMapping(path = {"/Customer/regist"}, method=RequestMethod.POST)
    public String regist(@RequestBody(required = false) CustomerVO vo ,HttpSession session) {
        String code = getCode();
        String t = passwordEncoder.encode(vo.getCustomerPassword());
        vo.setCustomerPassword(t);
        String result = cs.addCustomer(vo, code);
        if("success".equals(result)){
            session.setAttribute(vo.getCustomerEmail(), code);
//            try {
//                ses.schedule(new Thread(() -> {
//                    session.invalidate();
//                }), 10*60, TimeUnit.SECONDS);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
            return result;
        }
        return result;
    }
}
