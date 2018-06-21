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
    public List<Information> queryByTitle(String title,long index,int length) {
        return informationDao.queryByTitle(title,index,length);
    }
    public List<Information> getAllInfo(long index,int length){
        return informationDao.getAllInfo(index,length);
    }

    @Override
    public List<Information> queryById(long id) {
        return informationDao.queryById(id);
    }

    @Override
    public List<Information> queryByDate(String date, long index, int length) {
        return informationDao.queryByDate(date, index, length);
    }
    @Override
    public List<Information> queryByType(String type, long index, int length) {
        return informationDao.queryByType(type, index, length);
    }


    /**
     *
     * 实现模糊查询，通过输入标题或者类型进行查询
     * @param condition
     * @param index
     * @param length
     * @return
     */
    @Override
    public List<Information> searchInformation(String condition, long index, int length) {
        return informationDao.searchInformation(condition,index,length);
    }
}
