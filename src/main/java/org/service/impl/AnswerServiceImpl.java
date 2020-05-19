package org.service.impl;

import org.bean.Answer;
import org.service.AnswerService;

import java.util.List;

public class AnswerServiceImpl implements AnswerService {
    @Override
    public List<Answer> findAnswersToQuestion(Integer questionId) {
        return answerDao.findAnswersToQuestion(questionId);
    }
}
