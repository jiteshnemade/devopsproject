package org.util;

import org.bean.*;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SessionUtil {
    private static final SessionFactory sessionFactory;

    static {
        Logger.getLogger("org.hibernate").setLevel(Level.WARNING);
        try {
            Configuration configuration = new Configuration();
            configuration.addAnnotatedClass(User.class).addAnnotatedClass(Tag.class)
                    .addAnnotatedClass(Answer.class).addAnnotatedClass(AnswerVote.class)
                    .addAnnotatedClass(Question.class).addAnnotatedClass(QuestionVote.class);
            sessionFactory = configuration.buildSessionFactory();
        }
        catch (HibernateException ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSession() throws HibernateException {
        return sessionFactory.openSession();
    }
}
