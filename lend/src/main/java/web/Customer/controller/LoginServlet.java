package web.Customer.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;

import com.google.gson.Gson;

import web.Customer.service.CustomerService;
import web.Customer.vo.CustomerVO;

@WebServlet("/Customer/login")
public class LoginServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req,res);
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html; charset=UTF-8");
		BufferedReader reader = req.getReader();
		Gson gson = new Gson();
		
		CustomerVO login = gson.fromJson(reader, CustomerVO.class);
		System.out.println(login.getCustomerEmail());
		System.out.println(login.getCustomerPassword());
		
	    PrintWriter out = res.getWriter();
		HttpSession session = req.getSession();
		Integer account = (Integer)session.getAttribute("customerId");
	    if (account == null) {
	    	CustomerService cs = new CustomerService((Session)req.getAttribute("session"));
	    	CustomerVO cVo = cs.getOneCustomer(login.getCustomerEmail(),login.getCustomerPassword());
	    	if(cVo.getCustomerEmail() != null) {
	    		account = cVo.getCustomerId();
	    		session.setAttribute("customerId", account);
	    		out.println(cVo.getCustomerName()+"Login Success");
	    	} else {
    			out.println("Username or Password incorrect");
     		}
    		
	    }else{
			req.getRequestDispatcher("/404.html").forward(req, res);
		}
	}

}
