// package web.Product.controller;

// import java.io.BufferedReader;
// import java.io.IOException;
// import java.io.InputStream;
// import java.io.InputStreamReader;
// import java.io.PrintWriter;
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
// @WebServlet("/Product/updateProduct")
// @MultipartConfig
// public class updateProduct extends HttpServlet{
//     private ProductService psc;
//     public void init() throws ServletException{
//         ServletContext application = this.getServletContext();
//         ApplicationContext context = (ApplicationContext)application.getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
//         psc = (ProductService)context.getBean("productService");
//     }
//     public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
//         doPost(req,res);
//     }
//     public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
//         req.setCharacterEncoding("UTF-8");
//         res.setContentType("text/html; charset=UTF-8");
//         switch (req.getParameter("action")) {
//             case "update":
//                 update(req, res);       
//                 break;
//             case "delete":
//                 delete(req, res);
//                 break;
//             case "transform":
//                 transform(req, res);
//                 break;
//         }
         
//     }
//     private void transform(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
//         // ProductService psc = new ProductService((Session)req.getAttribute("session"));
//         Integer productId = Integer.valueOf(req.getParameter("productId"));
//         ProductVO vo = psc.getOneProduct(productId);
//         req.setAttribute("currentProduct", vo);
//         String url = "/Product/update_product_input_test.jsp";
//         req.getRequestDispatcher(url).forward(req, res);
//     }
//     private void update(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
//         PrintWriter out = res.getWriter();
//     	HashMap<String, Object> poc = new HashMap<String, Object>();
//         for(Part part : req.getParts()) {
// 			InputStream is = part.getInputStream();
// 			InputStreamReader isr = new InputStreamReader(is);
// 			BufferedReader br = new BufferedReader(isr); 		
// 			String val;
//             if(part.getName().equals("product_image")){
//                 byte[] buf = new byte[is.available()];
//                 is.read(buf);
//                 poc.put(part.getName(), buf);
//             }
// 			else{ 
//                 if ((val = br.readLine()) != null) {
//                     poc.put(part.getName(), val);
//                 }
// 			}
// 			br.close();
// 			isr.close();
// 			is.close();
//         }
//         // ProductService psc = new ProductService((Session)req.getAttribute("session"));
//         ProductVO check = psc.getOneProduct(Integer.valueOf((String)poc.get("product_id")));
//         ProductVO pVo = null;
//         if(check != null){
//             pVo = psc.updateProduct(
//                                 Integer.valueOf((String)poc.get("product_id")),
//                                 Integer.valueOf((String)poc.get("product_category_code")),
//                                 Integer.valueOf((String)poc.get("product_price")),
//                                 (String)poc.get("product_name"),
//                                 (byte[])poc.get("product_image"),
//                                 (String)poc.get("product_description"),
//                                 Integer.valueOf((String)poc.get("product_inventory")),
//                                 Byte.valueOf((String)poc.get("customization")),
//                                 Integer.valueOf((String)poc.get("customer_product_price")),
//                                 Byte.valueOf((String)poc.get("product_status"))
//                                 );
//         }
//         if (pVo != null) {
//             req.removeAttribute("currentProduct");
//             out.println(pVo.getProductName()+"\t\t"+"update success");
//         } else {
//             out.println("update fail");
//         }
//     }
//     private void delete(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
//         // ProductService psc = new ProductService((Session)req.getAttribute("session"));
//         Integer productId = Integer.valueOf(req.getParameter("productId"));
//         psc.deleteProduct(productId);
//     }
// }
