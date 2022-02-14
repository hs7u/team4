package web.Product.controller;

import java.io.*;
import java.util.ArrayList;
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

@WebServlet("/Product/addNewProduct")
@MultipartConfig
public class newProduct extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
        doPost(req,res);
    }
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
        req.setCharacterEncoding("UTF-8");
        res.setContentType("text/html; charset=UTF-8");
        PrintWriter out = res.getWriter();
        HashMap<String, Object> poc = new HashMap<String, Object>();
        ArrayList<String> errorMsg = new ArrayList<>();
        for(Part part : req.getParts()) {
			InputStream is = part.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr); 		
			String val;
            if(part.getName().equals("product_image")){
                if(is.available() <= 0){
                    errorMsg.add(part.getName()+" can't empty");
                }else{
                    byte[] buf = new byte[is.available()];
                    is.read(buf);
                    poc.put(part.getName(), buf);
                }
            }
			else{ 
                if ((val = br.readLine()) != null) {
                    poc.put(part.getName(), val);
                    String check = addError(part.getName(), val);
                    if(check != "" && check != null) {
                        errorMsg.add(check);
                    }
                } else {
                    errorMsg.add(part.getName()+" can't empty");
                }
			}
			br.close();
			isr.close();
			is.close();
        }
        
        ProductService psc = new ProductService((Session)req.getAttribute("session"));
        ProductVO pVo = null;
        if(errorMsg.size() <= 0){  
            pVo = psc.addProduct( 
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
            out.println(pVo.getProductName()+"\t\t"+"upload success");
        } else {
            for (String erStr : errorMsg) {
                out.println(erStr);
            }
        }
        out.close();
    }
    public String addError(String name,String val){
        String msg = null;
        switch (name) {
            case "product_category_code":
            case "product_price":
            case "product_inventory":
            case "customer_product_price":
                if(!isInteger(val)){
                    msg = name + " must be number";
                }
                break;
            default:
            	return null;
        }
        return msg;
    }
    private boolean isInteger(String string) {
        try {
            Integer.valueOf(string);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
