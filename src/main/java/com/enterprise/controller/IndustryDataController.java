package com.enterprise.controller;

import com.enterprise.entity.IndustryData;
import com.enterprise.service.serviceImpl.IndustryDataServiceImpl;
import com.enterprise.utils.IndustryDataUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
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
    public Map<String,Object> getInIndex(@RequestParam("category") String category){
        List<IndustryData> infList = industryDataService.queryByType(category, 0, 1);
        Map<String, Object> infMap = new HashMap<>();
        if(infList.size()>0){
            IndustryData inf = infList.get(0);
            infMap.put("digest", inf.getDigest());
            infMap.put("title", inf.getTitle());
            infMap.put("id", inf.getId());
        }else {
            infMap.put("digest", "无更多数据");
            infMap.put("title", "无更多数据");
            infMap.put("id", 0);
        }
        return infMap;
    }



    /**
     * 通过标题进行查询
     * @return 返回查询到的结果集
     */
    @ResponseBody
    @RequestMapping(value = "/queryByTitle")
    public Map<String, Object> queryByTitle(@RequestParam("condition")String title,long index,int length){
        title = "%"+title +"%";
        List<IndustryData> infList = industryDataService.queryByTitle(title,index,length);
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("ind", IndustryDataUtils.parseIndustryListToMapList(infList));
        return resultMap;
    }

    /**
     * 通过行业类型进行查询
     * @return 返回查询到的结果集
     */
    @ResponseBody
    @RequestMapping(value = "/queryByType")
    public Map<String, Object> queryByType(@RequestParam("condition")String type,long index,int length){
        type = "%"+type +"%";
        List<IndustryData> infList = industryDataService.queryByType(type,index,length);
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("ind", IndustryDataUtils.parseIndustryListToMapList(infList));
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
    public Map<String, Object> searchIndustryData(@RequestParam("condition") String condition,long index,int length) {
        Map<String, Object> resultMap = new HashMap<>();
//        进行like查询
        condition = "%"+condition+"%";
        List<IndustryData> infList = industryDataService.searchIndustryData(condition, index, length);
        resultMap.put("ind", IndustryDataUtils.parseIndustryListToMapList(infList));
        return resultMap;
    }
    @ResponseBody
    @RequestMapping(value = "/queryById")
    public Map<String, Object> queryById(@RequestParam("id") long id){
        Map<String, Object> resultMap = new HashMap<>();
        List<IndustryData> infList = industryDataService.queryIndById(id);
        resultMap.put("ind", IndustryDataUtils.parseIndustryListToMapList(infList));
        return resultMap;
    }

    @ResponseBody
    @RequestMapping(value = "/getAllInd")
    public Map<String, Object> getAllInfo(long index,int length){
        Map<String, Object> resultMap = new HashMap<>();
        List<IndustryData> infList = industryDataService.getAllInd(index, length);
        resultMap.put("ind", IndustryDataUtils.parseIndustryListToMapList(infList));
        return resultMap;
    }
    @ResponseBody
    @RequestMapping(value = "/queryIndByDate")
    public Map<String, Object> queryByDate(@RequestParam("condition") String date,long index,int length) {
        Map<String, Object> resultMap = new HashMap<>();
        List<IndustryData> infList = industryDataService.queryByDate(date, index, length);
        resultMap.put("ind", IndustryDataUtils.parseIndustryListToMapList(infList));
        return resultMap;
    }

}

