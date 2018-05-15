package com.enterprise.service;

import com.enterprise.entity.Information;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IInformationService {
    //    保存到数据库中
    public void save(@Param("info") List<Information> info);
    //    通过标题查询
    public List<Information> queryByTitle(String title);
    //    通过资讯的时间查询
    public List<Information> queryByDate(String date);
    List<Information> getAll();
}
