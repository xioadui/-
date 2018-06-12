package com.enterprise.controller;

import com.enterprise.entity.Information;
import com.enterprise.service.serviceImpl.InformationServiceImpl;
import org.apache.ibatis.annotations.Param;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
<<<<<<< HEAD
import javax.jws.WebParam;
=======
import java.util.ArrayList;
import java.util.HashMap;
>>>>>>> f7469936b1e08e789dd1a735e9a7b7834c57e27a
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/inf")
public class InformationController {

    private Map<Object, Object> resultMap = new HashMap<>();

    @Resource
    private InformationServiceImpl informationService;

    @RequestMapping(value = "/indexinfo", method = RequestMethod.GET)
    @ResponseBody
<<<<<<< HEAD
    public List<Information> getAll(@RequestParam("category") String category) {
        List<Information> informationList;
        informationList = informationService.queryByType(category, 0, 1);
        return informationList;
    }
    @RequestMapping(value = "/index1", method = RequestMethod.GET)
    @ResponseBody
    public Model index(Model model) {
        return null;
=======
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
>>>>>>> f7469936b1e08e789dd1a735e9a7b7834c57e27a
    }

}
