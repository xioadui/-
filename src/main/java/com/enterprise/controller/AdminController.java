package com.enterprise.controller;

import com.enterprise.entity.Enterprise;
import com.enterprise.service.serviceImpl.AdminServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {
    @Resource
    private AdminServiceImpl adminService;

    @RequestMapping(value = "/register")
    @ResponseBody
    public Map<String,Object> register(@RequestParam("index")long index, @RequestParam("length") int length){
        List<Enterprise> enterpriseList = adminService._register(index, length);
//        Map


        return null;
    }

    @RequestMapping(value = "/demand")
    @ResponseBody
    public Map<String,Object> demand(@RequestParam("index")long index,@RequestParam("length") int length){

        return null;
    }

    @RequestMapping(value = "/provide")
    @ResponseBody
    public Map<String,Object> provide(@RequestParam("index")long index,@RequestParam("length") int length){

        return null;
    }
    @RequestMapping(value = "/agreeRegister")
    @ResponseBody
    public String agreeRegister(String entId){
        return adminService._agreeRegister(entId);
    }

    @RequestMapping(value = "/agreeDemand")
    @ResponseBody
    public String agreeDemand(int demandId){
        return adminService._agreeDemand(demandId);
    }

    @RequestMapping(value = "/agreeProvide")
    @ResponseBody
    public String agreeProvide(int proId){
        return adminService._agreeProvide(proId);
    }

}
