package com.atguigu.test;

import com.atguigu.pojo.User;
import com.atguigu.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/applicationContext.xml","classpath:spring/applicationContext-tx.xml","classpath:spring/applicationContext-mybatis.xml"})
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void testSaveUsers(){
        User user1 = new User();
        user1.setUserName("aaaaaa");
        user1.setName("安安");
        user1.setPassword("1234");
        User user2 = new User();
        user2.setUserName("bbbbbb");
        user2.setName("奥奥");
        user2.setPassword("1234");
        this.userService.saveUsers(user1,user2);
    }
}
