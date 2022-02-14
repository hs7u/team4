package web.Admin.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import org.hibernate.Session;

import web.Admin.service.AdminService;


@WebServlet("/Admin/dashBoard")
public class dashBoardServlet extends HttpServlet{
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req,res);
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html; charset=UTF-8");
		PrintWriter out = res.getWriter();
		BufferedReader reader = req.getReader();
		Gson gson = new Gson();
		out.println(gson.fromJson(reader, Object.class));
//		Session session = (Session)req.getAttribute("session");
//		switch ((String)gson.fromJson(reader, Object.class)) {
//			case "cusotmer":
//				out.print(getCustomerount(session));
//				break;
//			case "course":
//				out.print(getCourseCount(session));
//				break;
//			case "order":
//				out.print(getOrderCount(session));
//				break;
//			case "income":
//				out.print(getIncomeCount(session));
//				break;
//		}    
    }
	private Integer getCustomerount(Session session) {
		// AdminService as = new AdminService(session);
		return 1;
	}
	private Integer getCourseCount(Session session) {
		// AdminService as = new AdminService(session);
		return 2;
	}
	private Integer getOrderCount(Session session) {
		// AdminService as = new AdminService(session);
		return 3;
	}
	private Integer getIncomeCount(Session session) {
		// AdminService as = new AdminService(session);
		return 4;
	}
}
