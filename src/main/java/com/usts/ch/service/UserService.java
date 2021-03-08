package com.usts.ch.service;

import com.usts.ch.dao.UserDAO;
import com.usts.ch.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//重新二次封装，DAO中定义基础的增删改查，具体的操作由Service来完成
@Service
public class UserService {
    @Autowired
    UserDAO userDAO;

    public User getInfo(int id){
        return userDAO.findById(id);
    }

    public User get(String username,String password){
        return userDAO.getByUsernameAndPassword(username,password);
    }

    public void addOrUpdate(User user){
        userDAO.save(user);
    }
}
