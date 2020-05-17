package org.service.impl;

import org.bean.Question;
import org.service.QuestionService;

public class QuestionServiceImpl implements QuestionService {

    @Override
    public void save(Question question) {
        questionDao.save(question);
    }

    @Override
    public void save(Question question, String q_tags, String userId) {
        String tags[]=q_tags.split(",");
        for(String s:tags){

            question.getQuestionTags().add(s.trim());
        }
    }
}
