package com.enterprise.controller;

import com.enterprise.entity.Enterprise;
import com.enterprise.service.serviceImpl.EnterpriseServiceImpl;
import org.apache.commons.collections.map.HashedMap;
import org.apache.ibatis.mapping.ResultMap;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/enterprise")
public class EnterpriseController {

    private Map<String, String> resultMap = new HashMap<String, String>();

    @Resource
    private EnterpriseServiceImpl enterpriseService;

    @RequestMapping(value="/register")
    @ResponseBody
    public Map<String, String> register(@RequestParam("entId") String entId, @RequestParam("entName") String entName,
                                        @RequestParam("entPerson") String entPerson, @RequestParam("entCategory") String entCategory,
                                        @RequestParam("entBrief") String entBrief, @RequestParam("entIntroduction") String entIntroduction,
                                        @RequestParam("entAddress") String entAddress, @RequestParam("entSize") String entSize,
                                        @RequestParam("entPhone") String entPhone, @RequestParam("entPassword") String entPassword,
                                        @RequestParam("entIdentity") int entIdentity, @RequestParam("entWebsize") String entWebsize,
                                        @RequestParam("entDate") String entDate){
        Enterprise enterprise = new Enterprise();
        enterprise.setEntId(entId);
        enterprise.setEntName(entName);
        enterprise.setEntPerson(entPerson);
        enterprise.setEntCategory(entCategory);
        enterprise.setEntBrief(entBrief);
        enterprise.setEntIntroduction(entIntroduction);
        enterprise.setEntAddress(entAddress);
        enterprise.setEntSize(entSize);
        enterprise.setEntPhone(entPhone);
        enterprise.setEntPassword(entPassword);
        enterprise.setEntIdentity(entIdentity);
        enterprise.setEntWebsize(entWebsize);
        enterprise.setEntDate(entDate);
        String result = enterpriseService.register(enterprise);
        resultMap.put("register", result);
        return resultMap;
    }


}
