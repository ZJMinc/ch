package com.usts.ch.controller;

import com.usts.ch.pojo.User;
import com.usts.ch.result.Result;
import com.usts.ch.result.ResultUtil;
import com.usts.ch.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @CrossOrigin
    @PostMapping("/api/register")
    public User add(@RequestBody User user) throws Exception{
        user.setPermissions("0");
        Date date = new Date();
        long time = date.getTime();//当前时间的毫秒数
        user.setCreatetime(time);
        userService.addOrUpdate(user);
        System.out.print(user);
        return user;
    }

    @CrossOrigin
    @PostMapping("/api/user/{id}")
    public User update(@RequestBody User user) throws Exception{
        userService.addOrUpdate(user);
        System.out.print(user);
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
