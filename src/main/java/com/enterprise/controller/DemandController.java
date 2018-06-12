package com.enterprise.controller;

import com.enterprise.entity.Demand;
import com.enterprise.service.serviceImpl.DemandServiceImpl;
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
@RequestMapping(value = "/demand")
public class DemandController {

    private Map<Object, Object> resultMap = new HashMap<>();

    @Resource
    DemandServiceImpl demandService;

    @RequestMapping(value = "/allDemand")
    @ResponseBody
    public Map<Object, Object> getAllDemand(){
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
    public Map<Object, Object> publish(@RequestParam("demandId") int demandId, @RequestParam("entId") String entId,
                                       @RequestParam("demandContent") String demandContent,
                                       @RequestParam("demandDate") String demandDate, @RequestParam("demandDigest") String demandDigest,
                                       @RequestParam("demandTitle") String demandTitle, @RequestParam("demandType") String demandType){
        Demand demand = new Demand();
        demand.setDemandId(demandId);
        demand.setDemandContent(demandContent);
        demand.setDemandDate(demandDate);
        demand.setDemandDigest(demandDigest);
        demand.setDemandTitle(demandTitle);
        demand.setDemandType(demandType);
        demand.setEntId(entId);
        String result = demandService.publish(demand);
        resultMap.put("result", result);
        return resultMap;
    }
}
