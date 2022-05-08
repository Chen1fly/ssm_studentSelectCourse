package com.ssm.mapper;

import com.ssm.entity.Clazz;import com.ssm.entity.Page;import org.apache.ibatis.annotations.Param;import java.util.List;

/**
 * @program: ssmdemo
 * @description: ${description}
 * @anther mt
 * @creater 2021-06-23 15:23
 */
public interface ClazzMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Clazz record);

    int insertSelective(Clazz record);

    Clazz selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Clazz record);

    int updateByPrimaryKey(Clazz record);

    List<Clazz> getClazzList(@Param("clazz") Clazz clazz, @Param("page") Page page);

    int getClazzListTotal(@Param("clazz") Clazz clazz);
}