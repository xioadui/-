package com.enterprise.controller;

import com.enterprise.entity.IndustryData;
import com.enterprise.service.serviceImpl.IndustryDataServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/ind")
public class IndustryDataController {
    @Resource
    private IndustryDataServiceImpl industryDataService;


    @RequestMapping(value = "/index")
    @ResponseBody
    public Map<String,String> getInIndex(@RequestParam("category") String category){
        List<IndustryData> infList = industryDataService.queryByType(category, 0, 1);
        IndustryData inf = infList.get(0);
        Map<String, String> infMap = new HashMap<>();
        infMap.put("digest", inf.getDigest());
        infMap.put("title", inf.getTitle());
        return infMap;
    }
}
