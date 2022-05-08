package com.ssm.service.impl;

import com.ssm.entity.Page;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.ssm.mapper.TeacherMapper;
import com.ssm.entity.Teacher;
import com.ssm.service.TeacherService;

import java.util.List;

/**
 * @program: ssmdemo
 * @description: ${description}
 * @anther mt
 * @creater 2021-06-23 14:07
 */
@Service
public class TeacherServiceImpl implements TeacherService {

    @Resource
    private TeacherMapper teacherMapper;

    @Override
    public int deleteByPrimaryKey(Integer id, String sn) {
        return teacherMapper.deleteByPrimaryKey(id, sn);
    }

    @Override
    public int insert(Teacher record) {
        return teacherMapper.insert(record);
    }

    @Override
    public int insertSelective(Teacher record) {
        return teacherMapper.insertSelective(record);
    }

    @Override
    public Teacher selectByPrimaryKey(Integer id, String sn) {
        return teacherMapper.selectByPrimaryKey(id, sn);
    }

    @Override
    public int updateByPrimaryKeySelective(Teacher record) {
        return teacherMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Teacher record) {
        return teacherMapper.updateByPrimaryKey(record);
    }

    @Override
    public Teacher login(String account, String password) {

        return teacherMapper.selectNameAndPassword(account, password);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return teacherMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Teacher selectByPrimaryKey(Integer id) {
        return teacherMapper.selectByPrimaryKey(id);
    }

    @Override
    public int deleteByIds(String idStr) {
        return teacherMapper.deleteByIds(idStr);
    }

    @Override
    public List<Teacher> getTeacherList(Teacher teacher, Page page) {
        return teacherMapper.getTeacherList(teacher,page);
    }

    @Override
    public int getTeacherListTotal(Teacher teacher) {
        return teacherMapper.getTeacherListTotal(teacher);
    }
}

