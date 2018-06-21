package com.enterprise.dao;

import com.enterprise.entity.Provide;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IProvideDao {
    /**
     * 获取所有的供应
     * @param index 起始的索引
     * @param length 要获取的数目
     * @return 从数据库查询得到的结果集
     */
    //获取所有供应
<<<<<<< HEAD
<<<<<<< HEAD
    List<Provide> getAllPro(@Param("index") long index,@Param("length") int length);
=======
=======
>>>>>>> 072f66b0cd66e41ea585c03761c2198c980afe10
    List<Provide> getAllPro(@Param("index") long index, @Param("length") int length);

>>>>>>> 072f66b0cd66e41ea585c03761c2198c980afe10
    /**
     * 根据供应的类型获取供应
     * @param proType 供应的类型
     * @param index 起始的索引
     * @param length 要获取的数目
     * @return 返回查询得到的结果集
     */
<<<<<<< HEAD
<<<<<<< HEAD
    List<Provide> getProByType(@Param("proType") String proType,@Param("index") long index,@Param("length") int length);
=======
=======
>>>>>>> 072f66b0cd66e41ea585c03761c2198c980afe10
    List<Provide> getProByType(@Param("proType") String proType, @Param("index") long index, @Param("length") int length);

>>>>>>> 072f66b0cd66e41ea585c03761c2198c980afe10
    /**
     * 根据企业用户的ID获取供应信息
     * @param entId 企业用户的ID
     * @param index 起始的索引
     * @param length 要获取的数目
     * @return 查询得到的结果集
     */
<<<<<<< HEAD
<<<<<<< HEAD
    List<Provide> getProByEntId(@Param("entId") String entId,@Param("index") long index,@Param("length") int length);
=======
=======
>>>>>>> 072f66b0cd66e41ea585c03761c2198c980afe10
    List<Provide> getProByEntId(@Param("entId") String entId, @Param("index") long index, @Param("length") int length);

>>>>>>> 072f66b0cd66e41ea585c03761c2198c980afe10
    /**
     * 对供应进行查询
     * @param condition 指定查询的条件
     * @param index 起始的索引
     * @param length 获取数据的条目
     * @return 结果集
     */
<<<<<<< HEAD
<<<<<<< HEAD
    List<Provide> searchPro(@Param("condition") String condition,@Param("index") long index,@Param("length") int length);
=======
=======
>>>>>>> 072f66b0cd66e41ea585c03761c2198c980afe10
    List<Provide> searchPro(@Param("condition") String condition, @Param("index") long index, @Param("length") int length);

>>>>>>> 072f66b0cd66e41ea585c03761c2198c980afe10
    /**
     * 发布供应
     * @param provide 供应的内容
     */
    void publish(@Param("provide") Provide provide);
    /**
     * 删除供应
     * @param proId 要删除供应的ID
     * @param entId 进行该删除操作的用户ID
     */
<<<<<<< HEAD
<<<<<<< HEAD
    void deleteByproId(@Param("proId") int proId,@Param("entId")String entId);
=======
=======
>>>>>>> 072f66b0cd66e41ea585c03761c2198c980afe10
    void deleteByproId(@Param("proId") int proId, @Param("entId") String entId);

    //管理员允许供应
    void permitByAdmin(@Param("proId") String proId);

    //管理员拒绝供应
    void refuseByAdmin(@Param("proId") String proId);
>>>>>>> 072f66b0cd66e41ea585c03761c2198c980afe10
}
