package com.ssm.mapper;

import com.ssm.entity.Page;
import com.ssm.entity.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @program: ssmdemo
 * @description: ${description}
 * @anther mt
 * @creater 2021-06-23 15:23
 */
public interface StudentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);

    int deleteByPrimaryKey(@Param("id") Integer id, @Param("sn") String sn);

    Student selectByPrimaryKey(@Param("id") Integer id, @Param("sn") String sn);

    Student selectNameAndPassword(@Param("account") String account, @Param("password") String password);

    List<Student> getStudentList(@Param("student") Student student, @Param("page") Page page);

    int getStudentListTotal(@Param("student") Student student);

    int deleteByIds(@Param("ids") String ids);
}