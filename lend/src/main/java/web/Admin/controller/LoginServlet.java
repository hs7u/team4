package web.Admin.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.WebApplicationContext;

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
		ArrayList<String> errorMsg = new ArrayList<>();
		PrintWriter out = res.getWriter();
		AdminVO login = gson.fromJson(reader, AdminVO.class);
		if (login.getAdminAccount().trim().isEmpty()) {
			errorMsg.add("帳號不得為空");
		}
		if (login.getAdminPassword().trim().isEmpty()) {
			errorMsg.add("密碼不得為空");
		}
		HttpSession session = req.getSession();
		String account = (String)session.getAttribute("account");
		
		if (account == null) {
			if (errorMsg.size() <= 0) {
				// AdminService as = new AdminService((Session)req.getAttribute("session"));
				ServletContext application = req.getServletContext();
				ApplicationContext context = (ApplicationContext)application.getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
				AdminService as = (AdminService)context.getBean("adminService");
				AdminVO check = as.getOneManager(login.getAdminAccount(), login.getAdminPassword());
				if(check.getAdminAccount() != null) {
					session.setAttribute("account", check.getAdminAccount());
					session.setAttribute("info", check);
					out.println("Login Success");
					return;
				} else {
					out.println("Account or Password incorrect");
					return;
				}
			} else {
				for(String str : errorMsg)
					out.println(str);
				return;
			}
			
		}else{
			out.println("Already login");
			return;
		}
    }
}
