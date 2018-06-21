package com.enterprise.service;

import com.enterprise.entity.Information;

import java.util.List;

public interface IInformationService {
    //    保存到数据库中
    void save(List<Information> info);
    List<Information> getAllInfo(long index,int length);
    List<Information> queryById(long id);
    //    通过标题查询
    List<Information> queryByTitle(String title,long index,int length);
    //    通过资讯的时间查询
<<<<<<< HEAD
    List<Information> queryByDate(String date,long index,int length);

    List<Information> queryByType(String type,long index,int length);

    List<Information> searchInformation(String condition,long index,int length);
=======
    public List<Information> queryByDate(String date, long index, int length);

    public List<Information> queryByType(String type, long index, int length);

    public List<Information> searchInformation(String condition, long index, int length);
>>>>>>> 072f66b0cd66e41ea585c03761c2198c980afe10
}
