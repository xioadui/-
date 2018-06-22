package com.enterprise.service;

import com.enterprise.entity.Enterprise;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EnterpriseService {
    String register(@Param("enterprise")Enterprise enterprise);

    Enterprise login(@Param("entId")String entId, @Param("entPassword")String entPassword);

    Enterprise checkId(@Param("entId")String entId);

    List<Enterprise> searchInt(@Param("condition") String condition,
                               @Param("index")long index,
                               @Param("length")int length
    );
    List<Enterprise> queryIntById(@Param("entId")String entId);
    List<Enterprise> getAllEnt(@Param("index")long index,@Param("length")int length);
}
