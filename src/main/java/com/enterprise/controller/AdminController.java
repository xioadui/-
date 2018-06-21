package com.enterprise.controller;

import com.enterprise.entity.Demand;
import com.enterprise.entity.Enterprise;
import com.enterprise.entity.Provide;
import com.enterprise.service.crawler.ParseStrategyIndustryData;
import com.enterprise.service.serviceImpl.AdminServiceImpl;
import com.enterprise.service.serviceImpl.MailServiceImpl;
import com.enterprise.utils.DemandUtils;
import com.enterprise.utils.EnterpriseUtils;
import com.enterprise.utils.ProvideUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {

    private Map<Object, Object> resultMap;
    @Resource
    private AdminServiceImpl adminService;
    @Resource
    private MailServiceImpl mailService;
    /**
     * 用于管理员展示企业待审核注册数据的
     * @param index 起始索引
     * @param length 企业待审核注册数据条数
     * @return 返回企业待审核注册数据的结果集
     */
    @RequestMapping(value = "/register_admin")
    @ResponseBody
    public Map<Object,Object> register_admin(@RequestParam("index")long index, @RequestParam("length") int length){
        resultMap = new HashMap<>();
        List<Enterprise> entList = adminService._register_admin(index, length);
        resultMap.put("ent", EnterpriseUtils.parseEntListToMapList(entList));
        return resultMap;
    }

    /**
     * 用于管理员展示待审核需求数据的
     * @param index 起始索引
     * @param length 待审核需求数据条数
     * @return 返回待审核需求数据的结果集
     */
    @RequestMapping(value = "/demand_admin")
    @ResponseBody
    public Map<Object,Object> demand_admin(@RequestParam("index")long index, @RequestParam("length") int length){
        resultMap = new HashMap<>();
        List<Object> demands = new ArrayList<>();
        List<Demand> demandList = adminService._demand_admin(index, length);
        for(int i=0; i<demandList.size(); i++){
            Demand demand = demandList.get(i);
            Map<Object, Object> demandMap = new HashMap<>();
            demandMap.put("demandId", demand.getDemandId());
            demandMap.put("entId", demand.getEntId());
            demandMap.put("demandType", demand.getDemandType());
            demandMap.put("demandTitle", demand.getDemandTitle());
            demandMap.put("demandDigest", demand.getDemandDigest());
            demandMap.put("demandDate", demand.getDemandDate());
            demandMap.put("demandContent", demand.getDemandContent());
            demands.add(demandMap);
        }
        resultMap.put("demand", demands);
        return resultMap;
    }

    /**
     * 用于管理员展示待审核供应数据的
     * @param index 起始索引
     * @param length 待审核供应数据条数
     * @return 返回待审核供应数据的结果集
     */
    @RequestMapping(value = "/provide_admin")
    @ResponseBody
    public Map<Object,Object> provide_admin(@RequestParam("index")long index, @RequestParam("length") int length){
        resultMap = new HashMap<>();
        List<Object> pros = new ArrayList<>();
        List<Provide> proList = adminService._provide_admin(index, length);
        for(Provide pro:proList){
            Map<Object, Object> proMap = new HashMap<>();
            proMap.put("proId", pro.getProId());
            proMap.put("entId", pro.getEntId());
            proMap.put("proType", pro.getProType());
            proMap.put("proTitle", pro.getProTitle());
            proMap.put("proDigest", pro.getProDigest());
            proMap.put("proDate", pro.getProDate());
            proMap.put("proContent", pro.getProContent());
            pros.add(proMap);
        }
        resultMap.put("pro", pros);
        return resultMap;
    }

    /**
     * 用于管理员展示企业注册数据的
     * @param index 起始索引
     * @param length 企业注册数据条数
     * @return 返回企业注册数据的结果集
     */
    @RequestMapping(value = "/register")
    @ResponseBody
    public Map<Object,Object> register(@RequestParam("index")long index, @RequestParam("length") int length){
        resultMap = new HashMap<>();
        List<Enterprise> entList = adminService._register(index, length);
        resultMap.put("ent", EnterpriseUtils.parseEntListToMapList(entList));
        return resultMap;
    }
    /**
     * 用于管理员通过企业注册的
     * @param entId 企业
     * @return 返回需求数据的结果集
     */
    @RequestMapping(value = "/agreeRegister")
    @ResponseBody
    public Map<Object,Object> agreeRegister(@RequestParam("entId") String entId, @RequestParam("reason") String reason){
        mailService.sendEmail(entId,reason,"注册审核结果");
        resultMap = new HashMap<>();
        String result = adminService._agreeRegister(entId);
        resultMap.put("result", result);
        return resultMap;
    }
    /**
     * 用于管理员删除企业注册的，用户管理员审核不通过时
     * @param entId 企业Id
     * @return 返回结果
     */
    @RequestMapping(value = "/deleteRegister")
    @ResponseBody
    public Map<Object,Object> deleteRegister(@RequestParam("entId")String entId,@RequestParam("reason")String reason){
        mailService.sendEmail(entId,reason,"注册审核结果");
        resultMap = new HashMap<>();
        String result = adminService._deleteRegister(entId);
        resultMap.put("result", result);
        return resultMap;
    }
    /**
     * 用于管理员展示需求数据的
     * @param index 起始索引
     * @param length 需求数据条数
     * @return 返回需求数据的结果集
     */
    @RequestMapping(value = "/demand")
    @ResponseBody
    public Map<Object,Object> demand(@RequestParam("index")long index, @RequestParam("length") int length){
        resultMap = new HashMap<>();
        List<Demand> demandList = adminService._demand(index, length);
        resultMap.put("demand", DemandUtils.parseDemandListToMapList(demandList));
        return resultMap;
    }

    /**
     * 用于管理员展示供应数据的
     * @param index 起始索引
     * @param length 供应数据条数
     * @return 返回供应数据的结果集
     */
    @RequestMapping(value = "/provide")
    @ResponseBody
    public Map<Object,Object> provide(@RequestParam("index")long index, @RequestParam("length") int length){
        resultMap = new HashMap<>();
        List<Provide> proList = adminService._provide(index, length);
        resultMap.put("pro", ProvideUtils.parseProvideListToMapList(proList));
        return resultMap;
    }

    /**
     * 用于管理员通过需求的
     * @param demandId 需求Id
     * @return 返回结果
     */
    @RequestMapping(method = RequestMethod.POST,value = "/agreeDemand")
    @ResponseBody
    public Map<Object,Object> agreeDemand(@RequestParam("demandId") String demandId,@RequestParam("entId") String entId,@RequestParam("reason")String reason){
        mailService.sendEmail(entId,reason,"需求审核结果");
        resultMap = new HashMap<>();
        String result = adminService._agreeDemand(Integer.parseInt(demandId));
        resultMap.put("result", result);
        return resultMap;
    }

    /**
     * 用于管理员删除需求的，也就是被管理员驳回的需求
     * @param demandId 需求Id
     * @return 返回结果
     */
    @RequestMapping(method = RequestMethod.POST,value = "/deleteDemand")
    @ResponseBody
    public Map<Object,Object> deleteDemand(@RequestParam("demandId") String demandId,@RequestParam("entId") String entId,@RequestParam("reason")String reason){
        resultMap = new HashMap<>();
        mailService.sendEmail(entId,reason,"需求审核结果");
        String result = adminService._deleteDemand(Integer.parseInt(demandId));
        resultMap.put("result", result);
        return resultMap;
    }

    /**
     * 用于管理员对供应进行审核的
     * @param proId 供应Id
     * @return 返回结果
     */
    @RequestMapping(method = RequestMethod.POST ,value = "/agreeProvide")
    @ResponseBody
    public Map<Object,Object> agreeProvide(@RequestParam("proId") String proId,@RequestParam("entId")String entId,@RequestParam("reason")String reason){
        mailService.sendEmail(entId,reason,"供应审核结果");
        resultMap = new HashMap<>();
        String result = adminService._agreeProvide(Integer.parseInt(proId));
        resultMap.put("result", result);
        return resultMap;
    }

    /**
     * 用于管理员删除供应的，也就是审核供应不通过的
     * @param proId 供应Id
     * @return 返回结果
     */
    @RequestMapping(method = RequestMethod.POST,value = "/deleteProvide")
    @ResponseBody
    public Map<Object,Object> deleteProvide(@RequestParam("proId") String proId,@RequestParam("entId")String entId,@RequestParam("reason")String reason){
        mailService.sendEmail(entId,reason,"供应审核结果");
        resultMap = new HashMap<>();
        String result = adminService._deleteProvide(Integer.parseInt(proId));
        resultMap.put("result", result);
        return resultMap;
    }


    @RequestMapping(value = "/deleteEnt")
    @ResponseBody
    public Map<Object,Object> deleteEnt(String entId){
        resultMap = new HashMap<>();
        String result = adminService._deleteEnt(entId);
        resultMap.put("result", result);
        return resultMap;
    }


    @RequestMapping(value = "/deleteDemandAgree")
    @ResponseBody
    public Map<Object,Object> deleteDemandAgree(int demandId){
        resultMap = new HashMap<>();
        String result = adminService._deleteDemandAgree(demandId);
        resultMap.put("result", result);
        return resultMap;
    }


    @RequestMapping(value = "/deleteProvideAgree")
    @ResponseBody
    public Map<Object,Object> deleteProvideAgree(int proId){
        resultMap = new HashMap<>();
        String result = adminService._deleteProvideAgree(proId);
        resultMap.put("result", result);
        return resultMap;
    }

    @RequestMapping(value = "/registerSum")
    @ResponseBody
    public Map<Object, Object> registerSum(){
        resultMap = new HashMap<>();
        int result = adminService._registerSum();
        resultMap.put("result", result);
        return resultMap;
    }

    @RequestMapping(value = "/demandSum")
    @ResponseBody
    public Map<Object, Object> demandSum(){
        resultMap = new HashMap<>();
        int result = adminService._demandSum();
        resultMap.put("result", result);
        return resultMap;
    }

    @RequestMapping(value = "/proSum")
    @ResponseBody
    public Map<Object, Object> proSum(){
        resultMap = new HashMap<>();
        int result = adminService._proSum();
        resultMap.put("result", result);
        return resultMap;
    }

    @RequestMapping(value = "/entSum")
    @ResponseBody
    public Map<Object, Object> entSum(){
        resultMap = new HashMap<>();
        int result = adminService._entSum();
        resultMap.put("result", result);
        return resultMap;
    }

    @RequestMapping(value = "/agreeDemandSum")
    @ResponseBody
    public Map<Object, Object> agreeDemandSum(){
        resultMap = new HashMap<>();
        int result = adminService._agreeDemandSum();
        resultMap.put("result", result);
        return resultMap;
    }

    @RequestMapping(value = "/agreeProSum")
    @ResponseBody
    public Map<Object, Object> agreeProSum(){
        resultMap = new HashMap<>();
        int result = adminService._agreeProSum();
        resultMap.put("result", result);
        return resultMap;
    }

    @RequestMapping(value="/registerContent")
    @ResponseBody
    public Enterprise registerContent(@RequestParam("entId") String entId){
        Enterprise enterprise = adminService._registerContent(entId);
        return enterprise;
    }

    @RequestMapping(value="/demandContent")
    @ResponseBody
    public Demand demandContent(@RequestParam("demandId") int demandId){
        Demand demand = adminService._demandContent(demandId);
        return demand;
    }

    @RequestMapping(value="/proContent")
    @ResponseBody
    public Provide proContent(@RequestParam("proId") int proId){
        Provide provide = adminService._proContent(proId);
        return provide;
    }

    @RequestMapping(value="/demandContentAgree")
    @ResponseBody
    public Demand demandContentAgree(@RequestParam("demandId") int demandId){
        Demand demandAgree = adminService._demandContentAgree(demandId);
        return demandAgree;
    }

    @RequestMapping(value="/proContentAgree")
    @ResponseBody
    public Provide proContentAgree(@RequestParam("proId") int proId){
        Provide provideAgree = adminService._proContentAgree(proId);
        return provideAgree;
    }
}
