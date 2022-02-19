// package web.Hibernate;

// import java.io.IOException;

// import javax.servlet.FilterChain;
// import javax.servlet.FilterConfig;
// import javax.servlet.ServletException;
// import javax.servlet.ServletRequest;
// import javax.servlet.ServletResponse;
// import javax.servlet.annotation.WebFilter;

// import org.hibernate.SessionFactory;
// @WebFilter(value = {"/*"})
// public class Filter implements javax.servlet.Filter{
//     private SessionFactory sessionFactory = null;
//     public void init(FilterConfig filterConfig) throws ServletException{}
	
//     public void doFilter(ServletRequest request, ServletResponse response,FilterChain chain)
//                 throws IOException, ServletException{
//         this.sessionFactory = (SessionFactory)request.getServletContext().getAttribute("sessionFactory");
//         request.setAttribute("session", this.sessionFactory.getCurrentSession());
//         try {
//             this.sessionFactory.getCurrentSession().beginTransaction();
//             chain.doFilter(request, response);
//             this.sessionFactory.getCurrentSession().getTransaction().commit();        
//             this.sessionFactory.getCurrentSession().close();        
//         } catch (Exception e) {
//             this.sessionFactory.getCurrentSession().getTransaction().rollback();
//             e.printStackTrace();
//         }
//     }
//     public void destroy(){}
// }
