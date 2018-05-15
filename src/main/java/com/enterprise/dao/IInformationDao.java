package com.enterprise.dao;

import com.enterprise.entity.Information;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IInformationDao {
//    保存到数据库中
    public void save(@Param("info") List<Information> info);
//    通过标题查询
    public List<Information> queryByTitle(String title);
//    通过资讯的时间查询
    public List<Information> queryByDate(String date);
    //获取所有资讯
    List<Information> getAll();
}
