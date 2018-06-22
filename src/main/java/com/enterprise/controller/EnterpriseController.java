package com.enterprise.controller;

import com.enterprise.entity.Enterprise;
import com.enterprise.service.serviceImpl.EnterpriseServiceImpl;
import com.enterprise.service.serviceImpl.MailServiceImpl;
import com.enterprise.utils.EnterpriseUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

    /**
     * 登录
     * @param entId 用户的ID
     * @param entPassword 用户的密码
     * @param httpServletRequest 用来获取JSON
     * @return 成功返回用户的信息
     */
    @RequestMapping(value="/login")
    @ResponseBody
    public Map<Object, Object> login(@RequestParam("entId") String entId, @RequestParam("entPassword") String entPassword, HttpServletRequest httpServletRequest){
        if(entId.equals("admin") && entPassword.equals("admin")){
            resultMap.put("login","admin");
            HttpSession session = httpServletRequest.getSession();
            session.setAttribute("entId", entId);
            return resultMap;
        }
        Enterprise enterprise = enterpriseService.login(entId, entPassword);
        if(enterprise!=null) {
            HttpSession session = httpServletRequest.getSession();
            session.setAttribute("entId", entId);
            resultMap.put("result",EnterpriseUtils.parseEntToMap(enterprise));
            resultMap.put("login","success");
        }
        else
            resultMap.put("login", "failed");
        return resultMap;
    }


    /**
     * 注册
     * @return 返回注册是否成功
     */
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
        resultMap.put("login","success");
        return resultMap;
        }

    /**
     * 检测用户是否已经注册
     * @param entId 需要检测的ID
     * @return 返回是否注册的标志
     */
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

    /**
     * @param condition 企业的名称、类型、简介进行模糊查询
     * @param index 起始的索引
     * @param length 要获取的数据长度
     * @return 返回查询的结果集
     */
    @RequestMapping(method = RequestMethod.POST,value = "/searchEnt")
    @ResponseBody
    public Map<String, Object> searchEnt(@Param("condition") String condition,
                                          @Param("index")String index,
                                          @Param("length")int length){
        Map<String, Object> result = new HashMap<>();
        condition = "%"+condition+"%";
        result.put("result",EnterpriseUtils.parseEntListToMapList(enterpriseService.searchInt(condition, Long.parseLong(index), length)));
        return result;
    }
    @RequestMapping(value = "/queryEntById")
    @ResponseBody
    public Map<Object, Object> queryEntById(@Param("entId")String id){
        return null;

    }
    @RequestMapping(value = "/getAllEnt")
    @ResponseBody
    public Map<Object, Object> getAllEnt(@Param("index")long index,@Param("length")int length){
        return null;
    }

}
