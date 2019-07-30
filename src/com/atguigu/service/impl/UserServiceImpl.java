package com.atguigu.service.impl;

import com.atguigu.mapper.UserMapper;
import com.atguigu.pojo.User;
import com.atguigu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;

    @Override
    public Map<String, Object> queryUserAll() {
        Map<String, Object> map = new HashMap<>();
        map.put("total",userMapper.queryCount());
        map.put("rows",userMapper.queryUserAll());
        return map;
    }


    public void saveUsers(User user1,User user2){
        this.userMapper.insertUser(user1);
//        int i = 1 / 0;
        this.userMapper.insertUser(user2);
    }

    @Override
    public Boolean saveUser(User user) {
        return this.userMapper.insertUser(user) == 1;
    }

    @Override
    public Boolean editUser(User user) {
        return this.userMapper.editUser(user) == 1;
    }

    @Override
    public Boolean deleteUser(List<Long> ids) {
        return this.userMapper.deleteUser(ids) > 0;
    }

    @Override
    public User queryUserById(Long id) {
        return this.userMapper.queryUserById(id);
    }

    @Override
    public Boolean deleteUserById(Long id) {
        return this.userMapper.deleteUserById(id) == 1;
    }

    @Override
    public List<User> queryUser() {
        return this.userMapper.queryUserAll();
    }

}
