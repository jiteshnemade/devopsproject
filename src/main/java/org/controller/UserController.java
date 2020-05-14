package org.controller;

import org.bean.User;
import org.glassfish.jersey.media.multipart.FormDataParam;
import org.service.UserService;
import org.service.impl.UserServiceImpl;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.net.URISyntaxException;

@Path("user")
public class UserController {
    private UserService userService=new UserServiceImpl();

    @POST
    @Path("/add")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Response addUser(@FormDataParam("username") String username,
                            @FormDataParam("password") String password,
                            @FormDataParam("name") String name,
                            @FormDataParam("email") String email
                            ) throws URISyntaxException {
        User user=new User();
        user.setUserName(username);
        user.setPassword(password);
        user.setName(name);
        user.setEmail(email);

        userService.save(user);

        return Response.seeOther(new URI("/queryForum_war/login.html")).build();
    }

    @POST
    @Path("/verify")
    @Consumes(MediaType.MULTIPART_FORM_DATA)

    public Response verifyByUsernamePassword(@FormDataParam("username") String username, @FormDataParam("password") String password) throws URISyntaxException {
        User user1=userService.verifyByUserNamePassword(username,password);
        User user2=userService.verifyByEmailPassword(username,password);
        if(user1==null && user2==null)
            return Response.status(Response.Status.UNAUTHORIZED).entity("Invalid Credentials").build();
        else{
            User user= user1==null ? user2 :user1;
            //NewCookie cookie = new NewCookie("queryForum_username", username);



            /**
             * Create a new instance.
             *
             * @param name    the name of the cookie.
             * @param value   the value of the cookie.
             * @param path    the URI path for which the cookie is valid.
             * @param domain  the host domain for which the cookie is valid.
             * @param comment the comment.
             * @param maxAge  the maximum age of the cookie in seconds.
             * @param secure  specifies whether the cookie will only be sent over a secure connection.
             * @throws IllegalArgumentException if name is {@code null}.
             */

              /*
    public NewCookie(String name,
                    String value,
                    String path,
                    String domain,
                    String comment,
            int maxAge,
            boolean secure) {
                this(name, value, path, domain, DEFAULT_VERSION, comment, maxAge, null, secure, false);
            }*/


            NewCookie cookie1 = new NewCookie("queryForum_username",user.getUserName(),"/","localhost","my first cookie",30*60,false);
            NewCookie cookie2 = new NewCookie("queryForum_userid",""+user.getUserId(),"/","localhost","my first cookie",30*60,false);
            NewCookie cookie3 = new NewCookie("queryForum_useremail",user.getEmail(),"/","localhost","my first cookie",30*60,false);
            NewCookie cookie4 = new NewCookie("queryForum_name",user.getName(),"/","localhost","my first cookie",30*60,false);

            return Response.seeOther(new URI("/queryForum_war/account.html")).cookie(cookie1,cookie2,cookie3,cookie4).build();

        }

    }

    @GET
    @Path("/logout")
    public Response logout() throws URISyntaxException {

            NewCookie cookie1 = new NewCookie("queryForum_username", "", "/", "localhost", "my first cookie", 0, false);
            NewCookie cookie2 = new NewCookie("queryForum_userid", "" , "/", "localhost", "my first cookie", 0, false);
            NewCookie cookie3 = new NewCookie("queryForum_useremail","", "/", "localhost", "my first cookie", 0, false);
            NewCookie cookie4 = new NewCookie("queryForum_name", "", "/", "localhost", "my first cookie", 0, false);

            return Response.seeOther(new URI("/queryForum_war/login.html")).cookie(cookie1, cookie2, cookie3, cookie4).build();


    }
}
