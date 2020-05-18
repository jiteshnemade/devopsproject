package org.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer tagId;

    public Tag() {
    }

    @Column
    private String tagName;

    @JsonIgnore
    @ManyToMany(mappedBy = "questionTags" ,fetch = FetchType.EAGER,cascade = CascadeType.PERSIST)
    private Set<Question> questions;

    public Tag(String tag) {
        this.tagName=tag;
    }

    public Integer getTagId() {
        return tagId;
    }

    public void setTagId(Integer tagId) {
        this.tagId = tagId;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public Set<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(Set<Question> questions) {
        this.questions = questions;
    }
    //TODO I dont know yet how to do many to many for ques and ans to tag;

}
