package com.gujun.springboot03.controller;

import com.alibaba.fastjson.JSONObject;
import com.gujun.springboot03.entity.Employee;
import com.gujun.springboot03.entity.EmployeeVO;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("restTemplate")
@RestController
public class RestTemplateTestController {

    /*
        当今微服务中，会将一个大系统拆分成多个微服务系统，每个微服务系统都会暴露REST风格的URI请求给别的微服务系统所调用；
        为了方便完成系统之间的相互调用，Spring提供了RestTemplate模板类，通过它可以方便地对REST请求进行系统之间的调用，完成
        系统之间的数据集成；Spring Cloud中还可以进行声明式调用，后有；
        RestTemplate底层是通过HttpURLConnection实现的；✳

     */

    //get请求 单个参数
    @GetMapping("/get01")
    public JSONObject get01(){
        RestTemplate restTemplate=new RestTemplate();
        return restTemplate.getForObject("http://127.0.0.1:8099/employee/employee/{eId}",JSONObject.class,1);
    }

    //get请求 多个参数
    @GetMapping("/get02")
    public JSONObject get02(){
        RestTemplate restTemplate=new RestTemplate();
        Map<String,Object> map=new HashMap<>();
        map.put("eId",1);
        return restTemplate.getForObject("http://127.0.0.1:8099/employee/employee/{eId}", JSONObject.class,map);
    }

    @GetMapping("/goRestTemplate")
    public ModelAndView goRestTemplate(){
        ModelAndView mv=new ModelAndView();
        mv.setViewName("restTemplate/restTemplate");
        return mv;
    }

    //通过post请求传递JSON请求体(Body)
    @PostMapping("/post01")
    public ResponseEntity<EmployeeVO> post01(@RequestBody EmployeeVO employeeVO){
        HttpHeaders headers=new HttpHeaders();
        //设置请求内容为JSON类型
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        //创建请求实体对象
        HttpEntity<EmployeeVO> httpEntity=new HttpEntity<>(employeeVO,headers);
        RestTemplate restTemplate=new RestTemplate();
        ResponseEntity<EmployeeVO> responseEntity=restTemplate.postForEntity("http://127.0.0.1:8099/employee/saveOne1",httpEntity,EmployeeVO.class);;
        System.out.println(responseEntity.getBody());   //响应体
        return responseEntity;
    }

    /*

        获取响应头、状态码和资源交换：
        RestTemplate的postForEntity(),将会返回一个ResponseEntity对象，该对象包含了服务器返回的响应体、状态码、响应头；
        RestTemplate还有一个exchange(),可以作为资源交互使用，可以根据需要定制更多参数；
        HH，推荐postForEntity()/getForEntity()；
     */

}
