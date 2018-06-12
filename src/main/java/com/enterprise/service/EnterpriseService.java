package com.enterprise.service;

import com.enterprise.entity.Enterprise;
import org.apache.ibatis.annotations.Param;

public interface EnterpriseService {
    public String register(@Param("enterprise")Enterprise enterprise);

    public Enterprise login(@Param("entId")String entId, @Param("entPassword")String entPassword);

    public Enterprise checkId(@Param("entId")String entId);
}
