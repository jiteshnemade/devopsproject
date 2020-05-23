package org.dao;

import org.bean.Question;
import org.bean.QuestionVote;
import org.bean.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.util.SessionUtil;

public class QuestionVoteDao {
    public void save(QuestionVote questionVote) {
        Session session = SessionUtil.getSession();
        Transaction transaction = session.beginTransaction();
        session.save(questionVote);
        transaction.commit();
        session.close();
    }
    public QuestionVote find(Integer uId,Integer qId){
        Session session=SessionUtil.getSession();
        Transaction transaction=session.beginTransaction();
        String hql = "FROM QuestionVote WHERE user.userId = :uId AND question.quesId = :qId";
        Query query = session.createQuery(hql);
        query.setParameter("uId", uId);
        query.setParameter("qId", qId);
        QuestionVote questionVote=null;
        try{
            questionVote = (QuestionVote) query.getSingleResult();
        }
        catch (javax.persistence.NoResultException e){
            return null;
        }
        transaction.commit();
        session.close();
        return questionVote;
    }
    public void update(QuestionVote questionVote){
        Session session = SessionUtil.getSession();
        Transaction transaction = session.beginTransaction();
        session.update(questionVote);
        transaction.commit();
        session.close();
    }

}
