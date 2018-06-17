package com.enterprise.controller;

import com.enterprise.entity.Enterprise;
import com.enterprise.service.serviceImpl.EnterpriseServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value="/user")
public class EnterpriseController {
    private Map<Object, Object> resultMap = new HashMap<>();
    @Resource
    private EnterpriseServiceImpl enterpriseService;
    @RequestMapping(value="/login")
    @ResponseBody
    public Map<Object, Object> login(@RequestParam("entId") String entId, @RequestParam("entPassword") String entPassword, HttpServletRequest httpServletRequest){
        Enterprise enterprise = enterpriseService.login(entId, entPassword);
        if(enterprise!=null)
        {
            HttpSession session = httpServletRequest.getSession();
            session.setAttribute("entId", entId);
            resultMap.put("login","success");
            resultMap.put("entName", enterprise.getEntName());
            resultMap.put("entPerson", enterprise.getEntPerson());
            resultMap.put("entCategory", enterprise.getEntCategory());
            resultMap.put("entBrief", enterprise.getEntBrief());
            resultMap.put("entIntroduction", enterprise.getEntIntroduction());
            resultMap.put("entAddress", enterprise.getEntAddress());
            resultMap.put("entSize", enterprise.getEntSize());
            resultMap.put("entPhone", enterprise.getEntPhone());
            resultMap.put("entPassword", enterprise.getEntPassword());
            resultMap.put("entIdentity", enterprise.getEntIdentity());
            resultMap.put("entWebsize", enterprise.getEntWebsize());
            resultMap.put("entDate", enterprise.getEntDate());
        }
        else
            resultMap.put("login", "failed");
        return resultMap;
    }


    @RequestMapping(value="/register")
    @ResponseBody
    public Map<Object, Object> register(@RequestParam("entId") String entId, @RequestParam("entName") String entName,
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

        @RequestMapping(value = "/check")
        @ResponseBody
        public Map<Object, Object> checkId(@RequestParam("entId") String entId){
            Enterprise enterprise = enterpriseService.checkId(entId);
            if(enterprise==null)
                resultMap.put("entId", "unexist");
            else
                resultMap.put("entId", "exist");
            return resultMap;
        }
}
