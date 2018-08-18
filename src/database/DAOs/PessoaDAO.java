/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.DAOs;

import database.HibernateUtil;
import model.entities.Pessoa;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Enigma
 */
public class PessoaDAO {

    private Session session;
    private Transaction tx;

    public PessoaDAO() {
        session = HibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction();
    }

    public boolean add(Pessoa pessoa) {
        try {
            session.save(pessoa);
            tx.commit();
            return true;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        } finally {
            session.close();
        }
    }

    public boolean update(Pessoa pessoa) {
        try {
            session.update(pessoa);
            tx.commit();
            return true;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        } finally {
            session.close();
        }
    }

    public boolean delete(Pessoa pessoa) {
        try {
            session.delete(pessoa);
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
