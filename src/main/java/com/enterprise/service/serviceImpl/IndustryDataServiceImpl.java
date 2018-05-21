package com.enterprise.service.serviceImpl;

import com.enterprise.dao.IIndustryDataDao;
import com.enterprise.entity.IndustryData;
import com.enterprise.service.IIndustryDataService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class IndustryDataServiceImpl implements IIndustryDataService {
    @Resource
    private IIndustryDataDao industryDataDao;
//    爬虫将数据保存到数据库中
    @Override
    public void save(List<IndustryData> info) {
        industryDataDao.save(info);
    }
//  通过标题来查询数据
    @Override
    public List<IndustryData> queryByTitle(String title) {
        return industryDataDao.queryByTitle(title);
    }

    @Override
    public List<IndustryData> queryByDate(String date, long index, int length) {
        return industryDataDao.queryByDate(date, index, length);
    }

    @Override
    public List<IndustryData> queryByType(String type, long index, int length) {
        return industryDataDao.queryByType(type, index, length);
    }
}
