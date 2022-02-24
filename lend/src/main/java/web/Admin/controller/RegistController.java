package web.Admin.controller;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import web.Admin.service.AdminService;
import web.Admin.vo.AdminVO;

@RestController
public class RegistController {
    @Autowired
    private AdminService as;
    @RequestMapping(path = {"/Admin/regist"}, method = RequestMethod.POST)
    public String regist(@RequestBody AdminVO vo, HttpSession session, HttpServletResponse response) {
        if(session.getAttribute("account") == null){
            StringBuilder errorMsg = new StringBuilder();
            if (vo.getAdminAccount().trim().isEmpty()) {
	    		errorMsg.append("帳號不得為空"+System.lineSeparator());
	    	}
	    	if (vo.getAdminPassword().trim().isEmpty()) {
	    		errorMsg.append("密碼不得為空"+System.lineSeparator());
	    	}
            if(errorMsg.length() > 0){
                return errorMsg.toString();
            }
            AdminVO regist = as.getOneManager(vo);
            if(regist == null){
                as.newManager(vo);
                return "Regist Success";
            }
            return "Regist Fail";
        }
        return "Account Exist";
    }
}
