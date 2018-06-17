package com.enterprise.service.serviceImpl;

import com.enterprise.dao.IAdminDao;
import com.enterprise.entity.Demand;
import com.enterprise.entity.Enterprise;
import com.enterprise.entity.Provide;
import com.enterprise.service.IAdminService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AdminServiceImpl implements IAdminService {
    @Resource
    IAdminDao adminDao;
    @Override
    public List<Enterprise> _register(long index, int length) {
        return adminDao._register(index, length);
    }

    @Override
    public List<Demand> _demand(long index, int length) {
        return adminDao._demand(index, length);
    }

    @Override
    public List<Provide> _provide(long index, int length) {
        return adminDao._provide(index,length);
    }

    @Override
    public String _agreeRegister(String entId) {
        return adminDao._agreeRegister(entId);
    }

    @Override
    public String _agreeDemand(int demandId) {
        return adminDao._agreeDemand(demandId);
    }

    @Override
    public String _agreeProvide(int proId) {
        return adminDao._agreeProvide(proId);
    }
}
