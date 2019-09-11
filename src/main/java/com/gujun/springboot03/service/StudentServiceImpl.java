package com.gujun.springboot03.service;

import com.gujun.springboot03.dao.StudentMapper;
import com.gujun.springboot03.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    /*
        sprint-redis缓存详见ssm02;
        
     */
    @Override
    @Cacheable(value = "cacheLimit",key = "'students'")
    public List<Student> getAll() {
        return studentMapper.getAll();
    }

    @Override
    public Student getById(Integer sId) {
        return studentMapper.getById(sId);
    }

    @Override
    public int saveOne(Student student) {
        return studentMapper.saveOne(student);
    }

    @Override
    public int update(Student student) {
        return studentMapper.update(student);
    }

    @Override
    public int deleteById(Integer sId) {
        return studentMapper.deleteById(sId);
    }

}
