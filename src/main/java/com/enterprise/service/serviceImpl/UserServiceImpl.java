package com.enterprise.service.serviceImpl;

import com.enterprise.dao.IUserDao;
import com.enterprise.entity.User;
import com.enterprise.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {

    //spring注入userDao
    @Resource
    private IUserDao userDao;

    @Override
    public User login(int userId, String password) {
        System.out.println("1");
        //调用userDao的login方法
        return userDao.login(userId, password);
    }

    @Override
    public int register(User user) {
        userDao.register(user);
        return user.getUserId();
    }
}
