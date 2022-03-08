//package web.Customer.controller;
//
//import static web.CommonUtil.projectUtil.getBean;
//import static web.CommonUtil.projectUtil.json2Pojo;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//import web.Customer.service.CustomerService;
//import web.Customer.vo.CustomerVO;
//
// @WebServlet("/Customer/login")
//public class LoginServlet extends HttpServlet {
//	
//	private CustomerService cs;
//	public void init() throws ServletException {
//		cs = getBean(getServletContext(), CustomerService.class);
//	}
//	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
//		doPost(req,res);
//	}
//	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
//		req.setCharacterEncoding("UTF-8");
//		res.setContentType("text/html; charset=UTF-8");
//		
//		CustomerVO login = json2Pojo(req, CustomerVO.class);
//		
//	    PrintWriter out = res.getWriter();
//		HttpSession session = req.getSession();
//		Integer account = (Integer)session.getAttribute("customerId");
//	    if (account == null) {
//	    	CustomerVO cVo = cs.getOneCustomer(login.getCustomerEmail(),login.getCustomerPassword());
//	    	if(cVo.getCustomerEmail() != null) {
//	    		account = cVo.getCustomerId();
//	    		session.setAttribute("customerId", account);
//	    		out.println(cVo.getCustomerName()+"Login Success");
//	    	} else {
//    			out.println("Username or Password incorrect");
//     		}
//    		
//	    }else{
//			req.getRequestDispatcher("/404.html").forward(req, res);
//		}
//	}
//
//}
