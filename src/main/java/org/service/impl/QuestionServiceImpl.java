package org.service.impl;

import org.bean.Question;
import org.bean.Tag;
import org.bean.User;
import org.hibernate.Session;
import org.service.QuestionService;

import java.util.HashSet;
import java.util.List;

public class QuestionServiceImpl implements QuestionService {

    @Override
    public void save(Question question) {
        questionDao.save(question);
    }

    @Override
    public List<Question> findAll() {
        return questionDao.findAll();
    }

    @Override
    public void save(Question question, String q_tags, String userId) {
        String tags[]=q_tags.split(",");
        HashSet<Tag> hashSet=new HashSet<>();
        for(String tag:tags){
            if(tagDao.findByName(tag)==null){
                tagDao.save(new Tag(tag));
            }
            Tag t=tagDao.findByName(tag);
            //Tag t=new Tag(tag);
            hashSet.add(t);
        }
        question.setQuestionTags(hashSet);
        User user=userDao.find(Integer.parseInt(userId));
        question.setUser(user);
        questionDao.save(question);
    }

    @Override
    public Question find(int id) {
        return questionDao.find(id);
    }
}
