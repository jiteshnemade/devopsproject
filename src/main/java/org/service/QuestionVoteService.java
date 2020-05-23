package org.service;

import org.bean.QuestionVote;
import org.dao.QuestionDao;
import org.dao.QuestionVoteDao;
import org.dao.UserDao;

public interface QuestionVoteService {
    QuestionVoteDao questionVoteDao=new QuestionVoteDao();
    UserDao userDao=new UserDao();
    QuestionDao questionDao=new QuestionDao();
    void upvote(Integer uId,Integer qId);
    void downvote(Integer uId,Integer qId);
}
