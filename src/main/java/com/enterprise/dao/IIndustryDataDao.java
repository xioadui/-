package com.enterprise.dao;

import com.enterprise.entity.IndustryData;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IIndustryDataDao {
    //    保存到数据库中
    void save(@Param("info") List<IndustryData> info);
    //    通过标题查询  index是从什么位置开始 length是要查询数据的长度
    List<IndustryData> queryByTitle(@Param("title")String title,
                                    @Param("index")long index,
                                    @Param("length")int length);
    //    通过资讯的时间查询
    List<IndustryData> queryByDate(@Param("date")String date ,
                                         @Param("index")long index,
                                         @Param("length")int length);
    //    通过行业进行查询
    List<IndustryData> queryByType(@Param("type")String type,
                                         @Param("index")long index,
                                         @Param("length")int length);
    /**
     * 对行业数据进行模糊查询
     * @param condition 查询的条件
     * @param index 起始的索引
     * @param length 要获取的数目
     * @return 返回查询的结果集
     */
    List<IndustryData> searchIndustryData(@Param("condition") String condition,
                                        @Param("index")long index,
                                        @Param("length")int length
    );
}
