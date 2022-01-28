package web.Customer.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;

import web.Customer.service.CustomerService;
import web.Customer.vo.CustomerVO;

@WebServlet("/member/login")
public class LoginServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req,res);
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html; charset=UTF-8");
	    PrintWriter out = res.getWriter();
		HttpSession session = req.getSession();
		Integer account = (Integer)session.getAttribute("Customer.Id");
	    if (account == null) {
	    	CustomerService cs = new CustomerService((Session)req.getAttribute("session"));
	    	CustomerVO cVo = cs.getOneCustomer(req.getParameter("email"), req.getParameter("password"));
	    	if(cVo.getCustomerEmail() != null) {
	    		account = cVo.getCustomerId();
	    		session.setAttribute("Customer.Id", account);
//	    		req.setAttribute("message", cVo.getCustomer_name()+"Login Success");
	    		out.println(cVo.getCustomerName()+"Login Success");
	    	} else {
//    			req.setAttribute("message", "Username or Password incorrect");
    			out.println("Username or Password incorrect");
     		}
    		
	    }
//		req.getRequestDispatcher("/Home.html").forward(req, res);
	}

}
