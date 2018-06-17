package com.enterprise.dao;

import com.enterprise.entity.Information;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IInformationDao {
//    保存到数据库中
    void save(@Param("info") List<Information> info);
//    通过标题查询  index是从什么位置开始 length是要查询数据的长度
    List<Information> queryByTitle(@Param("title")String title);
//    通过资讯的时间查询
    List<Information> queryByDate(@Param("date")String date ,
                                         @Param("index")long index,
                                         @Param("length")int length);
//    通过行业进行查询
    List<Information> queryByType(@Param("type")String type,
                                         @Param("index")long index,
                                         @Param("length")int length);
    /**
     * 通过指定的条件进行模糊查询
     * @param condition 查询的条件
     * @param index 起始的索引
     * @param length 要获取查询结果的数目
     * @return 返回查询的结果集
     */
    List<Information> searchInformation(@Param("condition")String condition,
                                               @Param("index")long index,
                                               @Param("length")int length);
}
