/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.DAOs;

import database.HibernateUtil;
import java.util.List;
import model.entities.relationships.GerenciaCarro;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;

/**
 *
 * @author Enigma
 */
public class GerenciaCarroDAO {

    private SessionFactory connection;
    private Session session;

    public GerenciaCarroDAO() {
        
        connection = new HibernateUtil().getConnection();
       
        session = connection.openSession();
        
    }    

    public boolean update(GerenciaCarro gerenciaCarro) {
        try {
            Transaction tx = session.beginTransaction();
            session.update(gerenciaCarro);
            tx.commit();
            return true;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        } finally {
            closeConnection();
        }
    }

    public GerenciaCarro selectOne(int id) {
        GerenciaCarro gerenciaCarro = null;
        try {
            gerenciaCarro = (GerenciaCarro) session.get(GerenciaCarro.class, id);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            session.close();
        }
        return gerenciaCarro;
    }

    public List<GerenciaCarro> all() {
        List<GerenciaCarro> gerenciaCarros = null;
        try {
            Transaction tx = session.beginTransaction();
            gerenciaCarros = session.createQuery("from GerenciaCarro where ativo = true").list();
            tx.commit();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            closeConnection();
        }
        return gerenciaCarros;
    }
    
    public List<GerenciaCarro> allf() {
        List<GerenciaCarro> gerenciaCarros = null;
        try {
            Transaction tx = session.beginTransaction();
            gerenciaCarros = session.createQuery("from GerenciaCarro").list();
            tx.commit();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            closeConnection();
        }
        return gerenciaCarros;
    }
    
    public List<GerenciaCarro> selectParam(GerenciaCarro gerenciaCarro) {
        List<GerenciaCarro> gerenciaCarros = null;
        try {
            Criteria crit = session.createCriteria(GerenciaCarro.class);
            crit.add(Example.create(gerenciaCarro));
            Transaction tx = session.beginTransaction();
            gerenciaCarros = crit.list();
            tx.commit();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            closeConnection();
        }
        return gerenciaCarros;
    }

    public void closeConnection() {
        session.close();
        connection.close();
    }
}
