package com.enterprise.controller;

import com.enterprise.entity.Demand;
import com.enterprise.service.serviceImpl.DemandServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping(value = "/demand")
public class DemandController {
    @Resource
    DemandServiceImpl demandService;
    @RequestMapping(value = "/allDemand")
    @ResponseBody
    public Map<Object, Object> getAllDemand(){
        Map<Object, Object> resultMap = new HashMap<>();
        List<Object> demands = new ArrayList<>();
        List<Demand> demandList = demandService.getAllDemand();
        for(int i=0; i<demandList.size(); i++){
            Demand demand = demandList.get(i);
            Map<Object, Object> demandMap = new HashMap<>();
            demandMap.put("demandId", demand.getDemandId());
            demandMap.put("entId", demand.getEntId());
            demandMap.put("demandContent", demand.getDemandContent());
            demandMap.put("demandDate", demand.getDemandDate());
            demandMap.put("demandDigest", demand.getDemandDigest());
            demandMap.put("demandTitle", demand.getDemandTitle());
            demandMap.put("demandType", demand.getDemandType());
            demands.add(demandMap);
        }
        resultMap.put("demand", demands);
        return resultMap;
    }

    @RequestMapping(value="/publish")
    @ResponseBody
    public Map<String, String> publish(HttpSession session,
                                       @RequestParam("content") String demandContent,
                                       @RequestParam("digest") String demandDigest,
                                       @RequestParam("title") String demandTitle,
                                       @RequestParam("type") String demandType){
        Demand demand = new Demand();
        demand.setDemandContent(demandContent);
        Date day=new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        demand.setDemandDate(df.format(day));
        demand.setDemandDigest(demandDigest);
        demand.setDemandTitle(demandTitle);
        demand.setDemandType(demandType);
        String entId = (String)session.getAttribute("entId");
        demand.setEntId(entId);
        String result = demandService.publish(demand);
        Map<String,String> r = new HashMap<>();
        r.put("result", result);
        return r;
    }
}
