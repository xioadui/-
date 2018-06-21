package com.enterprise.service;

import com.enterprise.entity.Enterprise;
import org.apache.ibatis.annotations.Param;

public interface EnterpriseService {
    String register(@Param("enterprise") Enterprise enterprise);

    Enterprise login(@Param("entId") String entId, @Param("entPassword") String entPassword);

    Enterprise checkId(@Param("entId") String entId);
}
