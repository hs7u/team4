//package web.Hibernate;
//
//import org.hibernate.SessionFactory;
//import org.hibernate.boot.MetadataSources;
//import org.hibernate.boot.registry.StandardServiceRegistry;
//import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
//
//public class HibernateUtil {
//    private static final SessionFactory sessionFactory = buildSessionFactory();
//    
//	private static SessionFactory buildSessionFactory() {
//		StandardServiceRegistry registry =
//				new StandardServiceRegistryBuilder().configure().build();
//		try {
//			return new MetadataSources(registry).buildMetadata().buildSessionFactory();
//		} catch (Exception e) {
//			e.printStackTrace();
//			throw new ExceptionInInitializerError(e);
//		}
//	}
//
//	public static SessionFactory getSessionfactory() {
//		return sessionFactory;
//	}
//	
//	public static void closeSessionFactory() {
//		if(sessionFactory!=null) {
//			sessionFactory.close();
//		}
//	}
//}
