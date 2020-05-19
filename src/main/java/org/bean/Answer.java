package org.bean;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Entity
public class Answer  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ansId;

    public Answer() {
    }

    @Column(length = 64000)
    private String ansText;

    private Date ansTimeStamp=new Date();

    @OneToOne
    private User user;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    private Question question;

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(mappedBy = "answer")
    private List<AnswerVote> answerVoteList=new ArrayList<>();



    public Integer getAnsId() {
        return ansId;
    }

    public void setAnsId(Integer ansId) {
        this.ansId = ansId;
    }

    public String getAnsText() {
        return ansText;
    }

    public void setAnsText(String ansText) {
        this.ansText = ansText;
    }


    public Date getAnsTimeStamp() {
        return ansTimeStamp;
    }

    public void setAnsTimeStamp(Date ansTimeStamp) {
        this.ansTimeStamp = ansTimeStamp;
    }

    public List<AnswerVote> getAnswerVoteList() {
        return answerVoteList;
    }

    public void setAnswerVoteList(List<AnswerVote> answerVoteList) {
        this.answerVoteList = answerVoteList;
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
