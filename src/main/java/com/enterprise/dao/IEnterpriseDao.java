package com.enterprise.dao;

import com.enterprise.entity.Enterprise;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IEnterpriseDao {
    void register(@Param("enterprise") Enterprise enterprise);

    Enterprise login(@Param("entId")String entId, @Param("entPassword")String password);

    Enterprise checkId(@Param("entId") String entId);

    List<Enterprise> searchEnt(@Param("condition") String condition,
                               @Param("index")long index,
                               @Param("length")int length
    );

    List<Enterprise> queryEntById(@Param("entId")String entId);
    List<Enterprise> getAllEnt(@Param("index")long index,@Param("length")int length);
}
