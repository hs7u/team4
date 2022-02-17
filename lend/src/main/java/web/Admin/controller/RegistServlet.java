package web.Admin.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

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

@WebServlet("/Admin/regist")
public class RegistServlet extends HttpServlet{
    
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
		AdminVO regist = gson.fromJson(reader, AdminVO.class);
		if (regist.getAdminAccount().trim().isEmpty()) {
			errorMsg.add("帳號不得為空");
		}
		if (regist.getAdminPassword().trim().isEmpty()) {
			errorMsg.add("密碼不得為空");
		}
		HttpSession session = req.getSession();
		String account = (String)session.getAttribute("account");
	    if (account == null) {
			if (errorMsg.size() <= 0){
				AdminService as = new AdminService((Session)req.getAttribute("session"));
				AdminVO check = as.getOneManager(regist.getAdminAccount(), regist.getAdminPassword());
				if(check == null){
					as.newManager(regist);
					out.print("Regist Success");
					return;
				} else {
					out.print("Regist Fail");
					return;
				}
			} else{
				for(String str : errorMsg)
					out.println(str);
				return;
			}
           
        }else{
			res.sendRedirect("/Admin/AdminDashBoard_v2.html");
		}
    }
}
