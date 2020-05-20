package org.dao;

import org.bean.Answer;
import org.bean.Question;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.util.SessionUtil;

import java.util.List;

public class AnswerDao {
    public List<Answer> findAnswersToQuestion(Integer questionId){
        Session session= SessionUtil.getSession();
        Transaction transaction= session.beginTransaction();

        String hql = "From Answer WHERE question.id = :questionArg";
        Query query=session.createQuery(hql);
        query.setParameter("questionArg",questionId);
        List<Answer> answerList = query.list();



        transaction.commit();
        session.close();

        return answerList;
    }
    public void save(Answer answer) {
        Session session = SessionUtil.getSession();
        Transaction transaction = session.beginTransaction();
        session.save(answer);
        transaction.commit();
        session.close();
    }


}
