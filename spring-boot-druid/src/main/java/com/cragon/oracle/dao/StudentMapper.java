package com.cragon.oracle.dao;

import com.cragon.entity.Student;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface StudentMapper {
    Student findById(String id);
}
