package com.enterprise.dao;

import com.enterprise.entity.Demand;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IDemandDao {
    //获取所有需求
    List<Demand> getAllDemand();

    //通过类型获取需求
    List<Demand> getDemandByType(@Param("demandType")String demandType);

    //通过企业Id获取需求
    List<Demand> getDemandByEntId(@Param("entId") String entId);

    //发布需求
    void publish(Demand demand);

    //通过需求Id删除需求
    void deleteByDemandId(@Param("demandId") String demandId);
}
