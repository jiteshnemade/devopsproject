package org.controller;

import org.bean.Question;
import org.glassfish.jersey.media.multipart.FormDataParam;
import org.service.QuestionService;
import org.service.UserService;
import org.service.impl.QuestionServiceImpl;

import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import java.awt.*;
import java.util.TimeZone;

@Path("question")
public class QuestionController {
    private QuestionService questionService=new QuestionServiceImpl();

    @Path("/add")
    @POST
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public void addQuestion(@FormDataParam("q_sub") String q_sub,
                            @FormDataParam("q_desc") String q_desc,
                            @FormDataParam("q_tags") String q_tags,
                            @CookieParam("queryForum_userid") String userId){
        Question question=new Question();
        question.setQ_sub(q_sub);
        question.setQ_desc(q_desc);


        questionService.save(question,q_tags,userId);

    }
}
