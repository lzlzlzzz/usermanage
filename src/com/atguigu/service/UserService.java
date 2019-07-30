package com.atguigu.service;

import com.atguigu.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserService {

    public Map<String,Object> queryUserAll();

    public void saveUsers(User user1, User user2);

    public Boolean saveUser(User user);

    public Boolean editUser(User user);

    public Boolean deleteUser(List<Long> ids);

    public User queryUserById(Long id);

    public Boolean deleteUserById(Long id);

    public List<User> queryUser();
}
