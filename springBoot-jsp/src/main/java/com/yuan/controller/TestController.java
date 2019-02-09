package com.yuan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by IntelliJ IDEA.
 * User: jinshengyuan
 * Date: 2018-10-18
 * Time: 13:18
 * description:
 **/
@Controller
public class TestController {

    @ResponseBody
    @RequestMapping("/hello")
    public String sayHello(){
        return "Hello World!";
    }

    @RequestMapping("/abc")
    public String getStr(){
        return "success";
    }

    @RequestMapping("/getStr2")
    @ResponseBody
    public String getStr2(){
        return "这是字符串";
    }


}
