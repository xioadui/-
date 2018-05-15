package com.enterprise.dao;

import com.enterprise.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserDao {
    //方法名与mapper的sql语句id相同
    //登录
    User login(@Param("userId") int userId, @Param("password") String password);

    //注册会返回最新的userId
    int register(User user);

}
