package com.enterprise.controller;

import com.enterprise.entity.IndustryData;
import com.enterprise.service.serviceImpl.IndustryDataServiceImpl;
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
 * 行业数据相关的控制器
 * 完成行业数据的查询和添加操作
 */
@Controller
@RequestMapping(value = "/ind")
public class IndustryDataController {
    @Resource
    private IndustryDataServiceImpl industryDataService;


    /**
     * 用于主页展示数据的
     * @param category 要获取行业数据的行业类型
     * @return 返回一条记录
     */
    @RequestMapping(value = "/index")
    @ResponseBody
    public Map<String,String> getInIndex(@RequestParam("category") String category){
        List<IndustryData> infList = industryDataService.queryByType(category, 0, 1);
        IndustryData inf = infList.get(0);
        Map<String, String> infMap = new HashMap<>();
        infMap.put("digest", inf.getDigest());
        infMap.put("title", inf.getTitle());
        return infMap;
    }

    /**
     * 通过标题进行查询
     * @return 返回查询到的结果集
     */
    @ResponseBody
    @RequestMapping(value = "/queryByTitle")
    public Map<String, Object> queryByTitle(String title, long index, int length){
        title = "%"+title +"%";
        List<IndustryData> infList = industryDataService.queryByTitle(title,index,length);
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("inf", this.industryDataUtils(infList));
        return resultMap;
    }

    /**
     * 对行业数据进行模糊查询（综合查询），可以通过类型或者标题的部分
     * @param condition 行业类型或者标题的部分
     * @param index 起始的索引
     * @param length 要获取数的长度
     * @return 返回数据库查询的结果集
     */
    @ResponseBody
    @RequestMapping(value = "/searchIndustryData")
    public Map<String, Object> searchIndustryData(@RequestParam("condition") String condition, long index, int length) {
        Map<String, Object> resultMap = new HashMap<>();
//        进行like查询
        condition = "%"+condition+"%";
        List<IndustryData> infList = industryDataService.searchIndustryData(condition, index, length);
        resultMap.put("inf", this.industryDataUtils(infList));
        return resultMap;
    }

    /**
     * 将行业数据转换成为键值对的形式
     * @param infList 数据库查询得到的结果集
     * @return 返回转换后的结果
     */
    private List<Map<String,String>> industryDataUtils(List<IndustryData> infList){
        List<Map<String, String>> ind = new ArrayList<>();
        for(IndustryData inf:infList){
            Map<String, String> infMap = new HashMap<>();
            infMap.put("content", inf.getContent());
            infMap.put("date", inf.getDate());
            infMap.put("digest", inf.getDigest());
            infMap.put("title", inf.getTitle());
            ind.add(infMap);
        }
        return ind;
    }

}

