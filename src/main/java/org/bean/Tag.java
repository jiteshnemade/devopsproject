package org.bean;

import javax.persistence.*;

@Entity
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer tagId;

    @Column
    private String tagName;


    //TODO I dont know yet how to do many to many for ques and ans to tag;

}
