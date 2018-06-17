package com.enterprise.controller;

import com.enterprise.entity.Information;
import com.enterprise.service.serviceImpl.InformationServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * 处理行业信息控制器
 */
@Controller
@RequestMapping(value = "/inf")
public class InformationController {
    @Resource
    private InformationServiceImpl informationService;

    /**
     * 通过行业类型或者标题来进行查找内容
     * @param condition 查询的条件
     * @param index 起始的索引
     * @param length 行业信息的条数
     * @return 查询到结果集
     */
    @ResponseBody
    @RequestMapping(value = "/searchInformation")
    public Map<String, Object> searchInformation(@RequestParam("condition") String condition,long index,int length) {
        Map<String, Object> resultMap = new HashMap<>();
        List<Object> infs = new ArrayList<>();
        condition = "%"+condition+"%";
        List<Information> infList = informationService.searchInformation(condition, index, length);
        for(int i=0; i<infList.size(); i++){
            Information inf = infList.get(i);
            Map<String, String> infMap = new HashMap<String, String>();
            infMap.put("content", inf.getContent());
            infMap.put("date", inf.getDate());
            infMap.put("digest", inf.getDigest());
            infMap.put("title", inf.getTitle());
            infs.add(infMap);
        }
        resultMap.put("inf", infs);
        return resultMap;
    }



    /**
     * 在主页显示行业资讯
     * @param category
     * @return
     */
    @RequestMapping(value = "/index")
    @ResponseBody
    public Map<String,String> getInIndex(@RequestParam("category") String category){
        List<Information> infList = informationService.queryByType(category, 0, 1);
        Information inf = infList.get(0);
        Map<String, String> infMap = new HashMap<>();
        infMap.put("digest", inf.getDigest());
        infMap.put("title", inf.getTitle());
        return infMap;
    }

}
