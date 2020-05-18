package org.bean;

import javax.persistence.*;

@Entity
public class QuestionVote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer quesVoteId;

    @Column
    private Integer vote; //+1 for upvote ; -1 for downvote

    @OneToOne
    private User user;

    @OneToOne
    private Question question;

    public QuestionVote() {
    }

    public Integer getQuesVoteId() {
        return quesVoteId;
    }

    public void setQuesVoteId(Integer quesVoteId) {
        this.quesVoteId = quesVoteId;
    }

    public Integer getVote() {
        return vote;
    }

    public void setVote(Integer vote) {
        this.vote = vote;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }
}
