package com.example.exception;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Description:
 * @author: fxzhang
 * @Date: 2018/12/3 21:48
 */
@Configuration
public class CustomizeExcepiton3 implements HandlerExceptionResolver {



    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        ModelAndView mv = new ModelAndView();

        if (e instanceof NullPointerException) {

            mv.setViewName("error4");
        }
        mv.addObject("error",e.getMessage()+"123456");


        return mv;
    }
}
