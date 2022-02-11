package web.Course.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;



@MultipartConfig
public class CourseServlet extends HttpServlet {
	
	public void processRequest(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException {
    	res.setContentType("text/html;charset=UTF-8");
    	
    	 //對Post中文參數進行解碼
    	
    	req.setCharacterEncoding("UTF8");
    	
    	
    	Map<String, String> errorMsgs = new LinkedHashMap<String, String>();
		req.setAttribute("errorMsgs", errorMsgs);
    	//取得Ajax傳入的參數
    	
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
    	
    	Integer coursPrice = null;
		try{
			coursPrice = Integer.valueOf(req.getParameter("coursePrice").trim());
		} catch (NumberFormatException e) {
			errorMsgs.put("coursPrice", "課程價格請填數字");
		}
		
		Part part = req.getPart("courseImage");
		if(part == null) {
			errorMsgs.put("courseImage", "請選擇要上傳的商品圖片");
		}
		
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
    	
		System.out.println(courseName);
    	
		if (!errorMsgs.isEmpty()) {
			    String url = "/Course/addCourse.jsp";
				RequestDispatcher failureView = req.getRequestDispatcher(url);
				failureView.forward(req, res);
				return;
			}
    	
    	
//    	String[] arrayUserInterest = req.getParameterValues("userInterest");
    	
    	//建構要回傳JSON物件
    	
//    	HashMap userInfoMap = new HashMap();
//    	
//    	userInfoMap.put("userName",userName);
//    	
//    	ArrayList userInterestList = new ArrayList();
//    	userInterestList.addAll(Arrays.asList(arrayUserInterest));
//    	
//    	userInfoMap.put("userInterest",userInterestList);
//    	
//    	JSONObject responseJSONObject = new JSONObject(userInfoMap);
//    	
//    	PrintWriter out = res.getWriter();
//    	out.println(responseJSONObject);
    	
    }

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		processRequest(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		processRequest(req, res);

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
			// } catch (Exception e) {
			// 	errorMsgs.put("Exception", e.getMessage());
			// 	RequestDispatcher failureView = req.getRequestDispatcher("/404.html");
			// 	failureView.forward(req, res);
			// }
		// }
	}
}
