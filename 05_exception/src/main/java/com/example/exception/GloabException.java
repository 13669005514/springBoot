package com.example.exception;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import java.util.Properties;

/**
 * @Description:
 * 全局异常配置(不能返回异常信息)
 * @author: fxzhang
 * @Date: 2018/12/3 21:28
 */
@Configuration
public class GloabException {

//
//    @Bean
//    public SimpleMappingExceptionResolver getException() {
//        SimpleMappingExceptionResolver sr = new SimpleMappingExceptionResolver();
//
//        Properties properties = new Properties();
//        //properties.put("java.lang.NullPointerException","error3");
//
//        sr.setExceptionMappings(properties);
//
//        return sr;
//
//    }



}
