package com.enterprise.service.serviceImpl;

import com.enterprise.dao.IAdminDao;
import com.enterprise.entity.Demand;
import com.enterprise.entity.Enterprise;
import com.enterprise.entity.Provide;
import com.enterprise.service.IAdminService;
import org.junit.Test;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AdminServiceImpl implements IAdminService {
    @Resource
    IAdminDao adminDao;

    @Override
    public List<Enterprise> _register_admin(long index, int length) {
        return adminDao._register_admin(index, length);
    }

    @Override
    public List<Demand> _demand_admin(long index, int length) {
        return adminDao._demand_admin(index, length);
    }

    @Override
    public List<Provide> _provide_admin(long index, int length) {
        return adminDao._provide_admin(index, length);
    }

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
        adminDao._agreeRegister(entId);
        adminDao._deleteRegister(entId);
        return "success";
    }

    @Override
    public String _agreeDemand(int demandId) {
        adminDao._agreeDemand(demandId);
        adminDao._deleteDemand(demandId);
        return "success";
    }

    @Override
    public String _agreeProvide(int proId) {
        adminDao._agreeProvide(proId);
        adminDao._deleteProvide(proId);
        return "success";
    }

    @Override
    public String _deleteRegister(String entId) {
        adminDao._deleteRegister(entId);
        return "success";
    }

    @Override
    public String _deleteDemand(int demandId) {
        adminDao._deleteDemand(demandId);
        return "success";
    }

    @Override
    public String _deleteProvide(int proId) {
        adminDao._deleteProvide(proId);
        return "success";
    }

    @Override
    public String _deleteEnt(String entId) {
        adminDao._deleteEnt(entId);
        return "success";
    }

    @Override
    public String _deleteDemandAgree(int demandId) {
        adminDao._deleteDemandAgree(demandId);
        return "success";
    }

    @Override
    public String _deleteProvideAgree(int proId) {
        adminDao._deleteProvideAgree(proId);
        return "success";
    }

    @Override
    public int _registerSum() {
        return adminDao._registerSum();
    }

    @Override
    public int _demandSum() {
        return adminDao._demandSum();
    }

    @Override
    public int _proSum() {
        return adminDao._proSum();
    }

    @Override
    public int _entSum() {
        return adminDao._entSum();
    }

    @Override
    public int _agreeDemandSum() {
        return adminDao._agreeDemandSum();
    }

    @Override
    public int _agreeProSum() {
        return adminDao._agreeProSum();
    }

    @Override
    public Enterprise _registerContent(String entId) {
        return adminDao._registerContent(entId);
    }

    @Override
    public Demand _demandContent(int demandId) {
        return adminDao._demandContent(demandId);
    }

    @Override
    public Provide _proContent(int proId) {
        return adminDao._proContent(proId);
    }

    @Override
    public Demand _demandContentAgree(int demandId) {
        return adminDao._demandContentAgree(demandId);
    }

    @Override
    public Provide _proContentAgree(int proId) {
        return adminDao._proContentAgree(proId);
    }
}
