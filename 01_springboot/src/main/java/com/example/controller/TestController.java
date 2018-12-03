package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description:
 * 测试使用springBoot
 * @author: fxzhang
 * @Date: 2018/11/30 20:54
 */
@Controller
public class TestController {

    @RequestMapping("/hello")
    @ResponseBody
    public Map<String, List<Integer>> sayHello() {
        List<Integer> integers = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            integers.add(i);
        }
        HashMap<String, List<Integer>> map2 = new HashMap<>(15);
        map2.put("hello",integers);
        return map2;
    }



}
