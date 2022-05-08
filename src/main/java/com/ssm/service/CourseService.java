package com.ssm.service;

import com.ssm.entity.Course;
import com.ssm.entity.Page;

import java.util.List;

/**
 * @program: ssmdemo
 * @description: ${description}
 * @anther mt
 * @creater 2021-06-23 14:07
 */
public interface CourseService {


    int deleteByPrimaryKey(Integer id);

    int insert(Course record);

    int insertSelective(Course record);

    Course selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Course record);

    int updateByPrimaryKey(Course record);

    boolean isFull(Integer courseid);

    void updateCourseSelectedNum(Integer courseid, int i);

    List<Course> getCourseList(Course course, Page page);

    int getCourseListTotal(Course course);

    void deleteByIds(String idStr);
}

