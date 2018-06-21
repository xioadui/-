package com.enterprise.service.serviceImpl;

import com.enterprise.dao.IProvideDao;
import com.enterprise.entity.Provide;
import com.enterprise.service.ProvideService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ProvideServiceImpl implements ProvideService {

    @Resource
    private IProvideDao provideDao;

    @Override
    public List<Provide> getAllPro(long index, int length) {

        return provideDao.getAllPro(index,length);
    }

    @Override
    public List<Provide> getProByType(String proType, long index, int length) {
        return provideDao.getProByType(proType,index,length);
    }

    @Override
    public List<Provide> getProByEntId(String entId, long index, int length) {

        return provideDao.getProByEntId(entId,index,length);
    }

    @Override
    public List<Provide> searchPro(String condition, long index, int length) {
        return provideDao.searchPro(condition,index,length);
    }

    @Override
    public String publish(Provide provide) {
        provideDao.publish(provide);
        return "success";
    }

    /**
     * 删除供应
     * @param proId
     * @param entId
     * @return
     */
    @Override
    public String deleteByproId(int proId, String entId) {
        provideDao.deleteByproId(proId,entId);
        return "success";
    }
}
