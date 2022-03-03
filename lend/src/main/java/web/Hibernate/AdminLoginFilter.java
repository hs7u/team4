package web.Hibernate;

import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

@WebFilter(value = {"/Admin/AdminDashBoard_v2.html",
					"/Product/listAllProduct_test.jsp",
					"/Product/update_product_input_test.jsp",
					"/Admin/js/dashBoard.js",
					"/Admin/dashBoard"})
public class AdminLoginFilter implements javax.servlet.Filter{
    public void init(FilterConfig filterConfig) throws ServletException{}
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		// 【取得 session】
		HttpSession session = req.getSession();
		// 【從 session 判斷此user是否登入過】
		Object account = session.getAttribute("account");
		if (account == null) {
			res.sendRedirect(req.getContextPath() + "/Admin/login.html");
			return;
		} else {
			chain.doFilter(request, response);
		}
    }
    public void destroy(){}
}
