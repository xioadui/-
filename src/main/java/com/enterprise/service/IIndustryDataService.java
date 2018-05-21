package com.enterprise.service;

import com.enterprise.entity.IndustryData;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IIndustryDataService {
    //    保存到数据库中
    public void save(List<IndustryData> info);
    //    通过标题查询  index是从什么位置开始 length是要查询数据的长度
    public List<IndustryData> queryByTitle(String title);
    //    通过资讯的时间查询
    public List<IndustryData> queryByDate(String date ,
                                         long index,
                                         int length);
    //    通过行业进行查询
    public List<IndustryData> queryByType(String type,
                                          long index,
                                          int length);
}
