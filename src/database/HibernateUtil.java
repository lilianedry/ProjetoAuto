/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.io.File;
import org.hibernate.HibernateException;
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

    public SessionFactory getConnection () {
        try {
            Configuration con = new Configuration().configure();
            StandardServiceRegistryBuilder build = new StandardServiceRegistryBuilder().applySettings(con.getProperties());
            return con.buildSessionFactory(build.build());
        } catch (HibernateException ex) {
            // Log the exception. 
            System.out.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
}
