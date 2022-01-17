package web.Product.controller;

import java.io.*;
import java.net.http.HttpRequest;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import web.Product.service.ProductService;
import web.Product.vo.ProductVO;

@WebServlet("/addNewProduct")
@MultipartConfig
public class newProduct extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
        doPost(req,res);
    }
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
        req.setCharacterEncoding("UTF-8");
        res.setContentType("text/html; charset=UTF-8");
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
        ProductService psc = new ProductService();
        ProductVO pVo = null;
        pVo = psc.addProduct((Integer)poc.get("product_category_code"),
                            (Integer)poc.get("product_price"),
                            (String)poc.get("product_name"),
                            (byte[])poc.get("product_image"),
                            (String)poc.get("product_description"),
                            (Integer)poc.get("product_inventory"),
                            (Byte)poc.get("customization"),
                            (Integer)poc.get("customer_product_price"));
        if (pVo != null) {
            out.println(pVo.getProductName()+"\t\t"+"upload success");
        } else {
            out.println("Upload fail");
        }
        out.close();
    }
}
