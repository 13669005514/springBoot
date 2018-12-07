package com.example.config;

import com.example.quartz.QuartzDemo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.scheduling.quartz.SimpleTriggerFactoryBean;

/**
 * @Description:
 * Quartz配置类
 * @Auther: zhangfx
 * @Date: 2018/12/7/ 11:20
 */
@Configuration
public class QuartzConfig  {

    /**
     * 创建job对象  做什么事情
     * @return
     */
    @Bean
    public JobDetailFactoryBean jobDetailFactoryBean() {
        JobDetailFactoryBean factory = new JobDetailFactoryBean();
        factory.setJobClass(QuartzDemo.class);
        return factory;
    }

    /**
     * 创建Trigger对象 什么时候做
     * 第一种 简单调度
     * @param factory
     * @return
     */
    @Bean
    public SimpleTriggerFactoryBean simpleTriggerFactoryBean(JobDetailFactoryBean factory) {
        SimpleTriggerFactoryBean factoryBean = new SimpleTriggerFactoryBean();
        //关联job对象
        factoryBean.setJobDetail(factory.getObject());
        //调度间隔时间
        factoryBean.setRepeatInterval(2000);
        //执行次数
        factoryBean.setRepeatCount(5);
        return factoryBean;
    }
    /**
     * 创建Trigger对象 什么时候做
     * 第二种 表达式调度
     * @param factory
     * @return
     */
    @Bean
    public CronTriggerFactoryBean cronTriggerFactoryBean(JobDetailFactoryBean factory) {
        CronTriggerFactoryBean factoryBean = new CronTriggerFactoryBean();
        //关联job对象
        factoryBean.setJobDetail(factory.getObject());
        //调度间隔时间
        factoryBean.setCronExpression("0/2 * * * * ?");
        return factoryBean;
    }


    /**
     * 创接Scheduler对象
     * @param cronTriggerFactoryBean
     * @return
     */
    @Bean
    public SchedulerFactoryBean schedulerFactoryBean(CronTriggerFactoryBean cronTriggerFactoryBean,MyAdaptable myAdaptable) {
        SchedulerFactoryBean factoryBean = new SchedulerFactoryBean();
        factoryBean.setTriggers(cronTriggerFactoryBean.getObject());
        factoryBean.setJobFactory(myAdaptable);//解决service注入异常
        return factoryBean;
    }



}
