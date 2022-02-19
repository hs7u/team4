package web.Hibernate;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.WebApplicationContext;

@WebFilter(value = {"/*"})
public class springFilter implements Filter {
	private SessionFactory sessionFactory = null;
	public void destroy() {}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		try {
            this.sessionFactory.getCurrentSession().beginTransaction();
            chain.doFilter(request, response);
            this.sessionFactory.getCurrentSession().getTransaction().commit();        
            this.sessionFactory.getCurrentSession().close();        
        } catch (Exception e) {
            this.sessionFactory.getCurrentSession().getTransaction().rollback();
            e.printStackTrace();
        }
	}

	public void init(FilterConfig fConfig) throws ServletException {
		ServletContext appltcation = fConfig.getServletContext();
		ApplicationContext context = (ApplicationContext)appltcation.getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
		this.sessionFactory = (SessionFactory)context.getBean("sessionFactory");
	}

}
