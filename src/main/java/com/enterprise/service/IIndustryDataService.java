package com.enterprise.service;

import com.enterprise.entity.IndustryData;

import java.util.List;

/**
 * 定义行业数据相关的操作
 */
public interface IIndustryDataService {
    //    保存到数据库中
    void save(List<IndustryData> info);
    //    通过标题查询  index是从什么位置开始 length是要查询数据的长度
    List<IndustryData> queryByTitle(String title, long index, int length);
    //    通过资讯的时间查询
    List<IndustryData> queryByDate(String date, long index, int length);
    //    通过行业进行查询
    List<IndustryData> queryByType(String type, long index, int length);
    //    进行模糊查询行业数据
    List<IndustryData> searchIndustryData(String condition, long index, int length);
}
