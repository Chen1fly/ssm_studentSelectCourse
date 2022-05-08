package com.ssm.mapper;

import com.ssm.entity.Page;
import com.ssm.entity.SelectedCourse;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @program: ssmdemo
 * @description: ${description}
 * @anther mt
 * @creater 2021-06-23 15:23
 */
public interface SelectedCourseMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SelectedCourse record);

    int insertSelective(SelectedCourse record);

    SelectedCourse selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SelectedCourse record);

    int updateByPrimaryKey(SelectedCourse record);

    List<Map<Object, Object>> selectIsSelected(@Param("studentid") Integer studentid, @Param("courseid") Integer courseid);

    List<SelectedCourse> getSelectedCourseList(@Param("selectedCourse") SelectedCourse selectedCourse, @Param("page") Page page);

    int getSelectedCourseListTotal(@Param("selectedCourse") SelectedCourse selectedCourse);
}