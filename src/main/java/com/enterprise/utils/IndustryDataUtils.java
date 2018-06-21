package com.enterprise.utils;

import com.enterprise.entity.IndustryData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IndustryDataUtils {
    public static Map<String,Object> parseIndustryDataToMap(IndustryData industryData){
        Map<String, Object> indMap = new HashMap<>();
        indMap.put("id", industryData.getId());
        indMap.put("type", industryData.getType());
        indMap.put("content", industryData.getContent());
        indMap.put("date", industryData.getDate());
        indMap.put("digest", industryData.getDigest());
        indMap.put("title", industryData.getTitle());
        return indMap;
    }

    public static List<Map<String,Object>> parseIndustryListToMapList(List<IndustryData> industryData){
        List<Map<String, Object>> ind = new ArrayList<>();
        for(IndustryData inf:industryData) {
            ind.add(parseIndustryDataToMap(inf));
        }
        return ind;
    }
}
