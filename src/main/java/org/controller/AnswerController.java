package org.controller;

import org.bean.Answer;
import org.bean.Question;
import org.glassfish.jersey.media.multipart.FormDataParam;
import org.service.AnswerService;
import org.service.impl.AnswerServiceImpl;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("answer")
public class AnswerController {
    AnswerService answerService=new AnswerServiceImpl();
    @Path("/add/{qid}")
    @POST
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public void addAnswerToQuestion(@PathParam("qid") Integer questionId,
                                    @CookieParam("queryForum_userid") Integer userId,
                                    @FormDataParam("answer") String answer
                                    ){

    }

    @Path("/get/{qid}")
    @GET
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public Response getAnswersToQuestion(@PathParam("qid") Integer questionId){
        List<Answer> answerList = answerService.findAnswersToQuestion(questionId);
        System.out.println(answerList.size());
        if (answerList.size()==0) {
            System.out.println("No containt");

            return Response.noContent().build();
        }

        return Response.ok().entity(answerList).build();

    }

}
