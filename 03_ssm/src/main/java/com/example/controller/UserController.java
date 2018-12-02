package com.example.controller;

import com.example.pojo.User;
import com.example.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Description:
 * @author: fxzhang
 * @Date: 2018/12/1 21:04
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping("/select")
    public List<User> getUsers() {

        return userService.selectUsers();
    }

    @PostMapping("/insert")
    public String insertUser(@RequestBody User user) {
        int i = userService.insertUser(user);
        String msg = null;
        if (i < 1) {
            msg = "插入失败";
        } else {
            msg = "插入成功";
        }
        return msg;
    }

    @PostMapping("/update")
    public String updateUser(@RequestBody User user) {
        int i = userService.updateUser(user);
        String msg = null;
        if (i < 1) {
            msg = "修改失败";
        } else {
            msg = "修改成功";
        }
        return msg;
    }

    @PostMapping("/delete")
    public String deleteUser(@RequestParam(name = "id") Integer id) {
        int i = userService.deleteUser(id);
        String msg = null;
        if (i < 1) {
            msg = "删除失败";
        } else {
            msg = "删除成功";
        }
        return msg;
    }



}
