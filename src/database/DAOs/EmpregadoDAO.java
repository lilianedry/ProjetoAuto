/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.DAOs;

import database.HibernateUtil;
import java.util.List;
import model.entities.Empregado;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Enigma
 */
public class EmpregadoDAO {

    private SessionFactory connection;
    private Session session;

    public EmpregadoDAO() {
        connection = new HibernateUtil().getConnection();
        session = connection.openSession();    
    }

    public boolean add(Empregado empregado) {
        try {
            Transaction tx = session.beginTransaction();
            session.save(empregado);
            tx.commit();
            return true;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        } finally {
            closeConnection();
        }
    }

    public boolean update(Empregado empregado) {
        try {
            Transaction tx = session.beginTransaction();
            session.update(empregado);
            tx.commit();
            return true;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        } finally {
            closeConnection();
        }
    }

    public boolean delete(Empregado empregado) {
        try {
            Transaction tx = session.beginTransaction();
            session.delete(empregado);
            tx.commit();
            return true;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        } finally {
            closeConnection();
        }
    }
    
    public List<Empregado> all () {
        List<Empregado> empregados = null;
        try {
            Transaction tx = session.beginTransaction();
            empregados = session.createQuery("from Empregado where ativo = true").list();
            tx.commit();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            closeConnection();
        }
        return empregados;
    }
    
    public void closeConnection (){
        session.close();
        connection.close();
    }
}
