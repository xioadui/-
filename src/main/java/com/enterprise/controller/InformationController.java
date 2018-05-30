package com.enterprise.controller;

import com.enterprise.entity.Information;
import com.enterprise.service.serviceImpl.InformationServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class InformationController {
    @Resource
    private InformationServiceImpl informationService;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    @ResponseBody
    public Model getAll(Model model) {
        List<Information> informationList;
        informationList = informationService.queryByType("建筑房地产", 0, 10);
        model.addAttribute("informationList", informationList);
        return model;
    }

}
