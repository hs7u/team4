package web.Course.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.hibernate.Session;

import web.Course.service.CourseService;
import web.Course.vo.CourseVO;
import web.CourseTimeable.service.CourseTimeableService;

@WebServlet("/Course/addNewCourse")
@MultipartConfig
public class NewCourseServlet extends HttpServlet{
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        doPost(req, res);
    }
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        HashMap<String, Object> course = new HashMap<String, Object>();
        for(Part part : req.getParts()) {
			InputStream is = part.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr); 		
			String val;
            if(part.getName().equals("courseImage")){
                byte[] buf = new byte[is.available()];
                is.read(buf);
                course.put(part.getName(), buf);
            }
			else{ 
                if ((val = br.readLine()) != null) {
                    course.put(part.getName(), val);
                }
			}
			br.close();
			isr.close();
			is.close();
        }
//        Session session = (Session)req.getAttribute("session");
//        CourseService cs = new CourseService(session);
//        CourseTimeableService cts = new CourseTimeableService(session);
//        CourseVO cVo = null;
        System.out.println(course.get("coursePrice"));
//        cVo = cs.addCourse((String)course.get("courseName"),
//                           Integer.valueOf((String)course.get("coursePrice")),
//                           (byte[])course.get("courseImage"),
//                           Integer.valueOf((String)course.get("maxOfCourse")),
//                           Integer.valueOf((String)course.get("minOfCourse")),
//                           (String)course.get("courseLocation"),
//                           (String)course.get("courseDescribe"));
//        cts.addCourseTimeable(cVo.getCourseId(),
//                                    java.sql.Timestamp.valueOf((String)course.get("courseDate")),
//                                    java.sql.Timestamp.valueOf((String)course.get("signUpStartdate")),
//                                    java.sql.Timestamp.valueOf((String)course.get("signUpDeadline")));
    }
}
