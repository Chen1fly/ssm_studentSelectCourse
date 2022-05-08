package com.ssm.controller;

import com.lizhou.exception.FileFormatException;
import com.lizhou.exception.NullFileException;
import com.lizhou.exception.ProtocolException;
import org.apache.commons.fileupload.FileUploadException;
import com.lizhou.exception.SizeException;
import com.lizhou.fileload.FileUpload;
import com.ssm.entity.Student;
import com.ssm.entity.Teacher;
import com.ssm.service.StudentService;
import com.ssm.service.TeacherService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @program: ssmdemo
 * @description: ${description}
 * @anther mt
 * @creater 2021-06-23 11:50
 */
@Controller
@RequestMapping("photo")
public class PhotoController {

    @Resource
    private StudentService studentService;
    @Resource
    private TeacherService teacherService;

    //展示照片
    @RequestMapping("getPhoto")
    public void getPhoto(Integer sid, Integer tid, HttpServletResponse response
    , HttpServletRequest request){
        sid = sid == null ?0:sid;
        tid = tid == null ?0:tid;
        InputStream photo = null;
        if(sid != 0){
            //学生
            Student student = studentService.selectByPrimaryKey(sid);
            if(student != null){
              photo = student.getPhoto();
            }
        }
        if(tid != 0){
            //教师
            Teacher teacher = teacherService.selectByPrimaryKey(tid);
            if(teacher != null){
                photo = teacher.getPhoto();
            }
        }
        if(photo != null){
            try {
                byte[] b = new byte[photo.available()];
                photo.read(b);
                response.getOutputStream().write(b,0,b.length);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            return;
        }
        String path = request.getSession().getServletContext().getRealPath("");
        File file = new File(path+"\\file\\logo.jpg");
        try {
            FileInputStream fis = new FileInputStream(file);
            byte[] b = new byte[fis.available()];
            fis.read(b);
            response.getOutputStream().write(b,0,b.length);

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    //上传照片
    @RequestMapping("setPhoto")
    @ResponseBody
    public String setPhoto(Integer sid,Integer tid,HttpServletRequest request,HttpServletResponse response){
        sid = sid == null ?0:sid;
        tid = tid == null ?0:tid;
        FileUpload fileUpload = new FileUpload(request);
        fileUpload.setFileFormat("jpg");
        fileUpload.setFileFormat("png");
        fileUpload.setFileFormat("jpeg");
        fileUpload.setFileFormat("gif");
        fileUpload.setFileSize(2048);
        response.setCharacterEncoding("UTF-8");
        try {
            InputStream uploadInputStream = fileUpload.getUploadInputStream();
            int num = 0;
            if(sid != 0){
                Student student = new Student();
                student.setId(sid);
                student.setPhoto(uploadInputStream);
                num = studentService.updateByPrimaryKeySelective(student);
            }
            if(tid != 0){
                Teacher teacher = new Teacher();
                teacher.setId(tid);
                teacher.setPhoto(uploadInputStream);
                num = teacherService.updateByPrimaryKeySelective(teacher);
            }
            if(num>0){
                return "<div id='message'>上传成功！</div>";
            }else{
                return "<div id='message'>上传失败！</div>";
            }
            
        } catch (ProtocolException e) {
            // TODO Auto-generated catch block
            try {
                response.getWriter().write("<div id='message'>上传协议错误！</div>");
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            e.printStackTrace();
        }catch (NullFileException e1) {
            // TODO: handle exception
            try {
                response.getWriter().write("<div id='message'>上传的文件为空!</div>");
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            e1.printStackTrace();
        }
        catch (SizeException e2) {
            // TODO: handle exception
            try {
                response.getWriter().write("<div id='message'>上传文件大小不能超过"+fileUpload.getFileSize()+"！</div>");
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            e2.printStackTrace();
        }
        catch (IOException e3) {
            // TODO: handle exception
            try {
                response.getWriter().write("<div id='message'>读取文件出错！</div>");
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            e3.printStackTrace();
        }
        catch (FileFormatException e4) {
            // TODO: handle exception
            try {
                response.getWriter().write("<div id='message'>上传文件格式不正确，请上传 "+fileUpload.getFileFormat()+" 格式的文件！</div>");
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            e4.printStackTrace();
        }
        catch (FileUploadException e5) {
            // TODO: handle exception
            try {
                response.getWriter().write("<div id='message'>上传文件失败！</div>");
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            e5.printStackTrace();
        }
        return "";
    }
}
