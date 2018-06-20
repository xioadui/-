package com.enterprise.controller;

import com.enterprise.entity.Demand;
import com.enterprise.service.serviceImpl.DemandServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping(value = "/demand")
public class DemandController {
    @Resource
    private DemandServiceImpl demandService;

    /**
     * 获取所有的需求
     * @param index 起始的索引
     * @param length 长度
     * @return 查询得到的结果集
     */
    @RequestMapping(value = "/allDemand")
    @ResponseBody
    public Map<String, List<Map<String, String>>> getAllDemand(@RequestParam("index")long index,
                                                               @RequestParam("length")int length){
        Map<String, List<Map<String, String>>> resultMap = new HashMap<>();
        List<Demand> demandList = demandService.getAllDemand(index, length);
        resultMap.put("demand", this.demandUtils(demandList));
        return resultMap;
    }

    /**
     * 获取用户自己发布的需求
     * @param session 该session用户获取用户的ID
     * @return 查询得到的结果集
     */
    @RequestMapping(value="/getEntDemand")
    @ResponseBody
    public Map<String, List<Map<String, String>>> getEntDemand(HttpSession session,
                                                               @RequestParam("index")long index,
                                                               @RequestParam("length")int length){
        String entId = (String)session.getAttribute("entId");
        Map<String, List<Map<String, String>>> resultMap = new HashMap<>();
        List<Demand> demandList = demandService.getDemandByEntId(entId,index,length);
        resultMap.put("demand", this.demandUtils(demandList));
        return resultMap;
    }

    /**
     * 发布需求
     * @param session 通过改参数来获取企业用户的ID
     * @param demandContent 需求的内容
     * @param demandDigest 需求的摘要
     * @param demandTitle 需求的标题
     * @param demandType 需求的类型
     * @return 查询得到的结果集
     */
    @RequestMapping(value="/publish")
    @ResponseBody
    public Map<String, String> publish(HttpSession session,
                                       @RequestParam("content") String demandContent,
                                       @RequestParam("digest") String demandDigest,
                                       @RequestParam("title") String demandTitle,
                                       @RequestParam("type") String demandType){
        Demand demand = new Demand();
        demand.setDemandContent(demandContent);
        Date day=new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        demand.setDemandDate(df.format(day));
        demand.setDemandDigest(demandDigest);
        demand.setDemandTitle(demandTitle);
        demand.setDemandType(demandType);
        String entId = (String)session.getAttribute("entId");
        demand.setEntId(entId);
        String result = demandService.publish(demand);
        Map<String,String> r = new HashMap<>();
        r.put("result", result);
        return r;
    }


    /**
     * 根据指定的条件进行模糊查询
     * @param condition 指定的条件
     * @param index 起始的索引
     * @param length 长度
     * @return 查询得到的结果集
     */
    @ResponseBody
    @RequestMapping(value = "search")
    public Map<String, List<Map<String, String>>> searchDemand(@RequestParam("condition") String condition,
                                                               @RequestParam("index")long index,
                                                               @RequestParam("length")int length){
        Map<String, List<Map<String, String>>> resultMap = new HashMap<>();

        condition = "%"+condition+"%";
        List<Demand> demandList = demandService.searchDemand(condition,index,length);
        resultMap.put("demand", this.demandUtils(demandList));
        return resultMap;
    }


    /**
     * 只有是该用户发布的需求才能被删除，所以需要从session中获取用户的ID
     * @param session 通过该session来获取用户的ID
     * @param demandId　要删除的需求ID
     * @return 删除操作是否成功，success
     */
    @ResponseBody
    @RequestMapping(value = "delete")
    public String delete(HttpSession session, @RequestParam("demandId") String demandId){
        String entId = (String)session.getAttribute("entId");
        return demandService.deleteByDemandId(demandId,entId);
    }

    /**
     * 负责将查询得到的结果填充到集合中
     * @param demandList　需要被转换的List
     * @return 组装后的List
     */
    private List<Map<String, String>> demandUtils(List<Demand> demandList){
        List<Map<String, String>> demands = new ArrayList<>();
        for(Demand demand:demandList){
            Map<String, String> demandMap = new HashMap<>();
            demandMap.put("demandId", demand.getDemandId()+"");
            demandMap.put("entId", demand.getEntId());
            demandMap.put("demandContent", demand.getDemandContent());
            demandMap.put("demandDate", demand.getDemandDate());
            demandMap.put("demandDigest", demand.getDemandDigest());
            demandMap.put("demandTitle", demand.getDemandTitle());
            demandMap.put("demandType", demand.getDemandType());
            demands.add(demandMap);
        }
        return demands;
    }
}
