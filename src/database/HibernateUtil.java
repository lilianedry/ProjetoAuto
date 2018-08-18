/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.io.File;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author Enigma
 */
public class HibernateUtil {

    private static final SessionFactory sessionFactory;
    
    static {
        try {
            String path = System.getProperty("user.home");
            path += "\\hibernate.cfg.xml";
            File f = new File(path);
            Configuration con = new Configuration().configure(f);
            StandardServiceRegistryBuilder build = new StandardServiceRegistryBuilder().applySettings(con.getProperties());            sessionFactory = con.buildSessionFactory(build.build());
            // Create the SessionFactory from standard (hibernate.cfg.xml) 
            // config file.
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