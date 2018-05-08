package com.enterprise.controller;

import com.enterprise.entity.User;
import com.enterprise.service.serviceImpl.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value="/user")
public class UserController {

    private Map<String, String> resultMap = new HashMap<>();

    //spring注入userServiceImpl
    @Resource
    private UserServiceImpl userService;

    @RequestMapping(value = "/login")
    public @ResponseBody Map<String, String> login(@RequestParam("userId") int userId, @RequestParam("password") String password){
        System.out.println("登陆中"+userId+"   "+password);
        User user = userService.login(userId, password);
        if(user==null){
            resultMap.put("login", "false");
            System.out.println("login fail");
            return resultMap;
        }
        else{
            resultMap.put("login", "success");
            resultMap.put("userId", String.valueOf(user.getUserId()));
            resultMap.put("userName", user.getUserName());
            resultMap.put("identity", String.valueOf(user.getIdentity()));
            System.out.println("login success");
            return resultMap;
        }
    }

    @RequestMapping(value = "/register")
    @ResponseBody
    public int register(@RequestParam("userName") String userName, @RequestParam("password") String password, @RequestParam("identity") int identity){
        User user = new User();
        user.setUserName(userName);
        user.setPassword(password);
        user.setIdentity(identity);
        return userService.register(user);
    }
}
