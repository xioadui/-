package com.enterprise.utils;

import com.enterprise.entity.Enterprise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EnterpriseUtils {
    /**
     * 将Enterprise对象转换为Map
     * @param enterprise
     * @return
     */
    public static Map<String,Object> parseEntToMap(Enterprise enterprise){
        Map<String,Object> enterpriseMap = new HashMap<>();
        enterpriseMap.put("entId",enterprise.getEntId());
        enterpriseMap.put("entName", enterprise.getEntName());
        enterpriseMap.put("entName", enterprise.getEntName());
        enterpriseMap.put("entPerson", enterprise.getEntPerson());
        enterpriseMap.put("entCategory", enterprise.getEntCategory());
        enterpriseMap.put("entBrief", enterprise.getEntBrief());
        enterpriseMap.put("entIntroduction", enterprise.getEntIntroduction());
        enterpriseMap.put("entAddress", enterprise.getEntAddress());
        enterpriseMap.put("entSize", enterprise.getEntSize());
        enterpriseMap.put("entPhone", enterprise.getEntPhone());
        enterpriseMap.put("entPassword", enterprise.getEntPassword());
        enterpriseMap.put("entIdentity", enterprise.getEntIdentity());
        enterpriseMap.put("entWebsize", enterprise.getEntWebsize());
        enterpriseMap.put("entDate", enterprise.getEntDate());
        return enterpriseMap;
    }

    public static List<Map<String,Object>> parseEntListToMapList(List<Enterprise> enterpriseList){
        List<Map<String,Object>> res = new ArrayList<Map<String,Object>>();
        for(Enterprise e:enterpriseList){
            res.add(parseEntToMap(e));
        }
        return res;
    }
}
