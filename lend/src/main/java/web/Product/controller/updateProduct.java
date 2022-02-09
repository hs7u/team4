package web.Product.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.hibernate.Session;

import web.Product.service.ProductService;
import web.Product.vo.ProductVO;
@WebServlet("/Product/updateProduct")
@MultipartConfig
public class updateProduct extends HttpServlet{
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
        doPost(req,res);
    }
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
        req.setCharacterEncoding("UTF-8");
        res.setContentType("text/html; charset=UTF-8");
        System.out.print(req.getParameter("action"));
         if(req.getParameter("action") == null) {
             update(req, res);       
         }
         else{        
             transform(req, res);
         }
    }
    private void transform(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
        ProductService psc = new ProductService((Session)req.getAttribute("session"));
        System.out.print(req.getParameter("action"));
        req.setAttribute("currentProduct", psc.getOneProduct((String)req.getParameter("action")));
 
        String url = req.getContextPath()+"/Product/update_product_input.jsp";
        req.getRequestDispatcher(url).forward(req, res);
    }
    private void update(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
        PrintWriter out = res.getWriter();
        HashMap poc = new HashMap();
        for(Part part : req.getParts()) {
			InputStream is = part.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr); 		
			String val;
            if(part.getName().equals("product_image")){
                byte[] buf = new byte[is.available()];
                is.read(buf);
                poc.put(part.getName(), buf);
            }
			else{ 
                if ((val = br.readLine()) != null) {
                    poc.put(part.getName(), val);
                }
			}
			br.close();
			isr.close();
			is.close();
        }
        ProductService psc = new ProductService((Session)req.getAttribute("session"));
        ProductVO check = psc.getOneProduct((String)poc.get("product_name"));
        ProductVO pVo = null;
        if(check != null){
            pVo = psc.updateProduct(
                                Integer.valueOf((String)poc.get("product_id")),
                                Integer.valueOf((String)poc.get("product_category_code")),
                                Integer.valueOf((String)poc.get("product_price")),
                                (String)poc.get("product_name"),
                                (byte[])poc.get("product_image"),
                                (String)poc.get("product_description"),
                                Integer.valueOf((String)poc.get("product_inventory")),
                                Byte.valueOf((String)poc.get("customization")),
                                Integer.valueOf((String)poc.get("customer_product_price"))
                                );
        }
        if (pVo != null) {
            out.println(pVo.getProductName()+"\t\t"+"update success");
        } else {
            out.println("update fail");
        }
        out.close();    
    }
}