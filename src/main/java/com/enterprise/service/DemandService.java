package com.enterprise.service;

import com.enterprise.entity.Demand;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DemandService {
    //获取所有需求
    List<Demand> getAllDemand(long index,int length);

    //通过类型获取需求
    List<Demand> getDemandByType(String demandType,long index,int length);

    //通过企业Id获取需求
    List<Demand> getDemandByEntId(String entId,long index,int length);

    //发布需求
    String publish(Demand demand);

    //通过需求Id删除需求，还需要判断要删除的需求是不是该用户发布的
    String deleteByDemandId(String demandId,String entId);

//    通过条件对需求进行模糊查询
    List<Demand> searchDemand(String condition,long index,int length);
    List<Demand> searchDemandById(int demandId);
}
