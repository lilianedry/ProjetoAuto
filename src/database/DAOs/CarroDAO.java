/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.DAOs;

import database.HibernateUtil;
import model.entities.Carro;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Enigma
 */
public class CarroDAO {

    private Session session;
    private Transaction tx;

    public CarroDAO() {
        session = HibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction();
    }

    public boolean add(Carro carro) {
        try {
            session.save(carro);
            tx.commit();
            return true;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        } finally {
            session.close();
        }
    }

    public boolean update(Carro carro) {
        try {
            session.update(carro);
            tx.commit();
            return true;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        } finally {
            session.close();
        }
    }

    public boolean delete(Carro carro) {
        try {
            session.delete(carro);
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
