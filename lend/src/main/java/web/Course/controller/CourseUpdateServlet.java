package web.Course.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.WebApplicationContext;

import web.Course.service.CourseService;
import web.Course.vo.CourseVO;

@WebServlet("/Course/update")
public class CourseUpdateServlet extends HttpServlet{
    private CourseService csc;
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req,res);
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        PrintWriter out = res.getWriter();
        req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html; charset=UTF-8");
        BufferedReader reader = req.getReader();
		Gson gson = new Gson();
        CourseVO cVo = gson.fromJson(reader, CourseVO.class);
        if(csc.update(cVo)){
            out.println("success");
            return;
        }else{
            out.println("fail");
            return;
        }
        
    }
    public void init() throws ServletException {
		ServletContext application = this.getServletContext();
		ApplicationContext context = (ApplicationContext)application.getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
		csc = (CourseService) context.getBean("courseService");		
	}
}
