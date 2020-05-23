package org.dao;

import org.bean.Answer;
import org.bean.AnswerVote;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.util.SessionUtil;

public class AnswerVoteDao {
    public void save(AnswerVote answerVote) {
        Session session = SessionUtil.getSession();
        Transaction transaction = session.beginTransaction();
        session.save(answerVote);
        transaction.commit();
        session.close();
    }
    public AnswerVote find(Integer uId,Integer aId){
        Session session=SessionUtil.getSession();
        Transaction transaction=session.beginTransaction();
        String hql = "FROM AnswerVote WHERE user.userId = :uId AND answer.ansId = :aId";
        Query query = session.createQuery(hql);
        query.setParameter("uId", uId);
        query.setParameter("aId", aId);
        AnswerVote answerVote=null;
        try{
            answerVote = (AnswerVote) query.getSingleResult();
        }
        catch (javax.persistence.NoResultException e){
            return null;
        }
        transaction.commit();
        session.close();
        return answerVote;
    }
    public void update(AnswerVote answerVote){
        Session session = SessionUtil.getSession();
        Transaction transaction = session.beginTransaction();
        session.update(answerVote);
        transaction.commit();
        session.close();
    }
}
