package com.ssm.controller;

import com.ssm.entity.Admin;
import com.ssm.entity.Student;
import com.ssm.entity.Teacher;
import com.ssm.service.AdminService;
import com.ssm.service.StudentService;
import com.ssm.service.TeacherService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @program: ssmdemo
 * @description: ${description}
 * @anther mt
 * @creater 2021-06-23 11:51
 */
@Controller
@RequestMapping("system")
public class SystemController {

    @Resource
    private AdminService adminService;
    @Resource
    private StudentService studentService;
    @Resource
    private TeacherService teacherService;

    @RequestMapping("toPersonalView")
    public String toPersonalView(){
        return "personalView";
    }



    @RequestMapping("editPasswod")
    @ResponseBody
    public String editPasswod(HttpServletRequest request,String password, String newpassword){

        int userType = Integer.parseInt(request.getSession().getAttribute("userType").toString());
        int num = 0;
        if(userType == 1){
            //管理员
            Admin admin = (Admin)request.getSession().getAttribute("user");
            if(!admin.getPassword().equals(password)){
                return "原密码错误！";
            }
            admin.setPassword(newpassword);
            num = adminService.updateByPrimaryKeySelective(admin);

        }
        if(userType == 2){
            //学生
            Student student = (Student)request.getSession().getAttribute("user");
            if(!student.getPassword().equals(password)){
                return "原密码错误！";
            }
            student.setPassword(newpassword);
            num = studentService.updateByPrimaryKeySelective(student);
        }
        if(userType == 3){
            //教师
            Teacher teacher = (Teacher)request.getSession().getAttribute("user");
            if(!teacher.getPassword().equals(password)){
                return "原密码错误！";
            }
            teacher.setPassword(newpassword);
            num = teacherService.updateByPrimaryKeySelective(teacher);
        }
        if(num>0){
            return "success";
        }else{
            return "数据库修改错误";
        }
    }
}
