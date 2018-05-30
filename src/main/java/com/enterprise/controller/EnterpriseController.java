package com.enterprise.controller;

import com.enterprise.entity.Enterprise;
import com.enterprise.service.serviceImpl.EnterpriseServiceImpl;
import org.apache.commons.collections.map.HashedMap;
import org.apache.ibatis.mapping.ResultMap;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Controller
public class EnterpriseController {
    @Resource
    private EnterpriseServiceImpl enterpriseService;
    @RequestMapping(value="/registerForm")
    @ResponseBody
    public Model registerForm(Model model){
        return null;
    }

    @RequestMapping(value="/register",method = RequestMethod.POST)
    @ResponseBody
<<<<<<< HEAD
    public String register(Enterprise enterprise){
        enterprise.setEntIdentity(0);
        enterprise.setEntDate("2014-12-12");
=======
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
>>>>>>> cd130bef067f10406e8905f1dd4004f5ddbe81a6
        String result = enterpriseService.register(enterprise);
        return "success";

    }
    @RequestMapping(value="/loginHandler",method = RequestMethod.POST)
    @ResponseBody
    public String login(String entId,String entPassword){
        Enterprise enterprise = enterpriseService.login(entId,entPassword);
        if(enterprise==null)
            return "error";
        return "success";
    }


    @RequestMapping(value="/login",method = RequestMethod.GET)
    @ResponseBody
    public Model loginForm(Model model){
        return null;
    }
}
