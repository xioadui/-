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
    public List<Demand> getAllDemand(long index,int length) {
        return iDemandDao.getAllDemand(index, length);
    }

    @Override
    public List<Demand> getDemandByType(String demandType,long index,int length) {
        return iDemandDao.getDemandByType(demandType,index,length);
    }

    @Override
    public List<Demand> getDemandByEntId(String entId,long index,int length) {
        return iDemandDao.getDemandByEntId(entId,index,length);
    }

    @Override
    public String publish(Demand demand) {
        iDemandDao.publish(demand);
        return "success";
    }

    /**
     * 删除需求
     * @param demandId 需求的ID
     * @param entId 用户的ID
     * @return
     */
    @Override
    public String deleteByDemandId(String demandId,String entId) {
        iDemandDao.deleteByDemandId(demandId,entId);
        return "success";
    }

    /**
     * 通过指定的条件对需求进行模糊查询
     * @param condition 可以是需求的类型或者需求标题的一部分
     * @return
     */
    @Override
    public List<Demand> searchDemand(String condition,long index,int length) {
        return iDemandDao.searchDemand(condition,index,length);
    }
}
