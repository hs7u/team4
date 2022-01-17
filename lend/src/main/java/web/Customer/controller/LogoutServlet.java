package web.Customer.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web.Customer.service.CustomerService;
import web.Customer.vo.CustomerVO;

@WebServlet("/member/logout")
public class LogoutServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req,res);
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html; charset=UTF-8");
	    PrintWriter out = res.getWriter();
		HttpSession session = req.getSession();
		Integer account = (Integer)session.getAttribute("Customer.Id");
	    if (session.isNew() && account != null) {
	    	session.invalidate();  
//	    		req.setAttribute("message", cVo.getCustomer_name()+"Login Success");
    		out.println("Logout Success");
    	}else {
    		req.getRequestDispatcher(req.getRequestURI()).forward(req, res);
    	}
//		req.getRequestDispatcher("/Home.html").forward(req, res);
	}

}
