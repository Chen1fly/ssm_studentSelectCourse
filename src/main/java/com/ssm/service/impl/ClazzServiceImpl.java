package com.ssm.service.impl;

import com.ssm.entity.Page;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.ssm.mapper.ClazzMapper;
import com.ssm.entity.Clazz;
import com.ssm.service.ClazzService;

import java.util.List;

/**
 * @program: ssmdemo
 * @description: ${description}
 * @anther mt
 * @creater 2021-06-23 14:07
 */
@Service
public class ClazzServiceImpl implements ClazzService {

    @Resource
    private ClazzMapper clazzMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return clazzMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Clazz record) {
        return clazzMapper.insert(record);
    }

    @Override
    public int insertSelective(Clazz record) {
        return clazzMapper.insertSelective(record);
    }

    @Override
    public Clazz selectByPrimaryKey(Integer id) {
        return clazzMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Clazz record) {
        return clazzMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Clazz record) {
        return clazzMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Clazz> getClazzList(Clazz clazz, Page page) {

        return clazzMapper.getClazzList(clazz, page);
    }

    @Override
    public int getClazzListTotal(Clazz clazz) {
        return clazzMapper.getClazzListTotal(clazz);
    }

}

