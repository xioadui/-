package com.enterprise.service;

import com.enterprise.entity.Provide;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProvideService {
    //获取所有供应
    List<Provide> getAllPro();

    //根据供应类型获取供应
    List<Provide> getProByType(@Param("proType") String proType);

    //根据企业Id获取供应
    List<Provide> getProByEntId(@Param("entId") String entId);

    //发布供应
    String publish(Provide provide);

    //删除供应
    String deleteByproId(@Param("proId") String proId);

    //管理员允许供应

    //管理员拒绝供应
}
