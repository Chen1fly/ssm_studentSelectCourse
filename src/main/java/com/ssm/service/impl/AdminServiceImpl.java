package com.ssm.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.ssm.entity.Admin;
import com.ssm.mapper.AdminMapper;
import com.ssm.service.AdminService;

/**
 * @program: ssmdemo
 * @description: ${description}
 * @anther mt
 * @creater 2021-06-23 14:07
 */
@Service
public class AdminServiceImpl implements AdminService {

    @Resource
    private AdminMapper adminMapper;

    @Override
    public int deleteByPrimaryKey(Integer id, String name) {
        return adminMapper.deleteByPrimaryKey(id, name);
    }

    @Override
    public int insert(Admin record) {
        return adminMapper.insert(record);
    }

    @Override
    public int insertSelective(Admin record) {
        return adminMapper.insertSelective(record);
    }

    @Override
    public Admin selectByPrimaryKey(Integer id, String name) {
        return adminMapper.selectByPrimaryKey(id, name);
    }

    @Override
    public int updateByPrimaryKeySelective(Admin record) {
        return adminMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Admin record) {
        return adminMapper.updateByPrimaryKey(record);
    }

    @Override
    public Admin login(String account, String password) {
        return adminMapper.selectNameAndPassword(account, password);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return adminMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Admin selectByPrimaryKey(Integer id) {
        return adminMapper.selectByPrimaryKey(id);
    }
}


