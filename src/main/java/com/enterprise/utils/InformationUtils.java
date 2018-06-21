package com.enterprise.utils;

import com.enterprise.entity.Information;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InformationUtils {
    public static Map<String,Object> parseInformationToMap(Information inf){
        Map<String, Object> infMap = new HashMap<>();
        infMap.put("id", inf.getId());
        infMap.put("content", inf.getContent());
        infMap.put("date", inf.getDate());
        infMap.put("digest", inf.getDigest());
        infMap.put("title", inf.getTitle());
        infMap.put("type", inf.getType());
        return infMap;
    }
    public static List<Map<String,Object>> parseListToMapList(List<Information> informations){
        List<Map<String,Object>> infs = new ArrayList<>();
        for(Information inf:informations){
            infs.add(parseInformationToMap(inf));
        }
        return infs;
    }
}
