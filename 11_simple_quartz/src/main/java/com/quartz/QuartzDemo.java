package com.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.Date;

/**
 * @Description:
 * @Auther: zhangfx
 * @Date: 2018/12/7/ 10:20
 */
public class QuartzDemo implements Job {

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {

        System.out.println("测试中:"+new Date());
    }
}
