package web.Customer.controller;

import javax.servlet.*;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.WebApplicationContext;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;

import web.Customer.service.CustomerService;
import web.Customer.vo.CustomerVO;

// @WebServlet("/Customer/regist")
// @MultipartConfig
public class RegistServlet extends HttpServlet{
	 protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
         doPost(req,res);
     }
     protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
        req.setCharacterEncoding("UTF-8");
        res.setContentType("text/html; charset=UTF-8");
        PrintWriter out = res.getWriter();
        HashMap<String,String> regist = new HashMap<String,String>();            

        for(Part part : req.getParts()) {
			InputStream is = part.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr); 		
			String val;
			if ((val = br.readLine()) != null) {
                regist.put(part.getName(), val);
			}
			br.close();
			isr.close();
			is.close();
        }
        // CustomerService cs = new CustomerService((Session)req.getAttribute("session"));
        // ServletContext application = this.getServletContext();
        // ApplicationContext context = (ApplicationContext)application.getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
        // CustomerService cs = (CustomerService) context.getBean("customerService");    
        // CustomerVO check = cs.getOneCustomer(regist.get("email"), regist.get("password"));
        // CustomerVO cVo = null;
        // if(check == null) {
            // cVo = cs.addCustomer(regist.get("cname"),
            //                     regist.get("email"),
            //                     regist.get("password"),
            //                     regist.get("Phone"),
            //                     java.sql.Date.valueOf(regist.get("birth")),
            //                     regist.get("gender"),
            //                     regist.get("address"));
        // }
        // if (cVo != null) {
        //     out.println(cVo.getCustomerName()+"("+cVo.getCustomerId()+")"+"\t\t"+"Regist Success");
        // } else {
        //     out.println("Regist fail or Account already exists");
        // }
        out.close();
    }   
}