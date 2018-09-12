/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.DAOs;

import database.HibernateUtil;
import java.text.ParseException;
import java.time.Year;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import model.entities.relationships.SolicitaCarro;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Enigma
 */
public class SolicitaCarroDAO {

    private SessionFactory connection;
    private Session session;

    public SolicitaCarroDAO() {
        
        connection = new HibernateUtil().getConnection();
       
        session = connection.openSession();
        
    }    

    public boolean update(SolicitaCarro solicitacarro) {
        try {
            Transaction tx = session.beginTransaction();
            session.update(solicitacarro);
            tx.commit();
            return true;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        } finally {
            closeConnection();
        }
    }

    public SolicitaCarro selectOne(int id) {
        SolicitaCarro solicitacarro = null;
        try {
            solicitacarro = (SolicitaCarro) session.get(SolicitaCarro.class, id);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            session.close();
        }
        return solicitacarro;
    }

    public List<SolicitaCarro> all() {
        List<SolicitaCarro> solicitacarros = null;
        try {
            Transaction tx = session.beginTransaction();
            solicitacarros = session.createQuery("from SolicitaCarro where ativo = true").list();
            tx.commit();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            closeConnection();
        }
        return solicitacarros;
    }
    
    public List<SolicitaCarro> allf() {
        List<SolicitaCarro> solicitacarros = null;
        try {
            Transaction tx = session.beginTransaction();
            solicitacarros = session.createQuery("from SolicitaCarro").list();
            tx.commit();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            closeConnection();
        }
        return solicitacarros;
    }
    
    public List<SolicitaCarro> selectParam(SolicitaCarro solicitacarro) {
        List<SolicitaCarro> solicitacarros = null;
        try {
            Criteria crit = session.createCriteria(SolicitaCarro.class);
            crit.add(Example.create(solicitacarro));
            Transaction tx = session.beginTransaction();
            solicitacarros = crit.list();
            tx.commit();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            closeConnection();
        }
        return solicitacarros;
    }

    public void closeConnection() {
        session.close();
        connection.close();
    }
}
