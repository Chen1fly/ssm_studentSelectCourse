package com.ssm.mapper;

import com.ssm.entity.Page;
import com.ssm.entity.Teacher;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @program: ssmdemo
 * @description: ${description}
 * @anther mt
 * @creater 2021-06-23 15:23
 */
public interface TeacherMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Teacher record);

    int insertSelective(Teacher record);

    Teacher selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Teacher record);

    int updateByPrimaryKey(Teacher record);

    int deleteByPrimaryKey(@Param("id") Integer id, @Param("sn") String sn);

    Teacher selectByPrimaryKey(@Param("id") Integer id, @Param("sn") String sn);

    Teacher selectNameAndPassword(@Param("account") String account, @Param("password") String password);

    int deleteByIds(@Param("ids") String ids);

    List<Teacher> getTeacherList(@Param("teacher") Teacher teacher, @Param("page") Page page);

    int getTeacherListTotal(@Param("teacher") Teacher teacher);
}