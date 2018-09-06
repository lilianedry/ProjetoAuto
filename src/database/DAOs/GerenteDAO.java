/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.DAOs;

import database.HibernateUtil;
import java.util.List;
import model.entities.Gerente;
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
    
    public List<Gerente> allf() {
        List<Gerente> gerentes = null;
        try {
            Transaction tx = session.beginTransaction();
            gerentes = session.createQuery("from Gerente").list();
            tx.commit();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            closeConnection();
        }
        return gerentes;
    }
    
    public List<Gerente> selectNome(String nome) {
        List<Gerente> gerentes = null;
        try {
            Transaction tx = session.beginTransaction();
            Criteria crit = session.createCriteria(Gerente.class);
            crit.add(Restrictions.eq("nome", nome + "%"));
            gerentes = crit.list();
            tx.commit();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            closeConnection();
        }
        return gerentes;
    }
    
    public List<Gerente> selectParam(Gerente gerente) {
        List<Gerente> gerentes = null;
        try {
            Criteria crit = session.createCriteria(Gerente.class);
            crit.add(Example.create(gerente));
            Transaction tx = session.beginTransaction();
            gerentes = crit.list();
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
