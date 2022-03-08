//package web.Customer.controller;
//
//import java.io.IOException;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//
//@WebServlet("/Customer/logout")
//public class LogoutServlet extends HttpServlet {
//	
//	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
//		doPost(req,res);
//	}
//	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
//		req.setCharacterEncoding("UTF-8");
//		res.setContentType("text/html; charset=UTF-8");
//		HttpSession session = req.getSession();
//		Integer account = (Integer)session.getAttribute("customerId");
//	    if (session.isNew() && account != null) {
//	    	session.invalidate();
//			req.getRequestDispatcher("/index.html").forward(req, res);  
//    	}else {
//    		req.getRequestDispatcher(req.getRequestURI()).forward(req, res);
//    	}
//	}
//
//}
