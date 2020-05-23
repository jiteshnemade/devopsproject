package org.service;

import org.dao.*;

public interface AnswerVoteService {
    AnswerVoteDao answerVoteDao=new AnswerVoteDao();
    UserDao userDao=new UserDao();
    AnswerDao answerDao=new AnswerDao();
    void upvote(Integer uId,Integer aId);
    void downvote(Integer uId,Integer aId);
}
