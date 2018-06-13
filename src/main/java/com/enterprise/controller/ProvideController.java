package com.enterprise.controller;

import com.enterprise.entity.Demand;
import com.enterprise.entity.Provide;
import com.enterprise.service.serviceImpl.ProvideServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.*;

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

    @RequestMapping(value="/publish")
    @ResponseBody
    public Map<String,String> publish(HttpSession session,
                                       @RequestParam("content") String demandContent,
                                       @RequestParam("digest") String demandDigest,
                                       @RequestParam("title") String demandTitle,
                                       @RequestParam("type") String demandType){
        Provide provide = new Provide();
        Date day=new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        provide.setProDate(df.format(day));
        String entId = (String)session.getAttribute("entId");
        provide.setEntId(entId);
        provide.setProContent(demandContent);
        provide.setProTitle(demandTitle);
        provide.setProDigest(demandDigest);
        provide.setProType(demandType);
        String result = provideService.publish(provide);
        Map<String,String> r = new HashMap<>();
        r.put("result",result);
        return r;
    }

}
