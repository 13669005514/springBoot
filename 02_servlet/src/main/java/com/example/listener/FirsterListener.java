package com.example.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * @Description:
 * @author: fxzhang
 * @Date: 2018/12/1 15:28
 */
@WebListener
public class FirsterListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("监听器已启动");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("监听器已将结束");
    }
}
