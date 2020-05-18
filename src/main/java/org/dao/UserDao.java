package org.dao;

import org.bean.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.util.SessionUtil;

import java.util.List;

public class UserDao {
    public void save(User user){
        Session session= SessionUtil.getSession();
        Transaction transaction= session.beginTransaction();

        session.save(user);

        transaction.commit();
        session.close();
    }
    public User find(Integer id){
       Session session = SessionUtil.getSession();
       Transaction transaction = session.beginTransaction();
       User user=session.get(User.class,id);
       transaction.commit();
       session.close();
       return user;
    }
    public User findByUserNamePassword(String username,String password){
        Session session = SessionUtil.getSession();
        Transaction transaction = session.beginTransaction();

        String hql = "FROM User WHERE username = :userName AND password = :userPassword";
        Query query = session.createQuery(hql);
        query.setParameter("userName", username);
        query.setParameter("userPassword",password);
        User user=null;
        try{
            user = (User) query.getSingleResult();

        }
        catch (javax.persistence.NoResultException e){
            return null;
        }

        return user;
    }
    public List<User> findAll(){
        Session session = SessionUtil.getSession();
        Transaction transaction = session.beginTransaction();

        String hql = "FROM User";
        Query query = session.createQuery(hql);
        List<User> user = query.list();

        transaction.commit();;
        session.close();
        return user;
    }
    public User findByEmailPassword(String email,String password){
        Session session = SessionUtil.getSession();
        Transaction transaction = session.beginTransaction();

        String hql = "FROM User WHERE email = :userEmail AND password = :userPassword";
        Query query = session.createQuery(hql);
        query.setParameter("userEmail", email);
        query.setParameter("userPassword",password);
        User user=null;
        try{
            user = (User) query.getSingleResult();

        }
        catch (javax.persistence.NoResultException e){
            return null;
        }

        return user;
    }

}
