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
    	if (!session.isNew() && session.getAttribute("customerAccount") != null) {
    		System.out.println("logout");
    		response.setHeader("Pragma","No-cache");   
    		response.setHeader("Cache-Control","no-cache");   
    		response.setDateHeader("Expires", 0);
    		session.removeAttribute("customerAccount");
	    	session.invalidate();
			response.sendRedirect("../login-register.html");  
    	}else {
    		response.sendRedirect("../index.html");
    	}
    }
}
