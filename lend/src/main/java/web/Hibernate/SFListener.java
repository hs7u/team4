package web.Hibernate;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class SFListener implements ServletContextListener{
    @Override
    public void contextInitialized(ServletContextEvent sce){
        HibernateUtil.getSessionfactory();
    }
    @Override
    public void contextDestroyed(ServletContextEvent sce){
        HibernateUtil.closeSessionFactory();
    }
}