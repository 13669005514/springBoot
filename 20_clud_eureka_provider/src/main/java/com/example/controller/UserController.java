package com.example.controller;

import com.example.pojo.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @author: fxzhang
 * @Date: 2018/12/15 19:54
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/get")
    public List<User> getUsers() {

        List<User> users = new ArrayList<User>();
        users.add(new User(1,"张三",10));
        users.add(new User(2,"李四",11));
        users.add(new User(3,"王五",12));
        users.add(new User(4,"赵六",13));
        return users;
    }



}
