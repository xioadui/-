package com.enterprise.service;

import com.enterprise.entity.User;

public interface UserService {
    User login(int userId, String password);

    int register(User user);
}
