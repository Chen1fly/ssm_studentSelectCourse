package com.ssm.controller;

import com.ssm.entity.Page;
import com.ssm.entity.Student;
import com.ssm.entity.Teacher;
import com.ssm.service.StudentService;
import com.ssm.service.TeacherService;
import com.ssm.util.SnGenerateUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: ssmdemo
 * @description: ${description}
 * @anther mt
 * @creater 2021-06-23 11:51
 */
@Controller
@RequestMapping("teacher")
public class TeacherController {
    @Resource
    private TeacherService teacherService;

    @RequestMapping("toTeacherListView")
    public String toStudentListView() {
        return "teacherList";
    }

    @RequestMapping("addTeacher")
    @ResponseBody
    public String addStudent(Teacher teacher, Integer clazzid) {
        teacher.setClazzId(clazzid);
        teacher.setSn(SnGenerateUtil.generateSn(clazzid));
        teacherService.insertSelective(teacher);
        return "success";
    }

    @RequestMapping("teacherList")
    @ResponseBody
    public String teacherList(String from, HttpServletRequest request, String teacherName, Integer page, Integer rows, Integer clazzid) {
        Integer pageSize = rows == null ? 999 : rows;
        Integer clazz = clazzid == null ? 0 : clazzid;
        Integer currentPage = page == null ? 1 : page;
        String name = teacherName;
        //获取当前登录用户类型
        int userType = Integer.parseInt(request.getSession().getAttribute("userType").toString());
        Teacher teacher = new Teacher();
        teacher.setName(name);
        teacher.setClazzId(clazz);
        if (userType == 3) {

            Teacher currentUser = (Teacher) request.getSession().getAttribute("user");
            teacher.setId(currentUser.getId());
        }
        List<Teacher> clazzList = teacherService.getTeacherList(teacher, new Page(currentPage, pageSize));
        int total = teacherService.getTeacherListTotal(teacher);

        Map<String, Object> ret = new HashMap<String, Object>();
        ret.put("total", total);
        ret.put("rows", clazzList);
        if ("combox".equals(from)) {
            return JSONArray.fromObject(clazzList).toString();
        } else {
            return JSONObject.fromObject(ret).toString();
        }
    }

    @RequestMapping("editTeacher")
    @ResponseBody
    public String editTeacher(Teacher teacher, Integer clazzid) {
        teacher.setClazzId(clazzid);
        teacherService.updateByPrimaryKeySelective(teacher);
        return "success";
    }

    @RequestMapping("deleteTeacher")
    @ResponseBody
    public String deleteTeacher(HttpServletRequest request,
                                HttpServletResponse response) {
        String[] ids = request.getParameterValues("ids[]");
        String idStr = "";
        for(String id : ids){
            idStr += id + ",";
        }
        idStr = idStr.substring(0, idStr.length()-1);
        teacherService.deleteByIds(idStr);
        return "success";
    }
}
