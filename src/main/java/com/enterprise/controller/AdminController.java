package com.enterprise.controller;

import com.enterprise.entity.Demand;
import com.enterprise.entity.Enterprise;
import com.enterprise.entity.Provide;
import com.enterprise.service.serviceImpl.AdminServiceImpl;
import org.junit.Test;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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
        List<Object> ents = new ArrayList<>();
        for(int i=0; i<entList.size(); i++){
            Enterprise ent = entList.get(i);
            Map<Object, Object> entMap = new HashMap<>();
            entMap.put("entId", ent.getEntId());
            entMap.put("entDate", ent.getEntDate());
            entMap.put("entWebsize", ent.getEntWebsize());
            entMap.put("entIdentity", ent.getEntIdentity());
            entMap.put("entPhone", ent.getEntPhone());
            entMap.put("entSize", ent.getEntSize());
            entMap.put("entAddress", ent.getEntAddress());
            entMap.put("entIntroduction", ent.getEntIntroduction());
            entMap.put("entBrief", ent.getEntBrief());
            entMap.put("entCategory", ent.getEntCategory());
            entMap.put("entPerson", ent.getEntPerson());
            entMap.put("entName", ent.getEntName());
            ents.add(entMap);
        }
        resultMap.put("ent", ents);
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
    public Map<Object,Object> demand_admin(@RequestParam("index")long index,@RequestParam("length") int length){
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
    public Map<Object,Object> provide_admin(@RequestParam("index")long index,@RequestParam("length") int length){
        resultMap = new HashMap<>();
        List<Object> pros = new ArrayList<>();
        List<Provide> proList = adminService._provide_admin(index, length);
        for(int i=0; i<proList.size(); i++){
            Provide pro = proList.get(i);
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
        List<Object> ents = new ArrayList<>();
        for(int i=0; i<entList.size(); i++){
            Enterprise ent = entList.get(i);
            Map<Object, Object> entMap = new HashMap<>();
            entMap.put("entId", ent.getEntId());
            entMap.put("entDate", ent.getEntDate());
            entMap.put("entWebsize", ent.getEntWebsize());
            entMap.put("entIdentity", ent.getEntIdentity());
            entMap.put("entPhone", ent.getEntPhone());
            entMap.put("entSize", ent.getEntSize());
            entMap.put("entAddress", ent.getEntAddress());
            entMap.put("entIntroduction", ent.getEntIntroduction());
            entMap.put("entBrief", ent.getEntBrief());
            entMap.put("entCategory", ent.getEntCategory());
            entMap.put("entPerson", ent.getEntPerson());
            entMap.put("entName", ent.getEntName());
            ents.add(entMap);
        }
        resultMap.put("ent", ents);
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
    public Map<Object,Object> demand(@RequestParam("index")long index,@RequestParam("length") int length){
        resultMap = new HashMap<>();
        List<Object> demands = new ArrayList<>();
        List<Demand> demandList = adminService._demand(index, length);
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
     * 用于管理员展示供应数据的
     * @param index 起始索引
     * @param length 供应数据条数
     * @return 返回供应数据的结果集
     */
    @RequestMapping(value = "/provide")
    @ResponseBody
    public Map<Object,Object> provide(@RequestParam("index")long index,@RequestParam("length") int length){
        resultMap = new HashMap<>();
        List<Object> pros = new ArrayList<>();
        List<Provide> proList = adminService._provide(index, length);
        for(int i=0; i<proList.size(); i++){
            Provide pro = proList.get(i);
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
     * 用于管理员通过企业注册的
     * @param entId 企业
     * @return 返回需求数据的结果集
     */
    @RequestMapping(value = "/agreeRegister")
    @ResponseBody
    public Map<Object,Object> agreeRegister(String entId){
        resultMap = new HashMap<>();
        String result = adminService._agreeRegister(entId);
        resultMap.put("result", result);
        return resultMap;
    }

    /**
     * 用于管理员通过需求的
     * @param demandId 需求Id
     * @return 返回结果
     */
    @RequestMapping(value = "/agreeDemand")
    @ResponseBody
    public Map<Object,Object> agreeDemand(int demandId){
        resultMap = new HashMap<>();
        String result = adminService._agreeDemand(demandId);
        resultMap.put("result", result);
        return resultMap;
    }

    /**
     * 用于管理员通过供应的
     * @param proId 供应Id
     * @return 返回结果
     */
    @RequestMapping(value = "/agreeProvide")
    @ResponseBody
    public Map<Object,Object> agreeProvide(int proId){
        resultMap = new HashMap<>();
        String result = adminService._agreeProvide(proId);
        resultMap.put("result", result);
        return resultMap;
    }

    /**
     * 用于管理员删除企业注册的
     * @param entId 企业Id
     * @return 返回结果
     */
    @RequestMapping(value = "/deleteRegister")
    @ResponseBody
    public Map<Object,Object> deleteRegister(String entId){
        resultMap = new HashMap<>();
        String result = adminService._deleteRegister(entId);
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

    /**
     * 用于管理员删除需求的
     * @param demandId 需求Id
     * @return 返回结果
     */
    @RequestMapping(value = "/deleteDemand")
    @ResponseBody
    public Map<Object,Object> deleteDemand(int demandId){
        resultMap = new HashMap<>();
        String result = adminService._deleteDemand(demandId);
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

    /**
     * 用于管理员删除供应的
     * @param proId 供应Id
     * @return 返回结果
     */
    @RequestMapping(value = "/deleteProvide")
    @ResponseBody
    public Map<Object,Object> deleteProvide(int proId){
        resultMap = new HashMap<>();
        String result = adminService._deleteProvide(proId);
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
