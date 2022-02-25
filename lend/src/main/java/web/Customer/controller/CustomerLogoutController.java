package web.Customer.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
public class CustomerLogoutController {
    @RequestMapping(path = {"/Customer/logout"}, method=RequestMethod.GET)
    public void customerLogout(HttpSession session, HttpServletResponse response) throws IOException{
        if (!session.isNew() && session.getAttribute("customerAccount") != null) {
	    	session.invalidate();
			response.sendRedirect("/lend/Customer/login.html");  
    	}else {
    		response.sendRedirect("/lend/Customer/login.html");
    	}
    }
}
