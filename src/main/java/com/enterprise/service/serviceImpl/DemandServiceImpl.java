package com.enterprise.service.serviceImpl;

import com.enterprise.dao.IDemandDao;
import com.enterprise.entity.Demand;
import com.enterprise.service.DemandService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DemandServiceImpl implements DemandService {

    @Resource
    IDemandDao iDemandDao;

    @Override
    public List<Demand> getAllDemand() {
        return iDemandDao.getAllDemand();
    }

    @Override
    public List<Demand> getDemandByType(String demandType) {
        return iDemandDao.getDemandByType(demandType);
    }

    @Override
    public List<Demand> getDemandByEntId(String entId) {
        return iDemandDao.getDemandByEntId(entId);
    }

    @Override
    public String publish(Demand demand) {
        iDemandDao.publish(demand);
        return "success";
    }

    @Override
    public String deleteByDemandId(String demandId) {
        iDemandDao.deleteByDemandId(demandId);
        return "success";
    }
}
