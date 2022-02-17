package web.Admin.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import org.hibernate.Session;

import web.Admin.vo.AdminVO;
import web.Course.service.CourseService;
import web.Course.vo.CourseVO;
import web.Customer.service.CustomerService;
import web.Customer.vo.CustomerVO;


@WebServlet("/Admin/dashBoard")
public class dashBoardServlet extends HttpServlet{
	private int i = 1;
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req,res);
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html; charset=UTF-8");
		PrintWriter out = res.getWriter();
		BufferedReader reader = req.getReader();
		Gson gson = new Gson();
		JsonObject jsonObject = gson.fromJson(reader, JsonObject.class);
		Session session = (Session)req.getAttribute("session");
		switch (jsonObject.get("action").getAsString()) {
			case "customer":
				out.print(getCustomerount(session));
				break;
			case "course":
				out.print(getCourseCount(session));
				break;
			case "order":
				out.print(getOrderCount(session));
				break;
			case "income":
				out.print(getIncomeCount(session));
				break;
			case "accountInfo":
				out.print(getAccountInfo((AdminVO)req.getSession().getAttribute("info")));
				break;
			case "customerList":
				out.print(getCustomerList(session));
				break;
			case "courseList":
				out.print(getCourseList(session));
				break;
		}    
    }
	private int getCustomerount(Session session) {
		// AdminService as = new AdminService(session);
		this.i++;
		return i;
	}
	private int getCourseCount(Session session) {
		// AdminService as = new AdminService(session);
		this.i+=2;
		return i;
	}
	private int getOrderCount(Session session) {
		// AdminService as = new AdminService(session);
		this.i+=3;
		return i;
	}
	private int getIncomeCount(Session session) {
		// AdminService as = new AdminService(session);
		this.i+=4;
		return i;
	}
	private String getAccountInfo(AdminVO aVo) {
		Gson gson = new Gson();	
		aVo.setAdminPassword("********");	
		return gson.toJson(aVo);
	}
	private String getCustomerList(Session session) {
		CustomerService cs = new CustomerService(session);
		List<CustomerVO> list =  cs.getAllCustomer();
		Gson gson = new Gson();		
		return gson.toJson(list);
	}
	private String getCourseList(Session session){
		CourseService cs = new CourseService(session);
		List<CourseVO> list = cs.getALL();
		Gson gson = new Gson();		
		return gson.toJson(list);
	}
}
