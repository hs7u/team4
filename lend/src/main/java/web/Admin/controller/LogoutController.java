package web.Admin.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogoutController {
    @RequestMapping(path = {"/Admin/logout"}, method = RequestMethod.GET)
    public void logout(HttpSession session, HttpServletResponse response) throws IOException{
        if (!session.isNew() && session.getAttribute("account") != null) {
	    	session.invalidate();
			response.sendRedirect("/lend/Admin/login.html");  
    	}else {
    		response.sendRedirect("/lend/Admin/login.html");
    	}
    }
}
