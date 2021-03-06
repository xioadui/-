package com.enterprise.service.serviceImpl;

import com.enterprise.dao.IInformationDao;
import com.enterprise.entity.Information;
import com.enterprise.service.IInformationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class InformationServiceImpl implements IInformationService {
    @Resource
    private IInformationDao informationDao;
    @Override
    public void save(List<Information> info) {
        informationDao.save(info);
    }
    @Override
    public List<Information> queryByTitle(String title) {
        return informationDao.queryByTitle(title);
    }

    @Override
    public List<Information> queryByDate(String date,long index,int length) {
        return informationDao.queryByDate(date, index, length);
    }
    @Override
    public List<Information> queryByType(String type, long index, int length) {
        return informationDao.queryByType(type, index, length);
    }
}
