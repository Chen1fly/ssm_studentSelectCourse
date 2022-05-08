package com.ssm.controller;

import com.ssm.entity.Page;
import com.ssm.entity.Student;
import com.ssm.service.StudentService;
import com.ssm.util.SnGenerateUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: ssmdemo
 * @description: ${description}
 * @anther mt
 * @creater 2021-06-23 11:50
 */
@Controller
@RequestMapping("student")
public class StudentController {
    @Resource
    private StudentService studentService;

    @RequestMapping("toStudentListView")
    public String toStudentListView() {
        return "studentList";
    }

    @RequestMapping("addStudent")
    @ResponseBody
    public String addStudent(Student student, Integer clazzid) {
        student.setClazzId(clazzid);
        student.setSn(SnGenerateUtil.generateSn(clazzid));
        studentService.insertSelective(student);
        return "success";
    }

    @RequestMapping("studentList")
    @ResponseBody
    public String studentList(String from, HttpServletRequest request, String studentName, Integer page, Integer rows, Integer clazzid) {
        Integer pageSize = rows == null ? 999 : rows;
        Integer clazz = clazzid == null ? 0 : clazzid;
        Integer currentPage = page == null ? 1 : page;
        String name = studentName;
        //获取当前登录用户类型
        int userType = Integer.parseInt(request.getSession().getAttribute("userType").toString());
        Student student = new Student();
        student.setName(name);
        student.setClazzId(clazz);
        if (userType == 2) {
            //如果是学生，只能查看自己的信息
            Student currentUser = (Student) request.getSession().getAttribute("user");
            student.setId(currentUser.getId());
        }
        List<Student> clazzList = studentService.getStudentList(student, new Page(currentPage, pageSize));
        int total = studentService.getStudentListTotal(student);

        Map<String, Object> ret = new HashMap<String, Object>();
        ret.put("total", total);
        ret.put("rows", clazzList);
        if ("combox".equals(from)) {
            return JSONArray.fromObject(clazzList).toString();
        } else {
            return JSONObject.fromObject(ret).toString();
        }
    }

    @RequestMapping("editStudent")
    @ResponseBody
    public String editStudent(Student student, Integer clazzid) {
        student.setClazzId(clazzid);
        studentService.updateByPrimaryKeySelective(student);
        return "success";
    }

    @RequestMapping("deleteStudent")
    @ResponseBody
    public String deleteStudent(HttpServletRequest request,
                              HttpServletResponse response) {
        String[] ids = request.getParameterValues("ids[]");
        String idStr = "";
        for(String id : ids){
            idStr += id + ",";
        }
        idStr = idStr.substring(0, idStr.length()-1);
        studentService.deleteByIds(idStr);
        return "success";
    }
}
