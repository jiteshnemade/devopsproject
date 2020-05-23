package org.service.impl;

import org.bean.AnswerVote;
import org.bean.QuestionVote;
import org.service.AnswerVoteService;

public class AnswerVoteServiceImpl implements AnswerVoteService {
    @Override
    public void upvote(Integer uId, Integer aId) {
        AnswerVote answerVote=answerVoteDao.find(uId,aId);
        if(answerVote==null){
            answerVote=new AnswerVote();
            answerVote.setVote(1);
            answerVote.setUser(userDao.find(uId));
            answerVote.setAnswer(answerDao.find(aId));
            answerVoteDao.save(answerVote);
        }
        else{
            answerVote.setVote(1);
            answerVoteDao.update(answerVote);
        }
    }

    @Override
    public void downvote(Integer uId, Integer aId) {
        AnswerVote answerVote=answerVoteDao.find(uId,aId);
        if(answerVote==null){
            answerVote=new AnswerVote();
            answerVote.setVote(-1);
            answerVote.setUser(userDao.find(uId));
            answerVote.setAnswer(answerDao.find(aId));
            answerVoteDao.save(answerVote);
        }
        else{
            answerVote.setVote(-1);
            answerVoteDao.update(answerVote);
        }

    }
}
