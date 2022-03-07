package web.Course.controller;

import static web.CommonUtil.projectUtil.getBean;
import static web.CommonUtil.projectUtil.json2Pojo;
import static web.CommonUtil.projectUtil.writePojo2Json;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonObject;

import web.Admin.vo.AdminVO;
import web.Course.service.CourseService;
import web.Customer.service.CustomerService;


@WebServlet("/Course/courseList")
public class courseListServlet extends HttpServlet{
	private int i = 1;
	private CustomerService cs;
	private CourseService csc;
	public void init() throws ServletException {
		csc = getBean(getServletContext(), CourseService.class);
		cs = getBean(getServletContext(), CustomerService.class);
	}
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req,res);
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html; charset=UTF-8");
		PrintWriter out = res.getWriter();
		JsonObject jsonObject = json2Pojo(req, JsonObject.class);
		// getCourseList(res);
		switch (jsonObject.get("action").getAsString()) {
			case "customer":
				out.print(getCustomerount());
				break;
			case "course":
				out.print(getCourseCount());
				break;
			case "order":
				out.print(getOrderCount());
				break;
			case "income":
				out.print(getIncomeCount());
				break;
			case "accountInfo":
				getAccountInfo(res, (AdminVO)req.getSession().getAttribute("info"));
				break;
			case "customerList":
				getCustomerList(res);
				break;
			case "courseList":
				getCourseList(res);
				break;
		}
//		String url = "/emp/listAllEmp.jsp";
//		RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllEmp.jsp
//		successView.forward(req, res);			
    }
	private int getCustomerount() {
		// AdminService as = new AdminService(session);
		this.i++;
		return i;
	}
	private int getCourseCount() {
		// AdminService as = new AdminService(session);
		this.i+=2;
		return i;
	}
	private int getOrderCount() {
		// AdminService as = new AdminService(session);
		this.i+=3;
		return i;
	}
	private int getIncomeCount() {
		// AdminService as = new AdminService(session);
		this.i+=4;
		return i;
	}
	private void getAccountInfo(HttpServletResponse response, AdminVO aVo) {	
		aVo.setAdminPassword("********");	
		writePojo2Json(response, aVo);
	}
	private void getCustomerList(HttpServletResponse response) {
		writePojo2Json(response, cs.getAllCustomer());
	}
	private void getCourseList(HttpServletResponse response){
		writePojo2Json(response, csc.getALL());
	}
}
