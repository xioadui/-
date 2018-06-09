package com.enterprise.controller;

import com.enterprise.entity.Provide;
import com.enterprise.service.serviceImpl.ProvideServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/provide")
public class ProvideController {

    private Map<Object, Object> resultMap = new HashMap<>();

    @Resource
    private ProvideServiceImpl provideService;

    @RequestMapping(value = "/getAllPro")
    @ResponseBody
    public Map<Object, Object> getAllPro(){
        List<Object> pros = new ArrayList<>();
        List<Provide> proList = provideService.getAllPro();
        for(int i=0; i<proList.size(); i++){
            Provide pro = proList.get(i);
            Map<Object, Object> proMap = new HashMap<>();
            proMap.put("proId", pro.getProId());
            proMap.put("entId", pro.getEntId());
            proMap.put("proContent", pro.getProContent());
            proMap.put("proDate", pro.getProDate());
            proMap.put("proDigest", pro.getProDigest());
            proMap.put("proTitle", pro.getProTitle());
            proMap.put("proType", pro.getProType());
            pros.add(proMap);
        }
        resultMap.put("pro", pros);
        return resultMap;
    }


}
