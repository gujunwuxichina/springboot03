package com.gujun.springboot03.controller;

import com.alibaba.fastjson.JSONObject;
import com.gujun.springboot03.entity.Employee;
import com.gujun.springboot03.entity.EmployeeVO;
import com.gujun.springboot03.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RequestMapping("employee")
@RestController
public class EmployeeRestController {

    /*
        REST风格网站：
        在REST风格中，每一个资源都只是对应一个网址，且代表资源的网址应该是个名词而不是动词，代表对一个资源的操作；
        该风格下对于简易参数尽量通过网址进行传递；如获取id为1的uset .../user/1;
        若参数数量多(一般超过5个)可以考虑传递JSON数据；
        资源，一个具体存在的对象，可以用一个URI指向它，每个资源对应一个特定的URI;
        表现层，有了资源还需要确定如何表现这个资源；
        状态转换，资源不是一成不变的，一个资源可以经历创建、访问、修改、删除；对于HTTP协议，是一个没有状态的协议，
        意味着对于资源的状态变化只能在服务端保存和变化，好在HTTP中存在许多动作对应这些变化；

        使用SpringMVC开发REST风格；
        Spring为此除了@RequestMapping外，还提供如下注解：
        @GetMapping,@PostMapping,
        @PutMapping,@PatchMapping,@DeleteMapping;
        以上五个注解分别对应HTTP动作；


     */

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/goEmployee")
    public ModelAndView goEmployee(){
        ModelAndView mv=new ModelAndView();
        mv.setViewName("employee/employee");
        return mv;
    }

    @GetMapping("/employee/{eId}")    //rest风格
    public JSONObject getById(@PathVariable("eId") Integer eId){
        JSONObject jsonObject=new JSONObject();
        try {
            Employee employee=employeeService.getById(eId);
            jsonObject.put("employee",employee);
            jsonObject.put("result","success");
        } catch (Exception e) {
            e.printStackTrace();
            jsonObject.put("result","error");
        }
        return jsonObject;
    }

    @PostMapping("/employee")
    public JSONObject post1(@RequestBody Employee employee){
        JSONObject jsonObject=new JSONObject();
        try {
            List<Employee> employers=employeeService.post1(employee);
            jsonObject.put("employers",employers);
            jsonObject.put("result","success");
        } catch (Exception e) {
            e.printStackTrace();
            jsonObject.put("result","error");
        }

        return jsonObject;
    }

    @PostMapping("/employee/{eName}/{eSex}")
    public JSONObject post2(@PathVariable("eName") String eName,@PathVariable("eSex") int eSex){
        JSONObject jsonObject=new JSONObject();
        try {
            EmployeeVO employeeVO=new EmployeeVO();
            employeeVO.seteName(eName);
            employeeVO.seteSex(eSex);
            List<Employee> employers=employeeService.post2(employeeVO);
            jsonObject.put("employers",employers);
            jsonObject.put("result","success");
        } catch (Exception e) {
            e.printStackTrace();
            jsonObject.put("result","error");
        }

        return jsonObject;
    }

}
