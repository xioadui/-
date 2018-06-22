package com.enterprise.service.serviceImpl;

import com.enterprise.dao.IEnterpriseDao;
import com.enterprise.entity.Enterprise;
import com.enterprise.service.EnterpriseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class EnterpriseServiceImpl implements EnterpriseService {
    @Resource
    private IEnterpriseDao enterpriseDao;
    @Override
    public String register(Enterprise enterprise) {
        enterpriseDao.register(enterprise);
        return "success";
    }
    @Override
    public Enterprise login(String entId, String entPassword) {
        return enterpriseDao.login(entId, entPassword);
    }
    @Override
    public Enterprise checkId(String entId) {
        return enterpriseDao.checkId(entId);
    }
    @Override
    public List<Enterprise> searchInt(String condition, long index, int length) {
        return enterpriseDao.searchEnt(condition,index,length);
    }
    @Override
    public List<Enterprise> queryIntById(String entId) {
        return enterpriseDao.queryEntById(entId);
    }
    @Override
    public List<Enterprise> getAllEnt(long index, int length) {
        return enterpriseDao.getAllEnt(index,length);
    }
}
