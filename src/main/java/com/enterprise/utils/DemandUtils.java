package com.enterprise.utils;

import com.enterprise.entity.Demand;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DemandUtils {
    /**
     * 将Demand转换为Map
     * @param demand 需要转换的对象
     * @return 返回转换后的Map
     */
    public static Map<String,Object>parseDemandToMap(Demand demand){
        Map<String, Object> demandMap = new HashMap<>();
        demandMap.put("demandId", demand.getDemandId());
        demandMap.put("entId", demand.getEntId());
        demandMap.put("demandContent", demand.getDemandContent());
        demandMap.put("demandDate", demand.getDemandDate());
        demandMap.put("demandDigest", demand.getDemandDigest());
        demandMap.put("demandTitle", demand.getDemandTitle());
        demandMap.put("demandType", demand.getDemandType());
        return demandMap;
    }

    public static List<Map<String,Object>> parseDemandListToMapList(List<Demand> demands){
        List<Map<String,Object>> resultList = new ArrayList<>();
        for(Demand demand:demands){
            resultList.add(parseDemandToMap(demand));
        }
        return resultList;
    }
}
