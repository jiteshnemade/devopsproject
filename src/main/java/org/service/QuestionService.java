package org.service;

import org.bean.Question;
import org.dao.QuestionDao;
import org.dao.TagDao;
import org.dao.UserDao;

import java.util.List;

public interface QuestionService {
    QuestionDao questionDao =new QuestionDao();
    TagDao tagDao = new TagDao();
    UserDao userDao = new UserDao();
    void save(Question question);
    List<Question> findAll();
    void save(Question question, String q_tags, String userId);
}
