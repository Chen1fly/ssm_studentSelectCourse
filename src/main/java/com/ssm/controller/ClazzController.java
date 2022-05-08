package com.ssm.controller;

import com.ssm.entity.Clazz;
import com.ssm.entity.Page;
import com.ssm.service.ClazzService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: ssmdemo
 * @description: ${description}
 * @anther mt
 * @creater 2021-06-23 11:49
 */
@Controller
@RequestMapping("clazz")
public class ClazzController {

    @Resource
    private ClazzService clazzService;

    /**
     * 跳转班级列表页面
     *
     * @return
     */
    @RequestMapping("toClazzListView")
    public String toClazzListView() {
        return "clazzList";
    }

    /**
     * 分页查询班级列表数据
     *
     * @param clazzName 班级名称
     * @param rows 一页行数
     * @param page 当前页
     * @param from 是否复杂表单
     * @return
     */
    @RequestMapping("getClazzList")
    @ResponseBody
    public String getClazzList(String clazzName, Integer rows, Integer page, String from) {

        Integer currentPage = page == null ? 1 : page;
        Integer pageSize = rows == null ? 999 : rows;
        Clazz clazz = new Clazz();
        clazz.setName(clazzName);
        //获取列表数据
        List<Clazz> clazzList = clazzService.getClazzList(clazz, new Page(currentPage, pageSize));
        //获取总的条数
        int total = clazzService.getClazzListTotal(clazz);
        Map<String, Object> ret = new HashMap<String, Object>();
        ret.put("total", total);
        ret.put("rows", clazzList);
        if ("combox".equals(from)) {
            return JSONArray.fromObject(clazzList).toString();
        } else {
            return JSONObject.fromObject(ret).toString();
        }
    }

    /**
     * 添加班级
     * @param name
     * @param info
     * @return
     */
    @RequestMapping("addClazz")
    @ResponseBody
    public String addClazz(String name,String info) {
        Clazz clazz = new Clazz();
        clazz.setName(name);
        clazz.setInfo(info);
        //执行添加班级的操作
        clazzService.insertSelective(clazz);
        return "success";
    }

    /**
     * 删除对应的班级信息
     * @param clazzid 班级id
     * @return
     */
    @RequestMapping("deleteClazz")
    @ResponseBody
    public String deleteClazz(Integer clazzid) {
        clazzService.deleteByPrimaryKey(clazzid);
        return "success";
    }

    /**
     * 修改班级信息
     * @param id 班级id
     * @param name 班级名称
     * @param info 班级信息
     * @return
     */
    @RequestMapping("editClazz")
    @ResponseBody
    public String editClazz(Integer id,String name,String info) {
        Clazz clazz = new Clazz();
        clazz.setName(name);
        clazz.setInfo(info);
        clazz.setId(id);
        clazzService.updateByPrimaryKeySelective(clazz);
        return "success";
    }
}
