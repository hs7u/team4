package web.CourseTimeable.controller;

import static web.CommonUtil.projectUtil.getBean;
import static web.CommonUtil.projectUtil.json2Pojo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.CourseTimeable.service.CourseTimeableService;
import web.CourseTimeable.vo.CourseTimeableVO;

// @WebServlet("/CourseTimeable/insert")
public class TimeableInsertServlet extends HttpServlet{
    private CourseTimeableService ctsc;
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req,res);
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html; charset=UTF-8");
		PrintWriter out = res.getWriter();

        CourseTimeableVO ctvo = json2Pojo(req, CourseTimeableVO.class);
		
		
		System.out.println(ctvo.getCourseDate());
		System.out.println(ctvo.getSignUpDeadline());
		System.out.println(ctvo.getSignUpStartdate());
        if(ctsc.addCourseTimeable(ctvo) != null)
			out.println("success");
    }
    public void init() throws ServletException {
		ctsc = getBean(getServletContext(), CourseTimeableService.class);
	}
}
