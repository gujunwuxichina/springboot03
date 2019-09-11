package com.gujun.springboot03.service;


import com.gujun.springboot03.entity.Student;

import java.util.List;

public interface StudentService {

    List<Student> getAll();

    Student getById(Integer sId);

    int saveOne(Student student);

    int update(Student student);

    int deleteById(Integer sId);

}
