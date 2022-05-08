package com.ssm.controller;

import com.ssm.entity.Page;
import com.ssm.entity.SelectedCourse;
import com.ssm.entity.Student;
import com.ssm.service.CourseService;
import com.ssm.service.SelectedCourseService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: ssmdemo
 * @description: ${description}
 * @anther mt
 * @creater 2021-06-24 10:25
 */
@Controller
@RequestMapping("selectedCourse")
public class SelectedCourseController {
    @Resource
    private CourseService courseService;
    @Resource
    private SelectedCourseService selectedCourseService;

    @RequestMapping("toSelectedCourseListView")
    public String toSelectedCourseListView(){
        return "selectedCourseList";
    }

    @RequestMapping("addSelectedCourse")
    @ResponseBody
    public String addSelectedCourse(Integer studentid,Integer courseid){
        studentid = studentid == null ? 0 : studentid;
        courseid = courseid == null ? 0 : courseid;

        String msg = "success";
        if(courseService.isFull(courseid)){
            msg = "courseFull";
        }
        if(selectedCourseService.isSelected(studentid, courseid)){
            msg = "courseSelected";
        }
        SelectedCourse selectedCourse = new SelectedCourse();
        selectedCourse.setStudentId(studentid);
        selectedCourse.setCourseId(courseid);
        if(selectedCourseService.insertSelective(selectedCourse)>0){
            msg = "success";
        }
        courseService.updateCourseSelectedNum(courseid, 1);
        return msg;
    }
   @RequestMapping("selectedCourseList")
   @ResponseBody
    public String selectedCourseList(String from,HttpServletRequest request,Integer studentid, Integer courseid, Integer page, Integer rows){
       int studentId = studentid == null ? 0 : studentid;
       int courseId = courseid == null ? 0 : courseid;
       Integer currentPage = page == null ? 1 :page;
       Integer pageSize = rows == null ? 999 : rows;
       SelectedCourse selectedCourse = new SelectedCourse();
       //获取当前登录用户类型
       int userType = Integer.parseInt(request.getSession().getAttribute("userType").toString());
       if(userType == 2){
           //如果是学生，只能查看自己的信息
           Student currentUser = (Student)request.getSession().getAttribute("user");
           studentId = currentUser.getId();
       }
       selectedCourse.setCourseId(courseId);
       selectedCourse.setStudentId(studentId);
       List<SelectedCourse> courseList = selectedCourseService.getSelectedCourseList(selectedCourse, new Page(currentPage, pageSize));
       int total = selectedCourseService.getSelectedCourseListTotal(selectedCourse);
       Map<String, Object> ret = new HashMap<String, Object>();
       ret.put("total", total);
       ret.put("rows", courseList);

       if("combox".equals(from)){
           return JSONArray.fromObject(courseList).toString();
       }else{
           return JSONObject.fromObject(ret).toString();
       }

    }
   @RequestMapping("deleteSelectedCourse")
   @ResponseBody
    public String deleteSelectedCourse(Integer id){
       SelectedCourse selectedCourse = selectedCourseService.selectByPrimaryKey(id);
       selectedCourseService.deleteByPrimaryKey(id);
        courseService.updateCourseSelectedNum(selectedCourse.getCourseId(),-1);
        return "success";
    }
}
