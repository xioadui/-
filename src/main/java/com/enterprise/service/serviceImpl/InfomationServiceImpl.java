package com.enterprise.service.serviceImpl;

import com.enterprise.dao.IInfomationDao;
import com.enterprise.entity.Infomation;
import com.enterprise.service.IInfomationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class InfomationServiceImpl implements IInfomationService {
    @Resource
    private IInfomationDao infomationDao;
    @Override
    public void save(List<Infomation> info) {
        infomationDao.save(info);
    }

    @Override
    public List<Infomation> queryByTitle(String title) {
        return null;
    }

    @Override
    public List<Infomation> queryByDate(String date) {
        return null;
    }
}
