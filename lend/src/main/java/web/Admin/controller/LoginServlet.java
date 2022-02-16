package web.Admin.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import org.hibernate.Session;

import web.Admin.service.AdminService;
import web.Admin.vo.AdminVO;

@WebServlet("/Admin/login")
public class LoginServlet extends HttpServlet{
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req,res);
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html; charset=UTF-8");
		BufferedReader reader = req.getReader();
		Gson gson = new Gson();
		
		AdminVO login = gson.fromJson(reader, AdminVO.class);

        PrintWriter out = res.getWriter();
		HttpSession session = req.getSession();

		AdminService as = new AdminService((Session)req.getAttribute("session"));
		AdminVO aVo = as.getOneManager(login.getAdminAccount(), login.getAdminPassword());
		if(aVo.getAdminAccount() != null) {
			session.setAttribute("account", aVo.getAdminAccount());
			session.setAttribute("info", aVo);
			out.println("Login Success");
		} else {
			out.println("Account or Password incorrect");
		}
    }
}
