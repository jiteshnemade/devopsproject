package org.service.impl;

import org.bean.QuestionVote;
import org.service.QuestionVoteService;

public class QuestionVoteServiceImpl implements QuestionVoteService {
    @Override
    public void upvote(Integer uId, Integer qId) {
        QuestionVote questionVote=questionVoteDao.find(uId,qId);
        if(questionVote==null){
            questionVote=new QuestionVote();
            questionVote.setVote(1);
            questionVote.setUser(userDao.find(uId));
            questionVote.setQuestion(questionDao.find(qId));
            questionVoteDao.save(questionVote);
        }
        else{
            questionVote.setVote(1);
            questionVoteDao.update(questionVote);
        }
    }

    @Override
    public void downvote(Integer uId, Integer qId) {
        QuestionVote questionVote=questionVoteDao.find(uId,qId);
        if(questionVote==null){
            questionVote=new QuestionVote();
            questionVote.setVote(-1);
            questionVote.setUser(userDao.find(uId));
            questionVote.setQuestion(questionDao.find(qId));
            questionVoteDao.save(questionVote);
        }
        else{
            questionVote.setVote(-1);
            questionVoteDao.update(questionVote);
        }


    }
}
