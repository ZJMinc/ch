//数据访问对象（Data Access Object）
package com.usts.ch.dao;

import com.usts.ch.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

//继承JpaRepository
public interface UserDAO extends JpaRepository<User,Integer> {
//    使用了JPA无需手动构建SQL语句，只需要按照规范提供方法名字即可实现对数据库的增删改查
//    findByUsername通过username字段查询到对应的行，并返回给User类
//    构建了两个方法，一个通过用户名查询，一个是通过用户名以及密码查询,根据id查询用户信息

    User getByUsernameAndPassword(String username,String password);

    User findById(int id);

    List<User> findByUsername(String username);
}
