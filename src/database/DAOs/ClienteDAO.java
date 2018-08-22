/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.DAOs;

import database.HibernateUtil;
import java.util.List;
import model.entities.Cliente;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Enigma
 */
public class ClienteDAO {

    private SessionFactory connection;
    private Session session;

    public ClienteDAO() {
        connection = new HibernateUtil().getConnection();
        session = connection.openSession(); 
    }

    public boolean add(Cliente cliente) {
        try {
            Transaction tx = session.beginTransaction();
            session.save(cliente);
            tx.commit();
            return true;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        } finally {
            closeConnection();
        }
    }

    public boolean update(Cliente cliente) {
        try {
            Transaction tx = session.beginTransaction();
            session.update(cliente);
            tx.commit();
            return true;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        } finally {
            closeConnection();
        }
    }

    public boolean delete(Cliente cliente) {
        try {
            Transaction tx = session.beginTransaction();
            session.delete(cliente);
            tx.commit();
            return true;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        } finally {
            closeConnection();
        }
    }
    
    public List<Cliente> all (Cliente cliente) {
        List<Cliente> clientes = null;
        try {
            Transaction tx = session.beginTransaction();
            clientes = session.createQuery("from clientes").list();
            tx.commit();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            closeConnection();
        }
        return clientes;
    }
    
    public void closeConnection (){
        session.close();
        connection.close();
    }
}
