package com.gujun.springboot03.service;

import com.gujun.springboot03.dao.EmployeeMapper;
import com.gujun.springboot03.entity.Employee;
import com.gujun.springboot03.entity.EmployeeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public Employee getById(Integer eId) {
        return employeeMapper.getById(eId);
    }

    @Override
    public List<Employee> post1(Employee employee) {
        return employeeMapper.post1(employee);
    }

    @Override
    public List<Employee> post2(EmployeeVO employeeVO) {
        return employeeMapper.post2(employeeVO);
    }

    @Override
    public int update(EmployeeVO employeeVO) {
        return employeeMapper.update(employeeVO);
    }

    @Override
    public int deleteById(Integer eId) {
        return employeeMapper.deleteById(eId);
    }

    @Override
    public int saveOne(EmployeeVO employeeVO) {
        return employeeMapper.saveOne(employeeVO);
    }

}
