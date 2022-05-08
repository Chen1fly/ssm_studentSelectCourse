package com.ssm.service.impl;

import com.ssm.entity.Page;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.ssm.entity.Course;
import com.ssm.mapper.CourseMapper;
import com.ssm.service.CourseService;

import java.util.List;

/**
 * @program: ssmdemo
 * @description: ${description}
 * @anther mt
 * @creater 2021-06-23 14:07
 */
@Service
public class CourseServiceImpl implements CourseService {

    @Resource
    private CourseMapper courseMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return courseMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Course record) {
        return courseMapper.insert(record);
    }

    @Override
    public int insertSelective(Course record) {
        return courseMapper.insertSelective(record);
    }

    @Override
    public Course selectByPrimaryKey(Integer id) {
        return courseMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Course record) {
        return courseMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Course record) {
        return courseMapper.updateByPrimaryKey(record);
    }

    @Override
    public boolean isFull(Integer courseid) {

        return courseMapper.selectIsFull(courseid).size()>0;
    }

    @Override
    public void updateCourseSelectedNum(Integer courseid, int i) {
        Course course = courseMapper.selectByPrimaryKey(courseid);
        course.setSelectedNum(course.getSelectedNum()+i);
        courseMapper.updateByPrimaryKeySelective(course);
    }

    @Override
    public List<Course> getCourseList(Course course, Page page) {

        return courseMapper.getCourseList(course,page);
    }

    @Override
    public int getCourseListTotal(Course course) {
        return courseMapper.getCourseListTotal(course);
    }

    @Override
    public void deleteByIds(String idStr) {
        courseMapper.deleteByIds(idStr);
    }

}

