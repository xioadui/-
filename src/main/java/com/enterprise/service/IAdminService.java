package com.enterprise.service;

import com.enterprise.entity.Demand;
import com.enterprise.entity.Enterprise;
import com.enterprise.entity.Provide;

import java.util.List;

/**
 * 管理员
 */
public interface IAdminService {
    List<Enterprise> _register(long index,int length);
    List<Demand> _demand(long index,int length);
    List<Provide> _provide(long index,int length);
    String _agreeRegister(String entId);
    String _agreeDemand(int demandId);
    String _agreeProvide(int proId);

}
