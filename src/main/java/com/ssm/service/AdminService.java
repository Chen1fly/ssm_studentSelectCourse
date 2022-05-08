package com.ssm.service;

import com.ssm.entity.Admin;

/**
 * @program: ssmdemo
 * @description: ${description}
 * @anther mt
 * @creater 2021-06-23 14:07
 */
public interface AdminService {


    int deleteByPrimaryKey(Integer id, String name);

    int insert(Admin record);

    int insertSelective(Admin record);

    Admin selectByPrimaryKey(Integer id, String name);

    int updateByPrimaryKeySelective(Admin record);

    int updateByPrimaryKey(Admin record);

    Admin login(String account, String password);

    int deleteByPrimaryKey(Integer id);

    Admin selectByPrimaryKey(Integer id);
}


