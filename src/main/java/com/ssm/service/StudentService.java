package com.ssm.service;

import com.ssm.entity.Page;
import com.ssm.entity.Student;

import java.util.List;

/**
 * @program: ssmdemo
 * @description: ${description}
 * @anther mt
 * @creater 2021-06-23 14:07
 */
public interface StudentService {


    int deleteByPrimaryKey(Integer id, String sn);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(Integer id, String sn);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);

    Student login(String account, String password);

    int deleteByPrimaryKey(Integer id);

    Student selectByPrimaryKey(Integer id);

    List<Student> getStudentList(Student student, Page page);

    int getStudentListTotal(Student student);

    int deleteByIds(String idStr);
}

