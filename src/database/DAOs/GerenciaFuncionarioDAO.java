/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.DAOs;

import database.HibernateUtil;
import java.util.List;
import model.entities.relationships.GerenciaFuncionario;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;

/**
 *
 * @author Enigma
 */
public class GerenciaFuncionarioDAO {

    private SessionFactory connection;
    private Session session;

    public GerenciaFuncionarioDAO() {
        
        connection = new HibernateUtil().getConnection();
       
        session = connection.openSession();
        
    }    

    public boolean update(GerenciaFuncionario gerenciaFuncionario) {
        try {
            Transaction tx = session.beginTransaction();
            session.update(gerenciaFuncionario);
            tx.commit();
            return true;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        } finally {
            closeConnection();
        }
    }

    public GerenciaFuncionario selectOne(int id) {
        GerenciaFuncionario gerenciaFuncionario = null;
        try {
            gerenciaFuncionario = (GerenciaFuncionario) session.get(GerenciaFuncionario.class, id);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            session.close();
        }
        return gerenciaFuncionario;
    }

    public List<GerenciaFuncionario> all() {
        List<GerenciaFuncionario> gerenciaFuncionarios = null;
        try {
            Transaction tx = session.beginTransaction();
            gerenciaFuncionarios = session.createQuery("from GerenciaFuncionario where ativo = true").list();
            tx.commit();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            closeConnection();
        }
        return gerenciaFuncionarios;
    }
    
    public List<GerenciaFuncionario> allf() {
        List<GerenciaFuncionario> gerenciaFuncionarios = null;
        try {
            Transaction tx = session.beginTransaction();
            gerenciaFuncionarios = session.createQuery("from GerenciaFuncionario").list();
            tx.commit();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            closeConnection();
        }
        return gerenciaFuncionarios;
    }
    
    public List<GerenciaFuncionario> selectParam(GerenciaFuncionario gerenciaFuncionario) {
        List<GerenciaFuncionario> gerenciaFuncionarios = null;
        try {
            Criteria crit = session.createCriteria(GerenciaFuncionario.class);
            crit.add(Example.create(gerenciaFuncionario));
            Transaction tx = session.beginTransaction();
            gerenciaFuncionarios = crit.list();
            tx.commit();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            closeConnection();
        }
        return gerenciaFuncionarios;
    }

    public void closeConnection() {
        session.close();
        connection.close();
    }
}
