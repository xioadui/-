package com.enterprise.controller;

import com.enterprise.entity.Information;
import com.enterprise.service.serviceImpl.InformationServiceImpl;
import com.enterprise.utils.InformationUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
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

    @ResponseBody
    @RequestMapping(value = "/getAllInfo")
    public Map<String, Object> getAllInfo(long index,int length){
        Map<String, Object> resultMap = new HashMap<>();
        List<Information> infList = informationService.getAllInfo(index, length);
        resultMap.put("inf", InformationUtils.parseListToMapList(infList));
        return resultMap;
    }
    /**
     * 通过行业类型或者标题来进行查找内容
     * @param condition 查询的条件
     * @param index 起始的索引
     * @param length 行业信息的条数
     * @return 查询到结果集
     */
    @ResponseBody
    @RequestMapping(value = "/searchInformation")
    public Map<String, Object> searchInformation(@RequestParam("condition") String condition, long index, int length) {
        Map<String, Object> resultMap = new HashMap<>();
        condition = "%"+condition+"%";
        List<Information> infList = informationService.searchInformation(condition, index, length);
        resultMap.put("inf", InformationUtils.parseListToMapList(infList));
        return resultMap;
    }

    @ResponseBody
    @RequestMapping(value = "/queryByType")
    public Map<String, Object> queryByType(@RequestParam("condition") String type,long index,int length) {
        Map<String, Object> resultMap = new HashMap<>();
        type = "%"+type+"%";
        List<Information> infList = informationService.queryByType(type, index, length);
        resultMap.put("inf", InformationUtils.parseListToMapList(infList));
        return resultMap;
    }

    @ResponseBody
    @RequestMapping(value = "/queryByDate")
    public Map<String, Object> queryByDate(@RequestParam("condition") String date,long index,int length) {
        Map<String, Object> resultMap = new HashMap<>();
        List<Information> infList = informationService.queryByDate(date, index, length);
        resultMap.put("inf", InformationUtils.parseListToMapList(infList));
        return resultMap;
    }


    @ResponseBody
    @RequestMapping(value = "/queryByTitle")
    public Map<String, Object> queryByTitle(@RequestParam("condition") String title,long index,int length) {
        Map<String, Object> resultMap = new HashMap<>();
        title = "%"+title+"%";
        List<Information> infList = informationService.queryByTitle(title,index, length);
        resultMap.put("inf", InformationUtils.parseListToMapList(infList));
        return resultMap;
    }
    @ResponseBody
    @RequestMapping(value = "/queryById")
    public Map<String, Object> queryById(@RequestParam("id") long id){
        Map<String, Object> resultMap = new HashMap<>();
        List<Information> infList = informationService.queryById(id);
        resultMap.put("inf", InformationUtils.parseListToMapList(infList));
        return resultMap;
    }

    /**
     * 在主页显示行业资讯
     * @param category
     * @return 查询得到的结果
     */
    @RequestMapping(value = "/index")
    @ResponseBody
    public Map<String,Object> getInIndex(@RequestParam("category") String category){
        List<Information> infList = informationService.queryByType(category, 0, 1);
        Map<String, Object> infMap = new HashMap<>();
        if(infList.size()>0){
            Information inf = infList.get(0);
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

}
