package org.service;

import org.bean.User;
import org.dao.UserDao;

public interface UserService {
    UserDao userDao=new UserDao();
    void save(User user);
    User find(Integer id);
    User verifyByUserNamePassword(String username,String password);
    User verifyByEmailPassword(String email,String password);

}
