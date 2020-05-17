package org.service;

import org.bean.Question;
import org.dao.QuestionDao;
import org.dao.TagDao;
import org.dao.UserDao;

public interface QuestionService {
    QuestionDao questionDao =new QuestionDao();
    TagDao tagDao = new TagDao();
    UserDao userDao = new UserDao();
    void save(Question question);

    void save(Question question, String q_tags, String userId);
}
