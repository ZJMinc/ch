package com.usts.ch.controller;

import com.usts.ch.pojo.User;
import com.usts.ch.result.Result;
import com.usts.ch.result.ResultUtil;
import com.usts.ch.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;


@Controller
public class LoginController {
    @Autowired
    UserService userService;


    @CrossOrigin
    @PostMapping(value = "/api/login")
    @ResponseBody
    public Result login(@RequestBody User requestUser) {
        // 对 html 标签进行转义，防止 XSS 攻击
        String username = requestUser.getUsername();
        username = HtmlUtils.htmlEscape(username);

        User user = userService.get(username,requestUser.getPassword());
        if(null == user){
            return ResultUtil.error(400,"登录失败");
        } else {
            return ResultUtil.success(user);
        }
    }
}
