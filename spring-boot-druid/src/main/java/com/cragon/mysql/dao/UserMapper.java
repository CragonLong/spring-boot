package com.cragon.mysql.dao;

import com.cragon.entity.Student;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface UserMapper {
    Student findById(String id);
}
