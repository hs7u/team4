package web.Admin.controller;

import static web.CommonUtil.projectUtil.getBean;
import static web.CommonUtil.projectUtil.json2Pojo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web.Admin.service.AdminService;
import web.Admin.vo.AdminVO;

// @WebServlet("/Admin/regist")
public class RegistServlet extends HttpServlet{
    private AdminService as;
	public void init() throws ServletException {
		as = getBean(getServletContext(), AdminService.class);
	}
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req,res);
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html; charset=UTF-8");

		ArrayList<String> errorMsg = new ArrayList<>();
		PrintWriter out = res.getWriter();
		AdminVO regist = json2Pojo(req, AdminVO.class);
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
				// AdminService as = new AdminService((Session)req.getAttribute("session"));
				AdminVO check = as.getOneManager(regist);
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
