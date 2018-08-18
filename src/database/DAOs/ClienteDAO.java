/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.DAOs;

import database.HibernateUtil;
import model.entities.Cliente;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Enigma
 */
public class ClienteDAO {

    private Session session;
    private Transaction tx;

    public ClienteDAO() {
        session = HibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction();
    }

    public boolean add(Cliente cliente) {
        try {
            session.save(cliente);
            tx.commit();
            return true;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        } finally {
            session.close();
        }
    }

    public boolean update(Cliente cliente) {
        try {
            session.update(cliente);
            tx.commit();
            return true;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        } finally {
            session.close();
        }
    }

    public boolean delete(Cliente cliente) {
        try {
            session.delete(cliente);
            tx.commit();
            return true;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        } finally {
            session.close();
        }
    }
}
