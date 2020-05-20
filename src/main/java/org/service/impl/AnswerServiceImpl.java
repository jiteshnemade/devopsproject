package org.service.impl;

import org.bean.Answer;
import org.service.AnswerService;

import java.util.List;

public class AnswerServiceImpl implements AnswerService {
    @Override
    public List<Answer> findAnswersToQuestion(Integer questionId) {
        return answerDao.findAnswersToQuestion(questionId);
    }

    @Override
    public void add(Integer questionId, Integer userId, String answer) {
        Answer ans=new Answer();
        ans.setAnsText(answer);
        ans.setQuestion(questionDao.find(questionId));
        ans.setUser(userDao.find(userId));
        answerDao.save(ans);
    }
}
