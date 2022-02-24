package web.Admin.controller;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import web.Admin.service.AdminService;
import web.Admin.vo.AdminVO;

@RestController
public class LoginController {    
    @Autowired
    private AdminService as;

    @RequestMapping(path = {"/Admin/login"}, method = RequestMethod.POST)
    public String login(@RequestBody(required = false) AdminVO login, HttpSession session) {
        if(session.getAttribute("account") == null){
            StringBuilder errorMsg = new StringBuilder();
            if (login.getAdminAccount().trim().isEmpty()) {
                errorMsg.append("帳號不得為空"+System.lineSeparator());
            }
            if (login.getAdminPassword().trim().isEmpty()) {
                errorMsg.append("密碼不得為空"+System.lineSeparator());
            }
            if(errorMsg.length() > 0){
                return errorMsg.toString();
            }      
            AdminVO check = as.getOneManager(login);
            if(check != null){
                session.setAttribute("account", check.getAdminAccount());
                session.setAttribute("info", check);
                return "Login Success";
            }else{
                return "Account or Password incorrect";
            }
        }
        return "Already login";
    }
}
