// package web.Product.controller;

// import java.io.*;
// import java.util.ArrayList;
// import java.util.HashMap;

// import javax.servlet.ServletContext;
// import javax.servlet.ServletException;
// import javax.servlet.annotation.MultipartConfig;
// import javax.servlet.annotation.WebServlet;
// import javax.servlet.http.HttpServlet;
// import javax.servlet.http.HttpServletRequest;
// import javax.servlet.http.HttpServletResponse;
// import javax.servlet.http.Part;

// import org.springframework.context.ApplicationContext;
// import org.springframework.web.context.WebApplicationContext;

// import web.Product.service.ProductService;
// import web.Product.vo.ProductVO;

// @WebServlet("/Product/addNewProduct")
// @MultipartConfig
// public class newProduct extends HttpServlet {
//     public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
//         doPost(req,res);
//     }
//     public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
//         req.setCharacterEncoding("UTF-8");
//         res.setContentType("text/html; charset=UTF-8");
//         PrintWriter out = res.getWriter();
//         HashMap<String, Object> poc = new HashMap<String, Object>();
//         ArrayList<String> errorMsg = new ArrayList<>();
//         for(Part part : req.getParts()) {
// 			InputStream is = part.getInputStream();
// 			InputStreamReader isr = new InputStreamReader(is);
// 			BufferedReader br = new BufferedReader(isr); 		
// 			String val;
//             if(part.getName().equals("product_image")){
//                 if(is.available() <= 0){
//                     errorMsg.add("商品圖片  請勿空白");
//                 }else{
//                     byte[] buf = new byte[is.available()];
//                     is.read(buf);
//                     poc.put(part.getName(), buf);
//                 }
//             }
// 			else{ 
//                 if ((val = br.readLine()) != null) {
//                     poc.put(part.getName(), val);
//                     String checkNo = addErrorNo(part.getName(), val);
//                     if(checkNo != "" && checkNo != null) {
//                         errorMsg.add(checkNo);
//                     }
//                 } else {
//                 	 String checkNu = addErrorNu(part.getName(), val);
//                 	 if(checkNu != "" && checkNu != null) {
//                          errorMsg.add(checkNu);
//                      }
//                 }
// 			}
// 			br.close();
// 			isr.close();
// 			is.close();
//         }
        
//         // ProductService psc = new ProductService((Session)req.getAttribute("session"));
//         ServletContext application = this.getServletContext();
//         ApplicationContext context = (ApplicationContext)application.getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
//         ProductService psc = (ProductService)context.getBean("productService");
//         ProductVO pVo = null;
//         if(errorMsg.size() <= 0){  
//             pVo = psc.addProduct( 
//                                 Integer.valueOf((String)poc.get("product_category_code")),
//                                 Integer.valueOf((String)poc.get("product_price")),
//                                 (String)poc.get("product_name"),
//                                 (byte[])poc.get("product_image"),
//                                 (String)poc.get("product_description"),
//                                 Integer.valueOf((String)poc.get("product_inventory")),
//                                 Byte.valueOf((String)poc.get("customization")),
//                                 Integer.valueOf((String)poc.get("customer_product_price"))
//                                 );
        
//         }
//         if (pVo != null) {
//             out.println(pVo.getProductName()+"\t\t"+"上傳成功");
//         } else {
//             for (String erStr : errorMsg) {
//                 out.println(erStr);
//             }
//         }
//         out.close();
//     }
//     public String addErrorNo(String name,String val){
//         String msg = null;
//         String hint =  "  必須是數字";
//         switch (name) {
//             case "product_price":
//             	 if(!isInteger(val)){
//                      msg = "商品價格 " + hint;
//                  }
//                  break;
//             case "product_inventory":
//             	 if(!isInteger(val)){
//                      msg = "商品庫存" + hint;
//                  }
//                  break;
//             case "customer_product_price":
//                 if(!isInteger(val)){
//                     msg = "客製產品價格" + hint;
//                 }
//                 break;
            
//             default:
//             	return null;
//         }
//         return msg;
//     }
//     public String addErrorNu(String name,String val){
//     	String msg = null;
//     	String hint = "  請勿空白";
// 	    switch (name) {
//           case "product_description":
//         	  if(val == null){
//         		  msg = "商品描述"+hint;;
//         	  }
//         	  break;
//           case "product_name":
//         	  if(val == null){
//         		  msg = "商品名稱"+hint;
//         	  }
//         	  break;
//           case "product_price":
//         	  if(val == null){
//                   msg = "商品價格 " + hint;
//               }
//               break;
//          case "product_inventory":
//         	 if(val == null){
//                   msg = "商品庫存" + hint;
//               }
//               break;
//          case "customer_product_price":
//         	 if(val == null){
//                  msg = "客製產品價格" + hint;
//              }
//              break;
//       	}
//     	return msg;
//     }
    
//     private boolean isInteger(String string) {
//         try {
//             Integer.valueOf(string);
//             return true;
//         } catch (NumberFormatException e) {
//             return false;
//         }
//     }
// }
