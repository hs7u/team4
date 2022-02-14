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
import com.google.gson.JsonObject;

import org.hibernate.Session;

import web.Admin.service.AdminService;


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
}
