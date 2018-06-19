package com.enterprise.dao;


import com.enterprise.entity.Demand;
import com.enterprise.entity.Enterprise;
import com.enterprise.entity.Provide;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IAdminDao {
    List<Enterprise> _register_admin(@Param("index") long index, @Param("length")int length);
    List<Demand> _demand_admin(@Param("index")long index, @Param("length")int length);
    List<Provide> _provide_admin(@Param("index")long index, @Param("length")int length);
    List<Enterprise> _register(@Param("index") long index, @Param("length")int length);
    List<Demand> _demand(@Param("index")long index, @Param("length")int length);
    List<Provide> _provide(@Param("index")long index, @Param("length")int length);
    void _agreeRegister(@Param("entId") String entId);
    void _agreeDemand(@Param("demandId") int demandId);
    void _agreeProvide(@Param("proId") int proId);
    void _deleteRegister(@Param("entId") String entId);
    void _deleteDemand(@Param("demandId") int demandId);
    void _deleteProvide(@Param("proId") int proId);
    void _deleteEnt(@Param("entId")String entId);
    void _deleteDemandAgree(@Param("demandId")int demandId);
    void _deleteProvideAgree(@Param("proId")int proId);
    int _registerSum();
    int _demandSum();
    int _proSum();
    int _entSum();
    int _agreeDemandSum();
    int _agreeProSum();
    Demand _demandContent(@Param("demandId") int demandId);
    Provide _proContent(@Param("proId") int proId);
    Demand _demandContentAgree(@Param("demandId") int demandId);
    Provide _proContentAgree(@Param("proId") int proId);
}
