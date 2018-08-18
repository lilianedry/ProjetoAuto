/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.DAOs;

import database.HibernateUtil;
import model.entities.Funcionario;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Enigma
 */
public class FuncionarioDAO {

    private Session session;
    private Transaction tx;

    public FuncionarioDAO() {
        session = HibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction();
    }

    public boolean add(Funcionario funcionario) {
        try {
            session.save(funcionario);
            tx.commit();
            return true;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        } finally {
            session.close();
        }
    }

    public boolean update(Funcionario funcionario) {
        try {
            session.update(funcionario);
            tx.commit();
            return true;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        } finally {
            session.close();
        }
    }

    public boolean delete(Funcionario funcionario) {
        try {
            session.delete(funcionario);
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
