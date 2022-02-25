// package web.Course.controller;
// import java.io.*;

// import javax.servlet.ServletException;
// import javax.servlet.annotation.MultipartConfig;
// import javax.servlet.annotation.WebServlet;
// import javax.servlet.http.HttpServletRequest;
// import javax.servlet.http.HttpServletResponse;

// import org.hibernate.Session;

// import web.Course.service.CourseService;
// import web.Course.vo.CourseVO;

// @WebServlet("/Course/updateCourse")
// @MultipartConfig
// public class updateCourseServlet {
//     public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException{
//         doPost(req, res);
//     }

//     public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException{
//         req.setCharacterEncoding("UTF-8");
//         res.setContentType("text/html, charset=UTF-8");
//     }

//     public void transform(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException{
//         CourseService csc = new CourseService((Session)req.getAttribute("session"));
//         Integer courseId = Integer.valueOf(req.getParameter("courseId"));
//         CourseVO cvo = csc.getOneCourse(courseId);
//         req.setAttribute("currentCourse", cvo);
//         String url = "/Course/updateCourse.jsp";
//         req.getRequestDispatcher(url).forward(req, res);
//     }

//     public void update(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException{
// 		// PrintWriter out = res.getWriter();
        
//     }

//     public void deleteCourse(HttpServletRequest req, HttpServletResponse res){
//         CourseService csc = new CourseService((Session)req.getAttribute("session"));
//         Integer courseId = Integer.valueOf(req.getParameter("courseId"));
//         csc.delete(courseId);
//     }
// }
