package org.bean;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.*;

@Entity
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer quesId;

    @Column
    private String q_sub;

    @Column(length = 64000)
    private String q_desc;


    private Date quesTimeStamp=new Date();

    @ManyToOne
    private User user;

    @JsonIgnore
    @OneToMany(fetch = FetchType.EAGER,mappedBy = "question")
    private Set<Answer> answerSet= new HashSet<>();

    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.PERSIST)
    private Set<Tag> questionTags=new HashSet<>();

    @OneToMany(mappedBy = "question",fetch = FetchType.EAGER)
    private Set<QuestionVote> questionVoteList=new HashSet<>();

    public Set<QuestionVote> getQuestionVoteList() {
        return questionVoteList;
    }

    public void setQuestionVoteList(Set<QuestionVote> questionVoteList) {
        this.questionVoteList = questionVoteList;
    }

    public Question(Integer quesId, String q_sub, String q_desc, User user, Set<Answer> answerSet) {
        this.quesId = quesId;
        this.q_sub = q_sub;
        this.q_desc = q_desc;
        this.user = user;
        this.answerSet = answerSet;
    }

    public Question(Integer quesId) {
        this.quesId = quesId;
    }

    public Question() {

    }

    public String getQ_sub() {
        return q_sub;
    }

    public void setQ_sub(String q_sub) {
        this.q_sub = q_sub;
    }

    public String getQ_desc() {
        return q_desc;
    }

    public void setQ_desc(String q_desc) {
        this.q_desc = q_desc;
    }



    public Integer getQuesId() {
        return quesId;
    }

    public Date getQuesTimeStamp() {
        return quesTimeStamp;
    }

    public void setQuesTimeStamp(Date quesTimeStamp) {
        this.quesTimeStamp = quesTimeStamp;
    }

    public Set<Tag> getQuestionTags() {
        return questionTags;
    }

    public void setQuestionTags(Set<Tag> questionTags) {
        this.questionTags = questionTags;
    }

    public void setQuesId(Integer quesId) {
        this.quesId = quesId;
    }




    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Answer> getAnswerSet() {
        return answerSet;
    }

    public void setAnswerSet(Set<Answer> answerSet) {
        this.answerSet = answerSet;
    }
}
