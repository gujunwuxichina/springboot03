package com.gujun.springboot03.controller.testAdvice;

import com.alibaba.fastjson.JSONObject;
import com.gujun.springboot03.entity.Employee;
import com.gujun.springboot03.entity.EmployeeVO;
import com.gujun.springboot03.exception.NotFoundException;
import com.gujun.springboot03.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.thymeleaf.util.DateUtils;

import java.util.Date;
import java.util.Locale;

@RequestMapping("advice")
@RestController
public class AdviceController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/testException")
    public void testException(){
        throw new RuntimeException();
    }

    @GetMapping("/testInitModel1")
    public JSONObject testInitModel1(ModelMap modelMap){
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("value",modelMap.get("name").toString());
        return jsonObject;
    }

    @GetMapping("/testInitModel2")
    public JSONObject testInitModel2(EmployeeVO employeeVO){
        JSONObject jsonObject=new JSONObject();
        System.out.println(employeeVO);
        jsonObject.put("employeeVO",employeeVO);
        return jsonObject;
    }

    @GetMapping("/goAdvice")
    public ModelAndView goAdvice(){
        ModelAndView mv=new ModelAndView();
        mv.setViewName("advice/advice");
        return mv;
    }

    @GetMapping("/testDate")    //post请求不行 ？？
    public JSONObject testDate(@RequestParam("date") Date date){
        JSONObject jsonObject=new JSONObject();
        System.out.println(DateUtils.format(date,"yyyy-MM-dd", Locale.CHINA));
        jsonObject.put("result","success");
        return jsonObject;
    }

    @PostMapping("/query")
    public JSONObject query(@RequestBody Employee employee){
        JSONObject jsonObject=new JSONObject();
        Integer eId=employee.geteId();
        employee=employeeService.getById(eId);
        if(employee==null){
            throw new NotFoundException("找不到员工ID为"+eId+"的信息");
        }
        return jsonObject;
    }

}
