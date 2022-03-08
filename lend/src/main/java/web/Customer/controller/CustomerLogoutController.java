package web.Customer.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
public class CustomerLogoutController {
	@GetMapping(path = {"/Customer/logout"})
    public void customerLogout(HttpSession session, HttpServletResponse response) throws IOException{
        System.out.println("logout");
    	if (!session.isNew() && session.getAttribute("customerAccount") != null) {
	    	session.invalidate();
			response.sendRedirect("../login-register.html");  
    	}else {
    		response.sendRedirect("./index.html");
    	}
    }
}
