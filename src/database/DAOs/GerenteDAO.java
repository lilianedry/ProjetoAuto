/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.DAOs;

import database.HibernateUtil;
import java.util.List;
import model.entities.Gerente;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Enigma
 */
public class GerenteDAO {

    private SessionFactory connection;
    private Session session;

    public GerenteDAO() {
        connection = new HibernateUtil().getConnection();
        session = connection.openSession();    
    }

    public boolean add(Gerente gerente) {
        try {
            Transaction tx = session.beginTransaction();
            session.save(gerente);
            tx.commit();
            return true;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        } finally {
            closeConnection();
        }
    }

    public boolean update(Gerente gerente) {
        try {
            Transaction tx = session.beginTransaction();
            session.update(gerente);
            tx.commit();
            return true;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        } finally {
            closeConnection();
        }
    }

    public boolean delete(Gerente gerente) {
        try {
            Transaction tx = session.beginTransaction();
            session.delete(gerente);
            tx.commit();
            return true;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        } finally {
            closeConnection();
        }
    }
    
    public List<Gerente> all () {
        List<Gerente> gerentes = null;
        try {
            Transaction tx = session.beginTransaction();
            gerentes = session.createQuery("from Gerente where ativo = true").list();
            tx.commit();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            closeConnection();
        }
        return gerentes;
    }
    
    public void closeConnection (){
        session.close();
        connection.close();
    }
}
