package com.enterprise.service.serviceImpl;

import com.enterprise.dao.IEnterpriseDao;
import com.enterprise.entity.Enterprise;
import com.enterprise.service.EnterpriseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

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
    public Enterprise login(String entId, String entPassword, int entIdentity) {
        return enterpriseDao.login(entId, entPassword, entIdentity);
    }
}
