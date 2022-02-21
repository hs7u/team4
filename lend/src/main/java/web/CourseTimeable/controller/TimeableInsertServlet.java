package web.CourseTimeable.controller;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.WebApplicationContext;

import web.CourseTimeable.service.CourseTimeableService;
import web.CourseTimeable.vo.CourseTimeableVO;

@WebServlet("/CourseTimeable/insert")
public class TimeableInsertServlet extends HttpServlet{
    private CourseTimeableService ctsc;
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req,res);
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html; charset=UTF-8");
        BufferedReader reader = req.getReader();
		Gson gson = new Gson();
        CourseTimeableVO ctvo = gson.fromJson(reader, CourseTimeableVO.class);
        ctsc.addCourseTimeable(ctvo);
    }
    public void init() throws ServletException {
		ServletContext application = this.getServletContext();
		ApplicationContext context = (ApplicationContext)application.getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
		ctsc = (CourseTimeableService)context.getBean("courseTimeableService");
	}
}
