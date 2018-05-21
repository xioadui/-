package com.enterprise.controller;

import com.enterprise.entity.Information;
import com.enterprise.service.serviceImpl.InformationServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class InformationController {
    @Resource
    private InformationServiceImpl informationService;
    @RequestMapping(value ="/index")
    //@ResponseBody
    public Model getAll(Model model){
        List<Information> informationList;//=infomationService.getAll();
        //informationList = infomationService.queryByTitle("2017年平均工资数据出炉 IT再列榜首");
        informationList = informationService.queryByDate("2018-05-17",0,10);
        model.addAttribute("informationList",informationList);
        return model;
    }
}
