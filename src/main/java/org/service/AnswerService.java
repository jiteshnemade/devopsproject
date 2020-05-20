package org.service;

import org.bean.Answer;
import org.bean.Question;
import org.dao.AnswerDao;
import org.dao.QuestionDao;
import org.dao.UserDao;

import java.util.List;

public interface AnswerService {
    AnswerDao answerDao=new AnswerDao();
    QuestionDao questionDao = new QuestionDao();
    UserDao userDao = new UserDao();
    List<Answer> findAnswersToQuestion(Integer questionId);
    void add(Integer questionId,Integer userId,String answer);
}
