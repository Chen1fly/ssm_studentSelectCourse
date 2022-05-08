package com.ssm.service.impl;

import com.ssm.entity.Page;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.ssm.entity.SelectedCourse;
import com.ssm.mapper.SelectedCourseMapper;
import com.ssm.service.SelectedCourseService;

import java.util.List;

/**
 * @program: ssmdemo
 * @description: ${description}
 * @anther mt
 * @creater 2021-06-23 14:07
 */
@Service
public class SelectedCourseServiceImpl implements SelectedCourseService {

    @Resource
    private SelectedCourseMapper selectedCourseMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return selectedCourseMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(SelectedCourse record) {
        return selectedCourseMapper.insert(record);
    }

    @Override
    public int insertSelective(SelectedCourse record) {
        return selectedCourseMapper.insertSelective(record);
    }

    @Override
    public SelectedCourse selectByPrimaryKey(Integer id) {
        return selectedCourseMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(SelectedCourse record) {
        return selectedCourseMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(SelectedCourse record) {
        return selectedCourseMapper.updateByPrimaryKey(record);
    }

    @Override
    public boolean isSelected(Integer studentid, Integer courseid) {

        return selectedCourseMapper.selectIsSelected(studentid,courseid).size()>0;
    }

    @Override
    public List<SelectedCourse> getSelectedCourseList(SelectedCourse selectedCourse, Page page) {

        return selectedCourseMapper.getSelectedCourseList(selectedCourse,page);
    }

    @Override
    public int getSelectedCourseListTotal(SelectedCourse selectedCourse) {
        return selectedCourseMapper.getSelectedCourseListTotal(selectedCourse);
    }

}

