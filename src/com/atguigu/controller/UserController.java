package com.atguigu.controller;

import com.atguigu.pojo.User;
import com.atguigu.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

//    @RequestMapping("users")
//    public String toUsers(){
//        return "users";
//    }

    @GetMapping("list")
    @ResponseBody
    public Map<String,Object> queryUserAll(){
        return userService.queryUserAll();
    }

//    @GetMapping("page/add")
//    public String toUserAdd(){
//        return "user-edit";
//    }

//    @RequestMapping("page/{pageName}")
//    public String toPage(@PathVariable("pageName")String pageName){
//        return pageName;
//    }

    @PostMapping("save")
    @ResponseBody
    public Map<String,Object> savaUser(@Valid User user, BindingResult result){
        Map<String, Object> map = new HashMap<>();
        if (result.hasErrors()){
            result.getAllErrors().forEach(error->{
                System.out.println(error.getDefaultMessage());
            });
            map.put("status",500);
            return map;
        }
        Boolean b = this.userService.saveUser(user);
        if (b){
            map.put("status",200);
        } else {
            map.put("status",500);
        }
        return map;
    }

    @PostMapping("edit")
    @ResponseBody
    public Map<String,Object> editUser(User user){
        Map<String, Object> map = new HashMap<>();
        Boolean b = this.userService.editUser(user);
        if (b){
            map.put("status",200);
        } else {
            map.put("status",500);
        }
        return map;
    }

    @PostMapping("delete")
    @ResponseBody
    public Map<String,Object> deleteUser(@RequestParam("ids") List<Long> ids){
        Map<String, Object> map = new HashMap<>();
        Boolean b = this.userService.deleteUser(ids);
        if (b){
            map.put("status",200);
        }else {
            map.put("status",500);
        }
        return map;
    }
}
