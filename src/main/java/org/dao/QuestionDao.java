package org.dao;

import org.bean.Question;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.util.SessionUtil;

public class QuestionDao {

    public void save(Question domain) {
        Session session = SessionUtil.getSession();
        Transaction transaction = session.beginTransaction();
        session.save(domain);
        transaction.commit();
        session.close();
    }


}
