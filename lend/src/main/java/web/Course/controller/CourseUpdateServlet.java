// package web.Course.controller;

// import static web.CommonUtil.projectUtil.getBean;
// import static web.CommonUtil.projectUtil.json2Pojo;

// import java.io.IOException;
// import java.io.PrintWriter;

// import javax.servlet.ServletException;
// import javax.servlet.annotation.WebServlet;
// import javax.servlet.http.HttpServlet;
// import javax.servlet.http.HttpServletRequest;
// import javax.servlet.http.HttpServletResponse;

// import web.Course.service.CourseService;
// import web.Course.vo.CourseVO;

// // @WebServlet("/Course/update")
// public class CourseUpdateServlet extends HttpServlet{
//     private CourseService csc;
//     protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
// 		doPost(req,res);
// 	}
// 	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
//         PrintWriter out = res.getWriter();
//         req.setCharacterEncoding("UTF-8");
// 		res.setContentType("text/html; charset=UTF-8");

//         CourseVO cVo = json2Pojo(req, CourseVO.class);
//         if(csc.update(cVo)){
//             out.println("success");
//             return;
//         }else{
//             out.println("fail");
//             return;
//         }
        
//     }
//     public void init() throws ServletException {
// 		csc = getBean(getServletContext(), CourseService.class);
// 	}
// }
