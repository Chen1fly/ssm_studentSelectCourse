package com.ssm.controller;

import com.ssm.entity.Page;
import com.ssm.entity.Course;
import com.ssm.service.CourseService;
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
 * @creater 2021-06-24 11:53
 */
@Controller
@RequestMapping("course")
public class CourseController {
    @Resource
    private CourseService courseService;
    @RequestMapping("toCourseListView")
    public String toCourseListView() {
        return "courseList";
    }

    @RequestMapping("addCourse")
    @ResponseBody
    public String addCourse(String name,Integer teacherid,Integer maxnum,String course_date,String info) {
        Course course = new Course();
        course.setName(name);
        course.setTeacherId(teacherid);
        course.setInfo(info);
        course.setMaxNum(maxnum);
        course.setCourseDate(course_date);
        courseService.insertSelective(course);
        return "success";
    }

    @RequestMapping("courseList")
    @ResponseBody
    public String courseList(String from, HttpServletRequest request, String name, Integer page, Integer rows,Integer teacherid) {
        Integer pageSize = rows == null ? 999 : rows;
        Integer currentPage = page == null ? 1 : page;
        int teacherId = teacherid == null ? 0 : teacherid;
        //获取当前登录用户类型
        int userType = Integer.parseInt(request.getSession().getAttribute("userType").toString());
        Course course = new Course();
        course.setName(name);
        course.setTeacherId(teacherId);
        List<Course> clazzList = courseService.getCourseList(course, new Page(currentPage, pageSize));
        int total = courseService.getCourseListTotal(course);

        Map<String, Object> ret = new HashMap<String, Object>();
        ret.put("total", total);
        ret.put("rows", clazzList);
        if ("combox".equals(from)) {
            return JSONArray.fromObject(clazzList).toString();
        } else {
            return JSONObject.fromObject(ret).toString();
        }
    }

    @RequestMapping("editCourse")
    @ResponseBody
    public String editCourse(String name, Integer maxnum, Integer teacherid,Integer id ,String courseDate,String info) {
        Course course = new Course();
        course.setId(id);
        course.setName(name);
        course.setTeacherId(teacherid);
        course.setInfo(info);
        course.setCourseDate(courseDate);
        course.setMaxNum(maxnum);

        courseService.updateByPrimaryKeySelective(course);
        return "success";
    }

    @RequestMapping("deleteCourse")
    @ResponseBody
    public String deleteCourse(HttpServletRequest request,
                                HttpServletResponse response) {
        String[] ids = request.getParameterValues("ids[]");
        String idStr = "";
        for(String id : ids){
            idStr += id + ",";
        }
        idStr = idStr.substring(0, idStr.length()-1);
        courseService.deleteByIds(idStr);
        return "success";
    }
}
