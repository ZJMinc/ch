package com.usts.ch.controller;

import com.usts.ch.pojo.User;
import com.usts.ch.result.Result;
import com.usts.ch.result.ResultUtil;
import com.usts.ch.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @CrossOrigin
    @PostMapping("/api/register")
    public User addOrUpdate(@RequestBody User user) throws Exception{
        userService.addOrUpdate(user);
        return user;
    }

    @CrossOrigin
    @GetMapping("/api/user/{id}")
    public Result getUser(@PathVariable("id") Integer id){
        User user = userService.getInfo(id);
        if (user != null){
            return ResultUtil.success(user);
        }else{
            return ResultUtil.error(400,"该用户不存在");
        }
    }
}
