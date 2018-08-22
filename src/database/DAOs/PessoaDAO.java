/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.DAOs;

import database.HibernateUtil;
import java.util.List;
import model.entities.Pessoa;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Enigma
 */
public class PessoaDAO {

    private SessionFactory connection;
    private Session session;

    public PessoaDAO() {
        connection = new HibernateUtil().getConnection();
        session = connection.openSession();   
    }

    public boolean add(Pessoa pessoa) {
        try {
            Transaction tx = session.beginTransaction();
            session.save(pessoa);
            tx.commit();
            return true;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        } finally {
            closeConnection();
        }
    }

    public boolean update(Pessoa pessoa) {
        try {
            Transaction tx = session.beginTransaction();
            session.update(pessoa);
            tx.commit();
            return true;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        } finally {
            closeConnection();
        }
    }

    public boolean delete(Pessoa pessoa) {
        try {
            Transaction tx = session.beginTransaction();
            session.delete(pessoa);
            tx.commit();
            return true;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        } finally {
            closeConnection();
        }
    }
    
    public List<Pessoa> all (Pessoa pessoa) {
        List<Pessoa> pessoas = null;
        try {
            Transaction tx = session.beginTransaction();
            pessoas = session.createQuery("from pessoas").list();
            tx.commit();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            closeConnection();
        }
        return pessoas;
    }
    
    public void closeConnection (){
        session.close();
        connection.close();
    }
}
