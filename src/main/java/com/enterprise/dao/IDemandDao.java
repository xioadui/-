package com.enterprise.dao;

import com.enterprise.entity.Demand;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IDemandDao {
    //获取所有需求
    List<Demand> getAllDemand(@Param("index") long index, @Param("length") int length);

    //通过类型获取需求
    List<Demand> getDemandByType(@Param("demandType") String demandType, @Param("index") long index, @Param("length") int length);

    //通过企业Id获取需求
    List<Demand> getDemandByEntId(@Param("entId") String entId, @Param("index") long index, @Param("length") int length);

    //发布需求
    void publish(@Param("demand") Demand demand);

    //通过需求Id删除需求，同时还需要指定用户的ID，来进行权限的验证
    void deleteByDemandId(@Param("demandId") String demandId, @Param("entId") String entId);

    //通过条件进行需求的模糊查询，例如需求的标题、类型等
    List<Demand> searchDemand(@Param("condition") String condition, @Param("index") long index, @Param("length") int length);
}
