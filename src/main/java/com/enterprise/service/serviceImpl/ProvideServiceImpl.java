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
    public List<Provide> getAllPro() {
        return provideDao.getAllPro();
    }

    @Override
    public List<Provide> getProByType(String proType) {
        return provideDao.getProByType(proType);
    }

    @Override
    public List<Provide> getProByEntId(String entId) {
        return provideDao.getProByEntId(entId);
    }

    @Override
    public String publish(Provide provide) {
        provideDao.publish(provide);
        return "success";
    }

    @Override
    public String deleteByproId(String proId) {
        provideDao.deleteByproId(proId);
        return "success";
    }
}
