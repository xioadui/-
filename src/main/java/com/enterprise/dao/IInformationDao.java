package com.enterprise.dao;

import com.enterprise.entity.Information;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IInformationDao {
//    保存到数据库中
    public void save(@Param("info") List<Information> info);
//    通过标题查询  index是从什么位置开始 length是要查询数据的长度
    public List<Information> queryByTitle(@Param("title")String title);
//    通过资讯的时间查询
    public List<Information> queryByDate(@Param("date")String date ,
                                         @Param("index")long index,
                                         @Param("length")int length);
//    通过行业进行查询
    public List<Information> queryByType(@Param("type")String type,
                                         @Param("index")long index,
                                         @Param("length")int length);
}
