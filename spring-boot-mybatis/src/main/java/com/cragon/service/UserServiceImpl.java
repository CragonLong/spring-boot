package com.cragon.service;

import com.cragon.entity.User;
import com.cragon.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public int add(User user) {
        return userMapper.add(user);
    }

    @Override
    public int update(User user) {
        return userMapper.update(user);
    }

    @Override
    public int delete(String id) {
        return userMapper.deleteById(id);
    }

    @Override
    public User findById(String id) {
        return userMapper.findById(id);
    }
}
