package org.controller;

import org.service.QuestionVoteService;
import org.service.impl.QuestionVoteServiceImpl;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.awt.*;

@Path("questionvote")
public class QuestionVoteController {
    @Path("/upvote/{qid}")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Response upvote(@CookieParam("queryForum_userid") Integer userId,
                           @PathParam("qid") Integer qId){
        QuestionVoteService questionVoteService=new QuestionVoteServiceImpl();
        questionVoteService.upvote(userId,qId);
        return Response.ok().entity("Done").build();

    }
    @Path("/downvote/{qid}")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Response downvote(@CookieParam("queryForum_userid") Integer userId,
                        @PathParam("qid") Integer qId){
        QuestionVoteService questionVoteService=new QuestionVoteServiceImpl();
        questionVoteService.downvote(userId,qId);
        return Response.ok().entity("Done").build();

    }
}
