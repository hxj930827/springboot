/**
 * FileName: HelloController
 * Author:   韩旭杰
 * Date:     2018/9/27 11:18
 * Description: 测试springboot控制层
 */
package com.example.springboot;

import com.example.springboot.resource.ResourceModel;
import com.example.util.ImoocJSONResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * 说明：〈测试springboot控制层〉
 *
 * @author 韩旭杰
 * @create 2018/9/27
 * @since 1.0.0
 */
//@RestController //该注解是 @Controller 和 @ResponseBody 注解的合体版
@Controller
public class HelloController {

    //定义一个全局的记录器，通过LoggerFactory获取
    private final static Logger logger = LoggerFactory.getLogger(HelloController.class);
    @Autowired
    private ResourceModel resourceModel;
    @RequestMapping("/hello")
    @ResponseBody // 返回json
    public String hello() {
        return "B";
    }

    @RequestMapping("/resource")
    @ResponseBody // 返回json
    public ImoocJSONResult resource(){
        ResourceModel resourceModel1=new ResourceModel();
        resourceModel1.setLanguage(resourceModel.getLanguage());
        resourceModel1.setName(resourceModel.getName());
        resourceModel1.setWebSite(resourceModel.getWebSite());
        return ImoocJSONResult.ok(resourceModel1);
    }
    @RequestMapping("/helloWord")
    public String hello(Model model){
        model.addAttribute("now", DateFormat.getDateTimeInstance().format(new Date()));
        model.addAttribute("name","beetl");
        model.addAttribute("age",null);
        model.addAttribute("newDate",new Date());
        List list=new ArrayList(5);
        list.add("1");
        list.add("2");
        list.add("3");
        model.addAttribute("list",list);
        return "beetl/addBeetlb";
    }
    @RequestMapping("/hw")
    public String hw(Model model){
        model.addAttribute("now", DateFormat.getDateTimeInstance().format(new Date()));
        model.addAttribute("name","jsp");
        logger.info("logback 成功了");
        logger.error("logback 成功了");
        return "helloWord.jsp";
    }

    @RequestMapping("/echarts")
    public String echarts(Model model){
        model.addAttribute("now", DateFormat.getDateTimeInstance().format(new Date()));
        model.addAttribute("name","jsp");
        return "echarts/echartsDemo1";
    }

}
