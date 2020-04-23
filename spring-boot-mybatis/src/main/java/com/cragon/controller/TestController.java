package com.cragon.controller;

import com.cragon.entity.User;
import com.cragon.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @Autowired
    private UserService userService;

    @GetMapping("/find")
    public User findById(String id) {
        return userService.findById(id);
    }
}
