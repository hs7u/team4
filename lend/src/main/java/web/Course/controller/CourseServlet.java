package web.Course.controller;

import static web.CommonUtil.projectUtil.json2Pojo;

import java.io.*;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.WebApplicationContext;

import web.Course.service.CourseService;
import web.Course.vo.CourseVO;
import web.Product.vo.ProductVO;

@WebServlet("/addCourse")
@MultipartConfig
public class CourseServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void processRequest(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html;charset=UTF-8");

		/***************************
		 * 0.對Post中文參數進行解碼
		 ***************************************/

		req.setCharacterEncoding("UTF-8");


		PrintWriter out = res.getWriter();

		ProductVO jsonBean =  json2Pojo(req, ProductVO.class);


		// String action = req.getParameter("action");
		// if ("insert".equals(action)) { // 新增

			Map<String, String> errorMsgs = new LinkedHashMap<String, String>();
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.開始新增資料 ***************************************/

			String courseName = req.getParameter("courseName");
			String courseNameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{4,10}$";
			if (courseName == null || courseName.trim().length() == 0) {
				errorMsgs.put("courseName", "課程名稱: 請勿空白");
			} else if (!courseName.trim().matches(courseNameReg)) { // 以下練習正則(規)表示式(regular-expression)
				errorMsgs.put("courseName", "課程名稱: 只能是中、英文字母、數字和_ , 且長度必需在4到10之間");
			}

			String courseDescribe = req.getParameter("courseDescription").trim();
			if (courseDescribe == null || courseDescribe.trim().length() == 0) {
				errorMsgs.put("courseDescription", "課程描述: 請勿空白");
			}

			Integer coursePrice = null;
			try {
				coursePrice = Integer.valueOf(req.getParameter("coursePrice").trim());
			} catch (NumberFormatException e) {
				errorMsgs.put("coursPrice", "課程價格: 請填數字");
			}

			Part part = req.getPart("courseImage");
			byte[] imgData = null;
			try (InputStream is = part.getInputStream();
					InputStreamReader isr = new InputStreamReader(is);
					BufferedReader br = new BufferedReader(isr)) {
				if (is.available() <= 0) {
					errorMsgs.put("courseImage", "請上傳課程圖片");
				} else {
					imgData = new byte[is.available()];
					is.read(imgData);
				}
			}

			Integer minOfCourse = null;
			try {
				minOfCourse = Integer.valueOf(req.getParameter("minOfCourse").trim());
			} catch (NumberFormatException e) {
				errorMsgs.put("minOfCourse", "開課人數: 請填數字");
			}

			Integer maxOfCourse = null;
			try {
				maxOfCourse = Integer.valueOf(req.getParameter("maxOfCourse").trim());
			} catch (NumberFormatException e) {
				errorMsgs.put("maxOfCourse", "額滿人數: 請填數字");
			}

			String courseLocation = req.getParameter("courseLocation").trim();
			if (courseLocation == null || courseLocation.trim().length() == 0) {
				errorMsgs.put("courseLocation", "上課地點: 請勿空白");
			}


			/*************************** 2.開始新增資料 ***************************************/

			if (!errorMsgs.isEmpty()) {
//				String url = "/Course/addCourse.jsp";
//				RequestDispatcher failureView = req.getRequestDispatcher(url);
//				failureView.forward(req, res);
				Iterator<String> set = errorMsgs.keySet().iterator();
				while(set.hasNext()) {
	                out.println(errorMsgs.get(set.next()));
	            }
				return;
			} else {
				// CourseService csc = new CourseService((Session) req.getAttribute("session"));
				ServletContext application = req.getServletContext();
				ApplicationContext context = (ApplicationContext)application.getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
				CourseService csc = (CourseService) context.getBean("courseService");

				CourseVO cvo = new CourseVO();
				cvo.setCourseName(courseName);
				cvo.setCoursePrice(coursePrice);
				cvo.setCourseImage(imgData);
				cvo.setMaxOfCourse(maxOfCourse);
				cvo.setMinOfCourse(minOfCourse);
				cvo.setCourseLocation(courseLocation);
				cvo.setCourseDescribe(courseDescribe);
				CourseVO check = csc.getOneCourse(cvo.getCourseId());
				if(check == null) {
					out.println(csc.addCourse(cvo));
				}
			}
		

		out.close();
		
		/*************************** 3.新增完成,準備轉交(Send the Success view) ***********/
		// String url = "/404.html";
		// RequestDispatcher successView = req.getRequestDispatcher(url); //
		// 新增成功後轉交listAllEmp.jsp
		// successView.forward(req, res);


	}

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		processRequest(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		processRequest(req, res);
		
		/*************************** 其他可能的錯誤處理 **********************************/
		// } catch (Exception e) {
		// errorMsgs.put("Exception", e.getMessage());
		// RequestDispatcher failureView = req.getRequestDispatcher("/404.html");
		// failureView.forward(req, res);
		// }
		// }
	}
}

