package com.enterprise.controller;

import com.enterprise.entity.Information;
import com.enterprise.service.serviceImpl.InformationServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.jws.WebParam;
import java.util.List;
import java.util.Map;

@Controller
public class InformationController {
    @Resource
    private InformationServiceImpl informationService;

    @RequestMapping(value = "/indexinfo", method = RequestMethod.GET)
    @ResponseBody
    public List<Information> getAll(@RequestParam("category") String category) {
        List<Information> informationList;
        informationList = informationService.queryByType(category, 0, 1);
        return informationList;
    }
    @RequestMapping(value = "/index1", method = RequestMethod.GET)
    @ResponseBody
    public Model index(Model model) {
        return null;
    }

}
