package com.enterprise.controller;

import com.enterprise.entity.Provide;
import com.enterprise.service.serviceImpl.ProvideServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping(value = "/provide")
public class ProvideController {
    @Resource
    private ProvideServiceImpl provideService;
    @RequestMapping(value = "/getAllPro")
    @ResponseBody
    public Map<String, Object> getAllPro(@RequestParam("index") long index,@RequestParam("length") int length){
        Map<String, Object> resultMap = new HashMap<>();
        List<Provide> proList = provideService.getAllPro(index, length);
        resultMap.put("pro", providerUtils(proList));
        return resultMap;
    }

    /**
     * 通过给定的条件，对供应进行查询
     * @param condition 指定的条件
     * @param index 起始的索引
     * @param length 要获取的数目
     * @return 查询到的结果集
     */
    @RequestMapping(value = "/search")
    @ResponseBody
    public Map<String, Object> searchPro(@RequestParam("condition")String condition,
                                         @RequestParam("index")long index,
                                         @RequestParam("length")int length){
        Map<String, Object> resultMap = new HashMap<>();
        List<Provide> proList = provideService.searchPro(condition, index, length);
        resultMap.put("pro", providerUtils(proList));
        return resultMap;
    }

    /**
     * 通过企业用户的ID来查询该用户发布的供应信息
     * @param session 通过session来获取用户的ID
     * @param index 起始的索引
     * @param length 要获取供应的数目
     * @return 返回查询得到的结果集
     */
    @RequestMapping(value = "/getByEntId")
    @ResponseBody
    public Map<String, Object> queryByEntId(HttpSession session,
                                         @RequestParam("index")long index,
                                         @RequestParam("length")int length){
        String entId = (String)session.getAttribute("entId");
        Map<String, Object> resultMap = new HashMap<>();
        List<Provide> proList = provideService.getProByEntId(entId, index, length);
        resultMap.put("pro", providerUtils(proList));
        return resultMap;
    }

    /**
     * 企业用户发布供应
     * @param session 通过session获取用户的ID
     * @param demandContent 供应的内容
     * @param demandDigest 供应的摘要
     * @param demandTitle 供应的标题
     * @param demandType 供应的类型
     * @return 发布供应的结果
     */
    @RequestMapping(value="/publish")
    @ResponseBody
    public Map<String,String> publish(HttpSession session,
                                       @RequestParam("content") String demandContent,
                                       @RequestParam("digest") String demandDigest,
                                       @RequestParam("title") String demandTitle,
                                       @RequestParam("type") String demandType){
        Provide provide = new Provide();
        Date day=new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        provide.setProDate(df.format(day));
        String entId = (String)session.getAttribute("entId");
        provide.setEntId(entId);
        provide.setProContent(demandContent);
        provide.setProTitle(demandTitle);
        provide.setProDigest(demandDigest);
        provide.setProType(demandType);
        String result = provideService.publish(provide);
        Map<String,String> r = new HashMap<>();
        r.put("result",result);
        return r;
    }


    /**
     * 删除企业用户发布的供应
     * @param session
     * @param proId
     * @return 返回操作是否成功
     */
    public String deletePro(HttpSession session,@RequestParam("proId") int proId){
        String entId = (String)session.getAttribute("entId");
        this.provideService.deleteByproId(proId,entId);
        return "success";
    }


    /**
     * 用于将数据库查询得到的结果转换为list<Map>
     * @param proList 从数据库查询得到的列表
     * @return 返回组装的列表
     */
    private List<Map<String,Object>> providerUtils(List<Provide> proList){
        List<Map<String, Object>> pros = new ArrayList<>();
        for(Provide pro:proList){
            Map<String, Object> proMap = new HashMap<>();
            proMap.put("proId", pro.getProId());
            proMap.put("entId", pro.getEntId());
            proMap.put("proContent", pro.getProContent());
            proMap.put("proDate", pro.getProDate());
            proMap.put("proDigest", pro.getProDigest());
            proMap.put("proTitle", pro.getProTitle());
            proMap.put("proType", pro.getProType());
            pros.add(proMap);
        }
        return pros;
    }

}
