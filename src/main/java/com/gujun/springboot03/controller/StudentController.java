package com.gujun.springboot03.controller;

import com.alibaba.fastjson.JSONObject;
import com.gujun.springboot03.entity.Student;
import com.gujun.springboot03.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RequestMapping("student")
@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping("/getAll")
    public JSONObject getAll(){
        JSONObject jsonObject=new JSONObject();
        try {
            List<Student> students=studentService.getAll();
            jsonObject.put("students",students);
            jsonObject.put("result","success");
        } catch (Exception e) {
            e.printStackTrace();
            jsonObject.put("result","error");
        }
        return jsonObject;
    }

    @RequestMapping("/goStudent")
    public ModelAndView goStudent(){
        ModelAndView mv=new ModelAndView();
        mv.setViewName("student/student.html");
        return mv;
    }

    @RequestMapping("/goStudentJsp")
    public ModelAndView goStudentJsp(){
        ModelAndView mv=new ModelAndView();
        mv.setViewName("jsp/student/student");
        return mv;
    }

}
