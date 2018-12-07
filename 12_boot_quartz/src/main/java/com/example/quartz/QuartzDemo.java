package com.example.quartz;

import com.example.service.UserService;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * @Description:
 * @Auther: zhangfx
 * @Date: 2018/12/7/ 11:21
 */
public class QuartzDemo implements Job {

    @Autowired
    private UserService userService;

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("exce----"+new Date());
        this.userService.print();
    }
}
