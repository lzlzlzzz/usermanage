package com.atguigu.mapper;

import com.atguigu.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

public interface UserMapper {

    public User queryUserById(Long id);

    public Long queryCount();

    public List<User> queryUserAll();

    public int insertUser(User user);

    public int editUser(User user);

    public int deleteUser(@Param("ids") List<Long> ids);

    public int deleteUserById(Long id);
}
