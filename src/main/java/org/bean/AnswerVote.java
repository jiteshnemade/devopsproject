package org.bean;

import javax.persistence.*;

@Entity
public class AnswerVote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ansVoteId;

    @Column
    private Integer vote; //+1 for upvote ; -1 for downvote

    @OneToOne
    private User user;

    @OneToOne
    private Answer ans;

    public Integer getAnsVoteId() {
        return ansVoteId;
    }

    public void setAnsVoteId(Integer ansVoteId) {
        this.ansVoteId = ansVoteId;
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

    public Answer getAns() {
        return ans;
    }

    public void setAns(Answer ans) {
        this.ans = ans;
    }
}
