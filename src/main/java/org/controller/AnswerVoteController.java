package org.controller;

import org.service.AnswerVoteService;
import org.service.QuestionVoteService;
import org.service.impl.AnswerVoteServiceImpl;
import org.service.impl.QuestionVoteServiceImpl;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("answervote")
public class AnswerVoteController {
    @Path("/upvote/{aid}")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Response upvote(@CookieParam("queryForum_userid") Integer userId,
                           @PathParam("aid") Integer aId){
        AnswerVoteService answerVoteService=new AnswerVoteServiceImpl();
        answerVoteService.upvote(userId,aId);
        return Response.ok().entity("Done").build();

    }
    @Path("/downvote/{aid}")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Response downvote(@CookieParam("queryForum_userid") Integer userId,
                             @PathParam("aid") Integer aId){
        AnswerVoteService answerVoteService=new AnswerVoteServiceImpl();
        answerVoteService.downvote(userId,aId);
        return Response.ok().entity("Done").build();

    }
}
