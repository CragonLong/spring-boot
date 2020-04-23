package com.cragon.service;

import com.cragon.entity.Student;
import com.cragon.mysql.dao.UserMapper;
import com.cragon.oracle.dao.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyBatisServiceImpl implements MyBatisService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private StudentMapper studentMapper;

    @Override
    public Student findById(String id) {
        if (id.length() > 3) {
            return userMapper.findById(id);
        } else {
            return studentMapper.findById(id);
        }
    }
}
