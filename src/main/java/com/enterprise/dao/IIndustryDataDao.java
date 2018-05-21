package com.enterprise.dao;

import com.enterprise.entity.IndustryData;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IIndustryDataDao {
    //    保存到数据库中
    public void save(@Param("info") List<IndustryData> info);
    //    通过标题查询  index是从什么位置开始 length是要查询数据的长度
    public List<IndustryData> queryByTitle(@Param("title")String title);
    //    通过资讯的时间查询
    public List<IndustryData> queryByDate(@Param("date")String date ,
                                         @Param("index")long index,
                                         @Param("length")int length);
    //    通过行业进行查询
    public List<IndustryData> queryByType(@Param("type")String type,
                                         @Param("index")long index,
                                         @Param("length")int length);
}
