/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.DAOs;

import database.HibernateUtil;
import java.util.List;
import model.entities.Cliente;
import org.hibernate.Query;
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
        System.out.println("fodac5");
        connection = new HibernateUtil().getConnection();
        System.out.println("fodac6");
        session = connection.openSession();
        System.out.println("fodac7");
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

    public Cliente selectOne(int id) {
        Cliente cliente = null;
        try {
            cliente = (Cliente) session.get(Cliente.class, id);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            session.close();
        }
        return cliente;
    }

    public List<Cliente> all() {
        List<Cliente> clientes = null;
        try {
            Transaction tx = session.beginTransaction();
            clientes = session.createQuery("from Cliente where ativo = true").list();
            tx.commit();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            closeConnection();
        }
        return clientes;
    }
    
    public List<Cliente> allf() {
        List<Cliente> clientes = null;
        try {
            Transaction tx = session.beginTransaction();
            clientes = session.createQuery("from Cliente").list();
            tx.commit();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            closeConnection();
        }
        return clientes;
    }
    
    public List<Cliente> selectNome(String nome) {
        List<Cliente> clientes = null;
        try {
            Transaction tx = session.beginTransaction();
            Query q = session.createQuery("from Usuario where nome = :nome");
            q.setString("nome", nome);
            clientes = q.list();
            tx.commit();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            closeConnection();
        }
        return clientes;
    }

    public void closeConnection() {
        session.close();
        connection.close();
    }
}
