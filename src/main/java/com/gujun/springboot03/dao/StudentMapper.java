package com.gujun.springboot03.dao;

import com.gujun.springboot03.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentMapper {

    List<Student> getAll();

    Student getById(Integer sId);

    int saveOne(Student student);

    int update(Student student);

    int deleteById(Integer sId);

}
