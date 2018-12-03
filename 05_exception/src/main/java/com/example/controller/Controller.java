package com.example.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;


/**
 * @Description:
 * @author: fxzhang
 * @Date: 2018/12/3 19:17
 */
@org.springframework.stereotype.Controller
public class Controller {

    @GetMapping("/get")
    public String getException() {
        String word = null;
        int length = word.length();
        return "hello";
    }

    @GetMapping("/get2")
    public String getException2() {
        int i= 10/0;
        return "hello";
    }


}
