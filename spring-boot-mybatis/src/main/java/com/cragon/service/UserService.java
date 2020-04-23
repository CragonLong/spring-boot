package com.cragon.service;

import com.cragon.entity.User;

public interface UserService {
    int add(User user);

    int update(User user);

    int delete(String id);

    User findById(String id);
}
