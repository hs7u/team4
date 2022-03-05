// package web.Product.controller;

// import java.io.BufferedReader;
// import java.io.IOException;

// import javax.servlet.ServletContext;
// import javax.servlet.ServletException;
// import javax.servlet.annotation.WebServlet;
// import javax.servlet.http.HttpServlet;
// import javax.servlet.http.HttpServletRequest;
// import javax.servlet.http.HttpServletResponse;

// import com.google.gson.Gson;

// import org.springframework.context.ApplicationContext;
// import org.springframework.web.context.WebApplicationContext;

// import web.Product.service.ProductService;
// import web.Product.vo.ProductVO;


// @WebServlet("/Product/JsonUpload")
// public class JsonProductServlet extends HttpServlet{
//     protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
// 		doPost(req,res);
// 	}
// 	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
//         req.setCharacterEncoding("UTF-8");
// 		res.setContentType("text/html; charset=UTF-8");
// //		PrintWriter out = res.getWriter();
// 		BufferedReader reader = req.getReader();
// 		Gson gson = new Gson();
// 		ProductVO vo = gson.fromJson(reader, ProductVO.class);
// 		// ProductService psc = new ProductService((Session)req.getAttribute("session"));
// 		ServletContext application = this.getServletContext();
//         ApplicationContext context = (ApplicationContext)application.getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
//         ProductService psc = (ProductService)context.getBean("productService");
// 		psc.addProduct( 
// 						vo.getProductCategoryCode(),
// 						vo.getCustomerProductPrice(),
// 						vo.getProductName(),
// 						vo.getProductImage(),
// 						vo.getProductDescription(),
// 						vo.getProductInventory(),
// 						vo.getCustomization(),
// 						vo.getCustomerProductPrice()
// 						);
// //		out.print(test);
//     }
// }




