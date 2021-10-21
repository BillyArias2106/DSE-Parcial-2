/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package sv.edu.udb.hibernate;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
/**
* Hibernate Utility class with a convenient method to get Session Factory
* object.
*/
public class HibernateUtil {
 private static final SessionFactory sessionFactory;
 private static final ServiceRegistry serviceRegistry;

 static {
 try {
 // Create the SessionFactory from standard (hibernate.cfg.xml) 
 // config file.
 Configuration configuration= new Configuration().configure();
 serviceRegistry =new
ServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
 sessionFactory = configuration.buildSessionFactory(serviceRegistry);
 } catch (Throwable ex) {
 // Log the exception.
 System.err.println("Initial SessionFactory creation failed." + ex);
 throw new ExceptionInInitializerError(ex);
 }
 }

 public static SessionFactory getSessionFactory() {
 return sessionFactory;
 }
}
