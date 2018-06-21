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
    public List<IndustryData> queryByTitle(String title, long index, int length) {
        return industryDataDao.queryByTitle(title,index,length);
    }

    @Override
    public List<IndustryData> queryByDate(String date, long index, int length) {
        return industryDataDao.queryByDate(date, index, length);
    }

    @Override
    public List<IndustryData> queryByType(String type, long index, int length) {
        return industryDataDao.queryByType(type, index, length);
    }

    /**
     * 对行业数据进行模糊查询
     * @param condition 查询的信息
     * @param index 起始位置，这个用于分页查询
     * @param length
     * @return
     */
    @Override
    public List<IndustryData> searchIndustryData(String condition, long index, int length) {
        return industryDataDao.searchIndustryData(condition, index, length);
    }

    @Override
    public List<IndustryData> getAllInd(long index, int length) {
        return industryDataDao.getAllInd(index, length);
    }

    @Override
    public List<IndustryData> queryIndById(long id) {
        return industryDataDao.queryIndById(id);
    }

}
