package com.example.controller;

import com.example.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

/**
 * @Description:
 * @Auther: zhangfx
 * @Date: 2018/12/3/ 14:56
 */
@Controller
public class UserController {


    @GetMapping("/add")
    public String addPage(User user) {
        return "add";
    }


    @PostMapping("/user")
    public String insertUser(@Valid User user, BindingResult result) {
       System.out.println(user.toString());
        if (result.hasErrors()) {
            return "add";
        }
       return "ok";
    }

    @GetMapping("/ok")
    public String insertUser2() {
        return "redirect:/ok.html";
    }




}
