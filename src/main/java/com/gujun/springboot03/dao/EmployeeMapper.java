package com.gujun.springboot03.dao;

import com.gujun.springboot03.entity.Employee;
import com.gujun.springboot03.entity.EmployeeVO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeMapper {

    Employee getById(Integer eId);

    List<Employee> post1(Employee employee);

    List<Employee> post2(EmployeeVO employeeVO);

    int update(EmployeeVO employeeVO);

    int deleteById(Integer eId);

    int saveOne(EmployeeVO employeeVO);

}
