package com.enterprise.controller;

import com.enterprise.entity.Enterprise;
import com.enterprise.service.serviceImpl.EnterpriseServiceImpl;
import org.apache.commons.collections.map.HashedMap;
import org.apache.ibatis.mapping.ResultMap;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Controller
public class EnterpriseController {
    @Resource
    private EnterpriseServiceImpl enterpriseService;
    @RequestMapping(value="/registerForm")
    @ResponseBody
    public Model registerForm(Model model){
        return null;
    }

    @RequestMapping(value="/register",method = RequestMethod.POST)
    @ResponseBody
    public String register(Enterprise enterprise){
        enterprise.setEntIdentity(0);
        enterprise.setEntDate("2014-12-12");
        String result = enterpriseService.register(enterprise);
        return "success";

    }
    @RequestMapping(value="/loginHandler",method = RequestMethod.POST)
    @ResponseBody
    public String login(String entId,String entPassword){
        Enterprise enterprise = enterpriseService.login(entId,entPassword);
        if(enterprise==null)
            return "error";
        return "success";
    }


    @RequestMapping(value="/login",method = RequestMethod.GET)
    @ResponseBody
    public Model loginForm(Model model){
        return null;
    }
}
