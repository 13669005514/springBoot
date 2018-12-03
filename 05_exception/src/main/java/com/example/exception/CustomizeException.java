package com.example.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Description:
 * @author: fxzhang
 * @Date: 2018/12/3 21:13
 */
@ControllerAdvice
public class CustomizeException {
    /**
     * 自定义异常
     * @param e
     * @return 自定义异常界面
     */
    @ExceptionHandler(value = {java.lang.ArithmeticException.class})
    public ModelAndView showNullException(Exception e) {

        ModelAndView mv = new ModelAndView();
        mv.addObject("error",e.toString());
        mv.setViewName("error2");
        return mv;
    }

}
