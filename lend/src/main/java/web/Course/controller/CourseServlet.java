package web.Course.controller;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import web.Hibernate.HibernateUtil;
import web.Course.service.CourseService;

public class CourseServlet extends HttpServlet {
	
//	private SessionFactory sessionFacrtory;
//	
//	public CourseServlet(SessionFactory sessionFacrtory) {
//		this.sessionFacrtory = sessionFacrtory;
//	}
//	public Session getSession() {
//		return sessionFacrtory.getCurrentSession();
//	}

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		req.setCharacterEncoding("UTF8");
		String action = req.getParameter("action");

		if ("insert".equals(action)) { // 來自addCourse.jsp的請求

			Map<String, String> errorMsgs = new LinkedHashMap<String, String>();
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				/*********************** 1.接收請求參數 - 輸入格式的錯誤處理 *************************/
				String courseName = req.getParameter("courseName");
				String courseNameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{4,10}$";
				if (courseName == null || courseName.trim().length() == 0) {
					errorMsgs.put("courseName", "課程名稱: 請勿空白");
				} else if (!courseName.trim().matches(courseNameReg)) { // 以下練習正則(規)表示式(regular-expression)
					errorMsgs.put("courseName", "課程名稱: 只能是中、英文字母、數字和_ , 且長度必需在4到10之間");
				}

				String courseDescription = req.getParameter("courseDescription").trim();
				if (courseDescription == null || courseDescription.trim().length() == 0) {
					errorMsgs.put("courseDescription", "課程描述請勿空白");
				}

//				java.sql.Date hiredate = null;
//				try {
//					hiredate = java.sql.Date.valueOf(req.getParameter("hiredate").trim());
//				} catch (IllegalArgumentException e) {
//					errorMsgs.put("hiredate", "請輸入日期");
//				}
				
				Integer coursPrice = null;
				try{
					coursPrice = Integer.valueOf(req.getParameter("coursePrice").trim());
				} catch (NumberFormatException e) {
					errorMsgs.put("coursPrice", "課程價格請填數字");
				}
				
				
				Byte courseImage[] = null;
//				try {
//					req.getInputStream();
//					courseImage[] = Byte.valueOf(req.getParameter("courseImage"));
//				} catch(IOException e) {
//					
//				}
				
				Integer minOfCourse = null;
				try{
					minOfCourse = Integer.valueOf(req.getParameter("minOfCourse").trim());
				} catch (NumberFormatException e) {
					errorMsgs.put("minOfCourse", "開課人數請填數字");
				}
				
				Integer maxOfCourse = null;
				try{
					maxOfCourse = Integer.valueOf(req.getParameter("maxOfCourse").trim());
				} catch (NumberFormatException e) {
					errorMsgs.put("maxOfCourse", "額滿人數請填數字");
				}
				
				String courseLocation = req.getParameter("courseLocation").trim();
				if (courseLocation == null || courseLocation.trim().length() == 0) {
					errorMsgs.put("courseLocation", "上課地點請勿空白");
				}
				

//				Integer deptno = new Integer(req.getParameter("deptno").trim());

				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/Course/addCourse.jsp");
					failureView.forward(req, res);
					return;
				}

				/*************************** 2.開始新增資料 ***************************************/
//				SessionFactory sessionFactory = HibernateUtil.getSessionfactory();
//				Session session = sessionFactory.getCurrentSession();
//				Transaction transaction = session.beginTransaction();
				
//				CourseService courseSvc = new CourseService(session);
//				empSvc.addEmp(ename, job, hiredate, sal, comm, deptno);

				/*************************** 3.新增完成,準備轉交(Send the Success view) ***********/
//				String url = "/404.html";
//				RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllEmp.jsp
//				successView.forward(req, res);

				/*************************** 其他可能的錯誤處理 **********************************/
			} catch (Exception e) {
				errorMsgs.put("Exception", e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher("/404.html");
				failureView.forward(req, res);
			}
		}
	}
}
