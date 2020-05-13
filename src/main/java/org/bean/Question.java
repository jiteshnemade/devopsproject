package org.bean;


import javax.persistence.*;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer quesId;

    @Column
    private String quesText;

    @Temporal(TemporalType.DATE)
    private Calendar quesTimeStamp;

    @OneToOne
    private User user;

    @OneToMany
    private Set<Answer> answerSet = new HashSet<>();

    public Integer getQuesId() {
        return quesId;
    }

    public void setQuesId(Integer quesId) {
        this.quesId = quesId;
    }

    public String getQuesText() {
        return quesText;
    }

    public void setQuesText(String quesText) {
        this.quesText = quesText;
    }

    public Calendar getQuesTimeStamp() {
        return quesTimeStamp;
    }

    public void setQuesTimeStamp(Calendar quesTimeStamp) {
        this.quesTimeStamp = quesTimeStamp;
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
