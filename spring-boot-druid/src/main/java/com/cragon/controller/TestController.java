package com.cragon.controller;

import com.cragon.entity.Student;
import com.cragon.service.MyBatisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @Autowired
    private MyBatisService myBatisService;

    @GetMapping("/get")
    public Student get(String id) {
        return myBatisService.findById(id);
    }
}
