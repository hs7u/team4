package web.Course.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static web.CommonUtil.projectUtil.getBean;
import static web.CommonUtil.projectUtil.json2Pojo;
import static web.CommonUtil.projectUtil.writePojo2Json;

import com.google.gson.JsonObject;

import org.springframework.util.SystemPropertyUtils;

import web.Course.service.CourseService;


@WebServlet("/Course/courseDetails")
public class courseDetailsServlet extends HttpServlet {

	private CourseService csc;

    Integer courseId = null;
	public void init() throws ServletException {
		csc = getBean(getServletContext(), CourseService.class);
	}

    

    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException{
        doPost(req, res);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException{
        req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html; charset=UTF-8");
		PrintWriter out = res.getWriter();
		// JsonObject jsonObject = json2Pojo(req, JsonObject.class);

        // System.out.println(req.getParameter("id").trim());

        

        // Integer courseId = null;
			try {
				courseId = Integer.valueOf(req.getParameter("id").trim());
			} catch (NumberFormatException e) {
				System.out.println("請確認ID型別");
			}
            getOne(res);
            
    }

    private void getOne(HttpServletResponse response){
		writePojo2Json(response, csc.getOneCourse(courseId));
	}
}
