package com.enterprise.service;

import com.enterprise.entity.Provide;

import java.util.List;

public interface ProvideService {
    //获取所有供应
    List<Provide> getAllPro(long index, int length);

    //根据供应类型获取供应
    List<Provide> getProByType(String proType, long index, int length);

    //根据企业Id获取供应
    List<Provide> getProByEntId(String entId, long index, int length);

    /**
     * 对供应进行模糊查询
     * @param condition 查询的条件，例如供应的类型，标题
     * @param index 起始的索引
     * @param length 长度
     * @return 返回查询得到的结果集
     */
    List<Provide> searchPro(String condition, long index, int length);

    /**
     * 发布供应
     * @param provide 供应对应的实体类
     * @return 返回发布的结果
     */
    //发布供应
    String publish(Provide provide);

    /**
     * 删除企业发布的供应
     * @param proId
     * @param entId
     * @return
     */
    //删除供应，这里还需要提供企业ID
    String deleteByproId(int proId, String entId);

    //管理员允许供应

    //管理员拒绝供应
}
