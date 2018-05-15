package com.enterprise.controller;

import com.enterprise.crawler.CrawlerClient;
import com.enterprise.entity.Information;
import com.enterprise.service.serviceImpl.InformationServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/index")
public class InformationController {

    private Map<Object, Object> resultMap = new HashMap<>();

    CrawlerClient crawlerClient = new CrawlerClient();

    @Resource
    private InformationServiceImpl informationService;

    @RequestMapping(value = "/information")
    @ResponseBody
    public Map<Object, Object> getAll(){
        String str = crawlerClient.CrawlerClient();
        System.out.println(str);
        List<Object> informations=new ArrayList<Object>();
        List<Information> informationList=informationService.getAll();
        for(int i=0;i<informationList.size();i++) {
            Information _information = informationList.get(i);
            Map<Object, Object> information = new HashMap<Object, Object>();
            information.put("title", _information.getTitle());
            information.put("date", _information.getDate());
            information.put("header", _information.getHeader());
            information.put("content", _information.getContent());
            information.put("digest", _information.getDigest());
            informations.add(information);
        }
        resultMap.put("information", informations);
        return resultMap;
    }
}
