package com.gujun.springboot03.service;

import com.gujun.springboot03.entity.Employee;
import com.gujun.springboot03.entity.EmployeeVO;

import java.util.List;

public interface EmployeeService {

    Employee getById(Integer eId);

    List<Employee> post1(Employee employee);

    List<Employee> post2(EmployeeVO employeeVO);

}
