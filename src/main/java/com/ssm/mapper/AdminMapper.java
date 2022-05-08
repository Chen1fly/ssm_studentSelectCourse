package com.ssm.mapper;

import com.ssm.entity.Admin;import org.apache.ibatis.annotations.Param;

/**
 * @program: ssmdemo
 * @description: ${description}
 * @anther mt
 * @creater 2021-06-23 15:23
 */
public interface AdminMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Admin record);

    int insertSelective(Admin record);

    Admin selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Admin record);

    int updateByPrimaryKey(Admin record);

    int deleteByPrimaryKey(@Param("id") Integer id, @Param("name") String name);

    Admin selectByPrimaryKey(@Param("id") Integer id, @Param("name") String name);

    Admin selectNameAndPassword(@Param("account") String account, @Param("password") String password);
}