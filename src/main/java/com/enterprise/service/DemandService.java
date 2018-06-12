package com.enterprise.service;

import com.enterprise.entity.Demand;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DemandService {
    //获取所有需求
    public List<Demand> getAllDemand();

    //通过类型获取需求
    public List<Demand> getDemandByType(@Param("demandType")String demandType);

    //通过企业Id获取需求
    public List<Demand> getDemandByEntId(@Param("entId") String entId);

    //发布需求
    public String publish(Demand demand);

    //通过需求Id删除需求
    public String deleteByDemandId(@Param("demandId") String demandId);
}
