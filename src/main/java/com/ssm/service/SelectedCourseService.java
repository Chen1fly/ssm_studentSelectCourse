package com.ssm.service;

import com.ssm.entity.Page;
import com.ssm.entity.SelectedCourse;

import java.util.List;

/**
 * @program: ssmdemo
 * @description: ${description}
 * @anther mt
 * @creater 2021-06-23 14:07
 */
public interface SelectedCourseService {


    int deleteByPrimaryKey(Integer id);

    int insert(SelectedCourse record);

    int insertSelective(SelectedCourse record);

    SelectedCourse selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SelectedCourse record);

    int updateByPrimaryKey(SelectedCourse record);

    boolean isSelected(Integer studentid, Integer courseid);

    List<SelectedCourse> getSelectedCourseList(SelectedCourse selectedCourse, Page page);

    int getSelectedCourseListTotal(SelectedCourse selectedCourse);
}

