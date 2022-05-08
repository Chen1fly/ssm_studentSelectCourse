package com.ssm.controller;

import com.ssm.entity.Admin;
import com.ssm.entity.Student;
import com.ssm.entity.Teacher;
import com.ssm.service.AdminService;
import com.ssm.service.StudentService;
import com.ssm.service.TeacherService;
import com.ssm.util.StringUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @program: ssmdemo
 * @description: ${description}
 * @anther mt
 * @creater 2021-06-23 11:50
 */
@Controller
@RequestMapping("login")
public class LoginController {
    @Resource
    private AdminService adminService;
    @Resource
    private StudentService studentService;
    @Resource
    private TeacherService teacherService;

    /**
     * 退出登录
     *
     * @param request
     * @return
     */
    @RequestMapping("logout")
    public String logout(HttpServletRequest request) {
        request.getSession().removeAttribute("user");
        request.getSession().removeAttribute("userType");
        return "login";
    }

    @RequestMapping("login")
    @ResponseBody
    public String login(HttpServletRequest request, String vcode, String account, String password, Integer type) {
        String loginCpacha = request.getSession().getAttribute("loginCapcha").toString();
        if (StringUtil.isEmpty(vcode)) {
            return "vcodeError";
        }
        if (!vcode.toUpperCase().equals(loginCpacha.toUpperCase())) {
            return "vcodeError";
        }
        //验证码验证通过，对比用户名密码是否正确
        String loginStatus = "loginFaild";
        HttpSession session = request.getSession();
        //判断选择的登陆类型：管理员，教师，学生，进行不登的处理方式
        switch (type) {
            case 1: {
                Admin admin = adminService.login(account, password);
                if (admin == null) {
                    return "loginError";
                }
                session.setAttribute("user", admin);
                loginStatus = "loginSuccess";
                break;
            }
            case 2: {
                Student student = studentService.login(account, password);
                if (student == null) {
                    return "loginError";
                }
                session.setAttribute("user", student);
                loginStatus = "loginSuccess";
                break;
            }
            case 3: {
                Teacher teacher = teacherService.login(account, password);
                if (teacher == null) {
                    return "loginError";
                }
                session.setAttribute("user", teacher);
                loginStatus = "loginSuccess";
                break;
            }
            default:
                break;
        }
        session.setAttribute("userType", type);
        return loginStatus;
    }
}
