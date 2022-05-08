package com.ssm.service.impl;

import com.ssm.entity.Page;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.ssm.mapper.StudentMapper;
import com.ssm.entity.Student;
import com.ssm.service.StudentService;

import java.util.List;

/**
 * @program: ssmdemo
 * @description: ${description}
 * @anther mt
 * @creater 2021-06-23 14:07
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Resource
    private StudentMapper studentMapper;

    @Override
    public int deleteByPrimaryKey(Integer id, String sn) {
        return studentMapper.deleteByPrimaryKey(id, sn);
    }

    @Override
    public int insert(Student record) {
        return studentMapper.insert(record);
    }

    @Override
    public int insertSelective(Student record) {
        return studentMapper.insertSelective(record);
    }

    @Override
    public Student selectByPrimaryKey(Integer id, String sn) {
        return studentMapper.selectByPrimaryKey(id, sn);
    }

    @Override
    public int updateByPrimaryKeySelective(Student record) {
        return studentMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Student record) {
        return studentMapper.updateByPrimaryKey(record);
    }

    @Override
    public Student login(String account, String password) {

        return studentMapper.selectNameAndPassword(account, password);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return studentMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Student selectByPrimaryKey(Integer id) {
        return studentMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Student> getStudentList(Student student, Page page) {
        return studentMapper.getStudentList(student,page);
    }

    @Override
    public int getStudentListTotal(Student student) {
        return studentMapper.getStudentListTotal(student);
    }

    @Override
    public int deleteByIds(String idStr) {
        return studentMapper.deleteByIds(idStr);
    }
}

