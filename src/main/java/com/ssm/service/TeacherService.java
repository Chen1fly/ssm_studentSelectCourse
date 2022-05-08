package com.ssm.service;

import com.ssm.entity.Page;
import com.ssm.entity.Student;
import com.ssm.entity.Teacher;

import java.util.List;

/**
 * @program: ssmdemo
 * @description: ${description}
 * @anther mt
 * @creater 2021-06-23 14:07
 */
public interface TeacherService {


    int deleteByPrimaryKey(Integer id, String sn);

    int insert(Teacher record);

    int insertSelective(Teacher record);

    Teacher selectByPrimaryKey(Integer id, String sn);

    int updateByPrimaryKeySelective(Teacher record);

    int updateByPrimaryKey(Teacher record);

    Teacher login(String account, String password);

    int deleteByPrimaryKey(Integer id);

    Teacher selectByPrimaryKey(Integer id);

    int deleteByIds(String idStr);

    List<Teacher> getTeacherList(Teacher teacher, Page page);

    int getTeacherListTotal(Teacher teacher);
}

