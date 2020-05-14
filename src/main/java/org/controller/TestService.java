package org.controller;

import org.bean.User;
import org.dao.UserDao;
import org.service.UserService;
import org.service.impl.UserServiceImpl;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import java.util.Map;
import java.util.stream.Collectors;


@Path("test")
public class TestService {

    @GET
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public User  testResource(){
        System.out.println("Test Resource Called");
        /*UserDao userDao=new UserDao();
        User user=new User();
        user.setUserName("testuser");
        user.setPassword("testpassword");
        userDao.save(user);*/
        UserService userService=new UserServiceImpl();
        return userService.find(2);

        //return "Test Service Called";
    }

    @GET
    @Path("/readCookies")
    public String readAllCookies(@Context HttpHeaders headers) {
        System.out.println("Read cookies called");
        Map<String, Cookie> cookies = headers.getCookies();
        String str = cookies.entrySet()
                .stream()
                .map(e -> e.getKey() + " = " + e.getValue().getValue())
                .collect(Collectors.joining("<br/>"));
        return str;
    }

}
