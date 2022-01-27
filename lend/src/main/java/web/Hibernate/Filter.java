package web.Hibernate;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import org.hibernate.SessionFactory;
@WebFilter(
    value = "/*"
)
public class Filter implements javax.servlet.Filter{
    public void init(FilterConfig filterConfig) throws ServletException{

    }
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
                        throws IOException, ServletException{
        SessionFactory sf = HibernateUtil.getSessionfactory();
        try {
            sf.getCurrentSession().beginTransaction();
            chain.doFilter(request, response);
            sf.getCurrentSession().getTransaction().commit();
        } catch (Exception e) {
            sf.getCurrentSession().getTransaction().rollback();
            e.printStackTrace();
        }
    }
    public void destroy(){
        
    }
}
