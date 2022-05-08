package com.ssm.mapper;

import com.ssm.entity.Course;
import com.ssm.entity.Page;
import org.apache.ibatis.annotations.Param;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * @program: ssmdemo
 * @description: ${description}
 * @anther mt
 * @creater 2021-06-23 15:23
 */
public interface CourseMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Course record);

    int insertSelective(Course record);

    Course selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Course record);

    int updateByPrimaryKey(Course record);

    List<Map<String, Object>> selectIsFull(@Param("courseid") Integer courseid);

    int deleteByIds(@Param("idStr") String idStr);

    List<Course> getCourseList(@Param("course") Course course, @Param("page") Page page);

    int getCourseListTotal(@Param("course") Course course);
}