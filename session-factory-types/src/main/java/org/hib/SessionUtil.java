package org.hib;

import java.util.Properties;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class SessionUtil {
    // from xml configuration file 
    public static Session getSessionFromXmlConfig(){
       return  new Configuration().configure().buildSessionFactory().openSession();
    }

    // from java config without xml

    public static Session getSessionFromJavaConfig(){
        // Hibernate 5.4 SessionFactory example without XML
        Properties settings = new Properties();
        settings.put("connection.driver_class", "com.mysql.cj.jdbc.Driver");
        settings.put("dialect", "org.hibernate.dialect.MySQLDialect");
        settings.put("hibernate.connection.url", 
            "jdbc:mysql://localhost:3306/hibdb");
        settings.put("hibernate.connection.username", "root");
        settings.put("hibernate.connection.password", "welcome1");
        settings.put("hibernate.current_session_context_class", "thread");
        settings.put("hibernate.show_sql", "true");
        settings.put("hibernate.format_sql", "true");

        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                                            .applySettings(settings).build();

        MetadataSources metadataSources = new MetadataSources(serviceRegistry);
        metadataSources.addAnnotatedClass(Student.class);
        Metadata metadata = metadataSources.buildMetadata();

        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
        Session session = sessionFactory.getCurrentSession();
        return session;
    }
    
}
