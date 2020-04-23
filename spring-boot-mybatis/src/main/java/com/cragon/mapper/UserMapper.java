package com.cragon.mapper;

import com.cragon.entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface UserMapper {
    @Insert("insert into sys_user (id, user_name, real_name) values (#{id}, #{username}, #{realName})")
    int add(User user);

    @Update("update sys_user set username=#{username}, real_name=#{realName} where id=#{id}")
    int update(User user);

    @Delete("delete from sys_user where id=#{id}")
    int deleteById(String id);

    @Select("select * from sys_user where id=#{id}")
    @Results({
            @Result(property = "id", column = "id", javaType = String.class),
            @Result(property = "username", column = "user_name", javaType = String.class),
            @Result(property = "realName", column = "real_name", javaType = String.class)
    })
    User findById(String id);
}
