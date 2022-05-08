package com.ssm.service;

import com.ssm.entity.Clazz;
import com.ssm.entity.Page;

import java.util.List;

/**
 * @program: ssmdemo
 * @description: ${description}
 * @anther mt
 * @creater 2021-06-23 14:07
 */
public interface ClazzService {


    int deleteByPrimaryKey(Integer id);

    int insert(Clazz record);

    int insertSelective(Clazz record);

    Clazz selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Clazz record);

    int updateByPrimaryKey(Clazz record);

    List<Clazz> getClazzList(Clazz clazz, Page page);

    int getClazzListTotal(Clazz clazz);
}

