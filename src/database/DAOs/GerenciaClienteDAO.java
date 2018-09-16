/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.DAOs;

import database.HibernateUtil;
import java.util.List;
import model.entities.relationships.GerenciaCliente;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;

/**
 *
 * @author Enigma
 */
public class GerenciaClienteDAO {

    private SessionFactory connection;
    private Session session;

    public GerenciaClienteDAO() {
        
        connection = new HibernateUtil().getConnection();
       
        session = connection.openSession();
        
    }    

    public boolean update(GerenciaCliente gerenciaCliente) {
        try {
            Transaction tx = session.beginTransaction();
            session.update(gerenciaCliente);
            tx.commit();
            return true;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        } finally {
            closeConnection();
        }
    }

    public GerenciaCliente selectOne(int id) {
        GerenciaCliente gerenciaCliente = null;
        try {
            gerenciaCliente = (GerenciaCliente) session.get(GerenciaCliente.class, id);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            session.close();
        }
        return gerenciaCliente;
    }

    public List<GerenciaCliente> all() {
        List<GerenciaCliente> gerenciaClientes = null;
        try {
            Transaction tx = session.beginTransaction();
            gerenciaClientes = session.createQuery("from GerenciaCliente where ativo = true").list();
            tx.commit();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            closeConnection();
        }
        return gerenciaClientes;
    }
    
    public List<GerenciaCliente> allf() {
        List<GerenciaCliente> gerenciaClientes = null;
        try {
            Transaction tx = session.beginTransaction();
            gerenciaClientes = session.createQuery("from GerenciaCliente").list();
            tx.commit();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            closeConnection();
        }
        return gerenciaClientes;
    }
    
    public List<GerenciaCliente> selectParam(GerenciaCliente gerenciaCliente) {
        List<GerenciaCliente> gerenciaClientes = null;
        try {
            Criteria crit = session.createCriteria(GerenciaCliente.class);
            crit.add(Example.create(gerenciaCliente));
            Transaction tx = session.beginTransaction();
            gerenciaClientes = crit.list();
            tx.commit();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            closeConnection();
        }
        return gerenciaClientes;
    }

    public void closeConnection() {
        session.close();
        connection.close();
    }
}
