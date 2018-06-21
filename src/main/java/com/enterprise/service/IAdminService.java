package com.enterprise.service;

import com.enterprise.entity.Demand;
import com.enterprise.entity.Enterprise;
import com.enterprise.entity.Provide;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 管理员
 */
public interface IAdminService {
    List<Enterprise> _register_admin(@Param("index") long index, @Param("length") int length);
    List<Demand> _demand_admin(@Param("index") long index, @Param("length") int length);
    List<Provide> _provide_admin(@Param("index") long index, @Param("length") int length);
    List<Enterprise> _register(long index, int length);
    List<Demand> _demand(long index, int length);
    List<Provide> _provide(long index, int length);
    String _agreeRegister(String entId);
    String _agreeDemand(int demandId);
    String _agreeProvide(int proId);
    String _deleteRegister(String entId);
    String _deleteDemand(int demandId);
    String _deleteProvide(int proId);
    String _deleteEnt(String entId);
    String _deleteDemandAgree(int demandId);
    String _deleteProvideAgree(int proId);
    int _registerSum();
    int _demandSum();
    int _proSum();
    int _entSum();
    int _agreeDemandSum();
    int _agreeProSum();
    Enterprise _registerContent(String entId);
    Demand _demandContent(int demandId);
    Provide _proContent(int proId);
    Demand _demandContentAgree(int demandId);
    Provide _proContentAgree(int proId);
<<<<<<< HEAD
<<<<<<< HEAD
}
=======
=======
>>>>>>> 072f66b0cd66e41ea585c03761c2198c980afe10
}
>>>>>>> 072f66b0cd66e41ea585c03761c2198c980afe10
