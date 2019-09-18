package com.gujun.springboot03.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("header")
@RestController
public class GetHeaderController {

    //获取请求头参数：
    //可以通过注解@RequestHeader来获取；

    @RequestMapping("/goHeader")
    public ModelAndView goHeader(){
        ModelAndView mv=new ModelAndView();
        mv.setViewName("header/header");
        return mv;
    }

    @RequestMapping("/getHeader")
    public JSONObject getHeader(@RequestHeader(value = "myName",required = false) String myName){
        JSONObject jsonObject=new JSONObject();
        System.out.println(myName);
        jsonObject.put("myName",myName);
        return jsonObject;
    }

}
