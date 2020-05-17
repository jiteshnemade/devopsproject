package org;

import org.bean.Question;
import org.dao.QuestionDao;

public class TestDriver {

    public static void main(String[] args) {
        Question q = new Question();
        q.setQuesText("hello world");
        QuestionDao qd = new QuestionDao();
        qd.save(q);
        System.out.println(q);
    }
}
