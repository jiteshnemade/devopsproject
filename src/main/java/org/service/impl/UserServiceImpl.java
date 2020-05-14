package org.service.impl;

import org.bean.User;
import org.dao.UserDao;
import org.service.UserService;

public class UserServiceImpl implements UserService {


    @Override
    public void save(User user) {
        userDao.save(user);
    }

    @Override
    public User find(Integer id) {
        return userDao.find(id);
    }

    @Override
    public User verifyByUserNamePassword(String username, String password) {
        return userDao.findByUserNamePassword(username,password);
    }

    @Override
    public User verifyByEmailPassword(String email, String password) {
        return userDao.findByEmailPassword(email,password);
    }
}
