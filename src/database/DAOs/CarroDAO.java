/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.DAOs;

import database.HibernateUtil;
import java.util.List;
import model.entities.Carro;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Enigma
 */
public class CarroDAO {

    private SessionFactory connection;
    private Session session;

    public CarroDAO() {
        connection = new HibernateUtil().getConnection();
        session = connection.openSession();
    }

    public boolean add(Carro carro) {
        try {
            Transaction tx = session.beginTransaction();
            session.save(carro);
            tx.commit();
            return true;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        } finally {
            closeConnection();
        }
    }

    public boolean update(Carro carro) {
        try {
            Transaction tx = session.beginTransaction();
            session.update(carro);
            tx.commit();
            return true;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        } finally {
            closeConnection();
        }
    }

    public boolean delete(Carro carro) {
        try {
            Transaction tx = session.beginTransaction();
            session.delete(carro);
            tx.commit();
            return true;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        } finally {
            closeConnection();
        }
    }

    public Carro selectOne(int id) {
        Carro carro = null;
        try {
            carro = (Carro) session.get(Carro.class, id);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            session.close();
        }
        return carro;
    }

    public List<Carro> all() {
        List<Carro> carros = null;
        try {
            Transaction tx = session.beginTransaction();
            carros = session.createQuery("from Carro where ativo = true").list();
            tx.commit();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            closeConnection();
        }
        return carros;
    }
    
    public List<Carro> allf() {
        List<Carro> carros = null;
        try {
            Transaction tx = session.beginTransaction();
            carros = session.createQuery("from Carro").list();
            tx.commit();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            closeConnection();
        }
        return carros;
    }
    
    public List<Carro> selectModelo(String modelo) {
        List<Carro> carros = null;
        try {
            Transaction tx = session.beginTransaction();
            Query q = session.createQuery("from Usuario where modelo = :modelo");
            q.setString("modelo", modelo);
            carros = q.list();
            tx.commit();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            closeConnection();
        }
        return carros;
    }

    public void closeConnection() {
        session.close();
        connection.close();
    }
}
