package org.dao;

import org.bean.Question;
import org.bean.Tag;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.util.SessionUtil;

import java.util.List;

public class QuestionDao {

    public void save(Question question) {
        Session session = SessionUtil.getSession();
        Transaction transaction = session.beginTransaction();
        session.save(question);
        transaction.commit();
        session.close();
    }
    public Question find(Integer id){
        Session session = SessionUtil.getSession();
        Transaction transaction = session.beginTransaction();
        Question question=session.get(Question.class,id);
        transaction.commit();
        session.close();
        return question;
    }

    public List<Question> findAll(){
        Session session=SessionUtil.getSession();
        Transaction transaction=session.beginTransaction();

        String hql = "From Question";
        Query query=session.createQuery(hql);
        List<Question> questionList = query.list();

        transaction.commit();
        session.close();
        return questionList;
    }



}
