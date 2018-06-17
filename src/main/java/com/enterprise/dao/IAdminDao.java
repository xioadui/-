package com.enterprise.dao;


import com.enterprise.entity.Demand;
import com.enterprise.entity.Enterprise;
import com.enterprise.entity.Provide;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IAdminDao {
    List<Enterprise> _register(@Param("index") long index, @Param("length")int length);
    List<Demand> _demand(@Param("index")long index, @Param("length")int length);
    List<Provide> _provide(@Param("index")long index, @Param("length")int length);
    String _agreeRegister(@Param("entId") String entId);
    String _agreeDemand(@Param("demandId") int demandId);
    String _agreeProvide(@Param("proId") int proId);
}
