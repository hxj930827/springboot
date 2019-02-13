/**
 * FileName: MybatisController
 * Author:   韩旭杰
 * Date:     2018/11/14 9:48
 * Description: 测试mybatis
 */
package com.example.springboot.city.student.controller;

import com.example.springboot.city.student.model.Student;
import com.example.springboot.city.student.service.StudentService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONArray;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 说明：〈测试mybatis〉
 *
 * @author 韩旭杰
 * @create 2018/11/14
 * @since 1.0.0
 */
@RequestMapping(value = "/mybatis/")
@Controller
public class MybatisController {
    private static ObjectMapper objectMapper = new ObjectMapper();
    @Autowired
    private StudentService studentService;
    @RequestMapping(value = "addStudent")
    public String addStudent(HttpServletRequest request, HttpServletResponse response){
        PageInfo<Student> pageInfo =studentService.getInfo();
        List<Student> list=pageInfo.getList();
        return null;
    }

    @RequestMapping(value = "echartsIndex")
    public ModelAndView echartsIndex(){
        ModelAndView mv=new ModelAndView();
        String info[]={"衬衫","羊毛衫","裤子","上衣","高跟鞋","袜子"};
        int data[]={5,29,36,10,10,20};
        Map<String,Object> map=new HashMap<>();
        map.put("info",info);
        map.put("data",data);
        mv.setViewName("echarts/echartsDemo1");
        mv.addObject("mapJson",toStr(data));
        mv.addObject("name",toStr(map));
        mv.addObject("map",map);
        return mv;
    }

    public static String toStr(Object obj) {
        String json_str = "";
        try {
            objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
            json_str = objectMapper.writer().writeValueAsString(obj);
        } catch (Exception e) {

        }
        return json_str;
    }

    public void outJson(HttpServletResponse response, Object obj) {
        try {
            response.setContentType("application/json; charset=UTF-8");
            response.getWriter().println(obj);
        } catch (Exception e) {
        }
    }

    /**
     * 使用数组，后者集合都可以放入到map中，返回到前台（亲测）
     * @param response
     */
   // @ResponseBody
    @RequestMapping(value = "echartsDemo1")
    public void echartsDemo1(HttpServletResponse response){
        String info[]={"衬衫","羊毛衫","裤子","上衣","高跟鞋","袜子"};
        List<String> resultList= new ArrayList<>(Arrays.asList(info));
        Integer data[]={5,29,36,10,10,20};
        List<Integer> resultListOne= new ArrayList<>(Arrays.asList(data));
        Map<String,Object> map=new HashMap<>();
        map.put("info",resultList);
        map.put("data",resultListOne);
        String strJson=toStr(map);
        outJson(response,strJson);
        //return map;
    }
}
