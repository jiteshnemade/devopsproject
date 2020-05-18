package org.dao;

import org.bean.Tag;
import org.bean.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.util.SessionUtil;

public class TagDao {
    public void save(Tag tag){
        Session session= SessionUtil.getSession();
        Transaction transaction= session.beginTransaction();

        session.save(tag);

        transaction.commit();
        session.close();
    }
    public Tag find(Integer id){
        Session session = SessionUtil.getSession();
        Transaction transaction = session.beginTransaction();
        Tag tag=session.get(Tag.class,id);
        transaction.commit();
        session.close();
        return tag;
    }
    public Tag findByName(String tagName){
        Session session =SessionUtil.getSession();
        Transaction transaction = session.beginTransaction();

        String hql = "FROM Tag WHERE tagName = :tag_name";
        Query query = session.createQuery(hql);
        query.setParameter("tag_name", tagName);
        Tag tag=null;
        try {
            tag = (Tag) query.getSingleResult();
        }
        catch (javax.persistence.NoResultException e){
            tag =null;
        }

        return tag;
    }
}
