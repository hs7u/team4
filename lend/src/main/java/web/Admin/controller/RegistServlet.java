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
		
		AdminVO regist = gson.fromJson(reader, AdminVO.class);
        PrintWriter out = res.getWriter();
		HttpSession session = req.getSession();
		String account = (String)session.getAttribute("account");
	    if (account == null) {
            AdminService as = new AdminService((Session)req.getAttribute("session"));
            AdminVO aVo = as.getOneManager(regist.getAdminAccount(), regist.getAdminPassword());
            if(aVo == null){
                as.newManager(regist);
                out.print("Regist Success");
            }
        }else{
			res.sendRedirect("/Admin/AdminDashBoard_v2.html");
		}
    }
}
