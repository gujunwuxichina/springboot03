package com.gujun.springboot03.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.gujun.springboot03.entity.EmployeeVO;
import com.gujun.springboot03.exception.NotFoundException;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.text.SimpleDateFormat;
import java.util.Date;

//该注解也标注了@Controller，会被SpringIoC扫描和装配；
@ControllerAdvice(basePackages = {"com.gujun.springboot03.controller.testAdvice.*"},annotations = RestController.class)
public class MyControllerAdvice {

    //给控制器添加通知：
    //在SpringAOP中可以通过通知来增强Bean，同样SpringMVC也可以给控制器增加通知，在控制器方法前后和异常发生时执行不同的处理；
    //@ControllerAdvice,定义一个控制器的通知类,定义一些关于增强控制器的各类通知和限定增强哪些控制器的功能；
    //@InitBinder,定制控制器参数绑定规则，如转换规则，格式化等，在参数转换之前执行；
    //@ExceptionHandler,定义控制器发生异常后的操作；
    //ModelAttribute,在控制器方法执行前，对数据模型进行操作；

    //绑定格式化，参数转换规则和增加验证等；
    @InitBinder
    public void initDataBinder(WebDataBinder binder){
        CustomDateEditor customDateEditor=new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"),false);   //限定格式，且参数不允许为空；
        binder.registerCustomEditor(Date.class,customDateEditor);
    }

    //在执行控制器之前，初始化数据模型
    @ModelAttribute
    public void initModel1(Model model){
        model.addAttribute("name","gujun");
    }

    @ModelAttribute
    public void initModel2(EmployeeVO employeeVO){
        employeeVO.seteId(1);
    }

    //异常处理
    @ExceptionHandler(value = Exception.class)
    public String exceptionHandler1(Model model,Exception ex){
        System.out.println(ex);
        //model.addAttribute("exMessage",ex.getMessage());
        System.out.println("出错了!");
        return "exception/exception";
    }

    @ExceptionHandler(value = MethodArgumentTypeMismatchException.class)
    @ResponseBody
    public JSONObject exceptionHandler2(Model model,Exception ex){
        System.out.println(ex.getClass());
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("error","格式错误!");
        return jsonObject;
    }

    @ExceptionHandler(value = NotFoundException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)   //定义服务器错误状态码500
    public JSONObject notFound(NotFoundException ex){
        System.out.println(ex.getClass());
        JSONObject jsonObject=new JSONObject();
        System.out.println(ex.getErrorMsg());
        jsonObject.put("error",ex.getErrorMsg());
        return jsonObject;
    }

}
