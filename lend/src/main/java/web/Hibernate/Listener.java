//package web.Hibernate;
//
//import javax.servlet.ServletContextEvent;
//import javax.servlet.ServletContextListener;
//import javax.servlet.annotation.WebListener;
//
//import org.hibernate.SessionFactory;
//@WebListener
//public class Listener implements ServletContextListener{
//    public void contextInitialized(ServletContextEvent sce){
//        sce.getServletContext().setAttribute("sessionFactory", HibernateUtil.getSessionfactory());
//    }
//    public void contextDestroyed(ServletContextEvent sce){
//        if((SessionFactory)sce.getServletContext().getAttribute("sessionFactory") != null)
//            HibernateUtil.closeSessionFactory();
//    }
//}
