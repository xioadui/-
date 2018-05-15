package com.enterprise.service;

import com.enterprise.entity.Infomation;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IInfomationService {
    //    保存到数据库中
    public void save(@Param("info") List<Infomation> info);
    //    通过标题查询
    public List<Infomation> queryByTitle(String title);
    //    通过资讯的时间查询
    public List<Infomation> queryByDate(String date);
}
