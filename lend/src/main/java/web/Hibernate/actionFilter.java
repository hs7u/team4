package web.Hibernate;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(value = {"/checkout.html",
					"/shopping-cart.jsp",
					"/my-account.html",
					"/course-checkout.html",
					"/Customer/info/update",
					"/Customer/Order/checkout",
					"/Course/regist"})
public class actionFilter implements javax.servlet.Filter{
    public void init(FilterConfig filterConfig) throws ServletException{}
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		// 【取得 session】
		HttpSession session = req.getSession();
		// 【從 session 判斷此user是否登入過】
		if (session.getAttribute("customerAccount") == null) {
			res.sendRedirect(req.getContextPath() + "/login-register.html");
			return;
		} else {
			chain.doFilter(request, response);
		}
    }
    public void destroy(){}
}
