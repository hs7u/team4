package web.Product.controller;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.WebApplicationContext;

import web.Product.service.ProductService;

@WebServlet("/disable/Image")
public class imageServlet extends HttpServlet{
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        doPost(req, res);
    }
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        ServletOutputStream out = res.getOutputStream();
        // ProductService psc = new ProductService((Session)req.getAttribute("session"));
        ServletContext application = this.getServletContext();
        ApplicationContext context = (ApplicationContext)application.getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
        ProductService psc = (ProductService)context.getBean("productService");
        ByteArrayInputStream bais = new ByteArrayInputStream(psc.getImage(Integer.valueOf(req.getParameter("img"))));
        BufferedInputStream in = new BufferedInputStream(bais);
        int len;
        byte[] buf = new byte[4 * 1024];
        while ((len = in.read(buf)) != -1) {
            out.write(buf, 0, len);
        }
        in.close();
        bais.close();
        out.close();
    }
}
