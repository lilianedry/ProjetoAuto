/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.DAOs;

import database.HibernateUtil;
import java.util.List;
import model.entities.Funcionario;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Enigma
 */
public class FuncionarioDAO {

    private SessionFactory connection;
    private Session session;

    public FuncionarioDAO() {
        connection = new HibernateUtil().getConnection();
        session = connection.openSession();    
    }

    public boolean add(Funcionario funcionario) {
        try {
            Transaction tx = session.beginTransaction();
            session.save(funcionario);
            tx.commit();
            return true;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        } finally {
            closeConnection();
        }
    }

    public boolean update(Funcionario funcionario) {
        try {
            Transaction tx = session.beginTransaction();
            session.update(funcionario);
            tx.commit();
            return true;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        } finally {
            closeConnection();
        }
    }

    public boolean delete(Funcionario funcionario) {
        try {
            Transaction tx = session.beginTransaction();
            session.delete(funcionario);
            tx.commit();
            return true;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        } finally {
            closeConnection();
        }
    }
    
    public List<Funcionario> all () {
        List<Funcionario> funcionarios = null;
        try {
            Transaction tx = session.beginTransaction();
            funcionarios = session.createQuery("from Funcionario where ativo = true").list();
            tx.commit();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            closeConnection();
        }
        return funcionarios;
    }
    
    public List<Funcionario> allf() {
        List<Funcionario> funcionarios = null;
        try {
            Transaction tx = session.beginTransaction();
            funcionarios = session.createQuery("from Funcionario").list();
            tx.commit();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            closeConnection();
        }
        return funcionarios;
    }
    
    public List<Funcionario> selectNome(String nome) {
        List<Funcionario> funcionarios = null;
        try {
            Transaction tx = session.beginTransaction();
            Query q = session.createQuery("from Usuario where nome = :nome");
            q.setString("nome", nome);
            funcionarios = q.list();
            tx.commit();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            closeConnection();
        }
        return funcionarios;
    }
    
    public void closeConnection (){
        session.close();
        connection.close();
    }
}
