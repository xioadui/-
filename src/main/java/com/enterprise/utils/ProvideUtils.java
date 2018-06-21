package com.enterprise.utils;

import com.enterprise.entity.Provide;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProvideUtils {
    public static Map<String,Object> parseProvideToMap(Provide pro){
        Map<String, Object> proMap = new HashMap<>();
        proMap.put("proId", pro.getProId());
        proMap.put("entId", pro.getEntId());
        proMap.put("proContent", pro.getProContent());
        proMap.put("proDate", pro.getProDate());
        proMap.put("proDigest", pro.getProDigest());
        proMap.put("proTitle", pro.getProTitle());
        proMap.put("proType", pro.getProType());
        return proMap;
    }
    public static List<Map<String,Object>> parseProvideListToMapList(List<Provide> provides){
        List<Map<String,Object>> resultList = new ArrayList<>();
        for(Provide provide:provides){
            resultList.add(ProvideUtils.parseProvideToMap(provide));
        }
        return resultList;
    }
}
