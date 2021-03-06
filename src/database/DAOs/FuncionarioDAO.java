/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.DAOs;

import database.HibernateUtil;
import java.util.List;
import model.entities.Funcionario;
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
            Criteria crit = session.createCriteria(Funcionario.class);
            crit.add(Restrictions.eq("nome", nome + "%"));
            funcionarios = crit.list();
            tx.commit();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            closeConnection();
        }
        return funcionarios;
    }
    
    public List<Funcionario> selectParam(Funcionario funcionario) {
        List<Funcionario> funcionarios = null;
        try {
            Criteria crit = session.createCriteria(Funcionario.class);
            crit.add(Example.create(funcionario));
            Transaction tx = session.beginTransaction();
            funcionarios = crit.list();
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
