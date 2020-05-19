package org.service;

import org.bean.Answer;
import org.dao.AnswerDao;

import java.util.List;

public interface AnswerService {
    AnswerDao answerDao=new AnswerDao();
    List<Answer> findAnswersToQuestion(Integer questionId);
}
