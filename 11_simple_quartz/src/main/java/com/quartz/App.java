package com.quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

/**
 * Hello world!
 *
 */
public class App {

    public static void main( String[] args ) throws SchedulerException {
        //创建quartz所需要的步骤
        //1.创建job任务
        JobDetail job = JobBuilder.newJob(QuartzDemo.class).build();
        /**
         * 2.创建任务调度时间
         * 简单的 trigger 触发时间： 通过 Quartz 提供一个方法来完成简单的重复调用 cron
         * Trigger： 按照 Cron 的表达式来给定触发的时间
         */
        //Trigger trigger = TriggerBuilder.newTrigger().withSchedule(SimpleScheduleBuilder.repeatSecondlyForever()).build();
        Trigger trigger = TriggerBuilder.newTrigger().withSchedule(CronScheduleBuilder.cronSchedule("0/2 * * * * ?")).build();
        //3.创建schedule对象
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
        scheduler.scheduleJob(job,trigger);
        //4.启动调度
        scheduler.start();

    }




}
