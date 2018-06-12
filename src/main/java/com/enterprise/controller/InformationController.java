package com.enterprise.controller;

import com.enterprise.entity.Information;
import com.enterprise.service.serviceImpl.InformationServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/inf")
public class InformationController {

    private Map<Object, Object> resultMap = new HashMap<>();

    @Resource
    private InformationServiceImpl informationService;
//    @ResponseBody
    public Map<Object, Object> getAll(@RequestParam("category") String category) {
        List<Object> infs = new ArrayList<>();
        List<Information> infList = informationService.queryByType(category, 0, 10);

        for(int i=0; i<infList.size(); i++){
            Information inf = infList.get(i);
            Map<Object, Object> infMap = new HashMap<>();
            infMap.put("content", inf.getContent());
            infMap.put("date", inf.getDate());
            infMap.put("digest", inf.getDigest());
            infMap.put("title", inf.getTitle());
            infs.add(infMap);
        }
        resultMap.put("inf", infs);
        return resultMap;
    }


    @RequestMapping(value = "/index")
    @ResponseBody
    public Map<String,String> getInIndex(@RequestParam("category") String category){
        List<Information> infList = informationService.queryByType(category, 0, 1);
        Information inf = infList.get(0);
        Map<String, String> infMap = new HashMap<>();
//        infMap.put("content", inf.getContent());
//        infMap.put("date", inf.getDate());
        infMap.put("digest", inf.getDigest());
        infMap.put("title", inf.getTitle());

        return infMap;
    }

}
