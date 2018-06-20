package com.enterprise.dao;

import com.enterprise.entity.Enterprise;
import org.apache.ibatis.annotations.Param;

public interface IEnterpriseDao {
    void register(@Param("enterprise") Enterprise enterprise);

    Enterprise login(@Param("entId") String entId, @Param("entPassword") String password);

    Enterprise checkId(@Param("entId") String entId);
}
