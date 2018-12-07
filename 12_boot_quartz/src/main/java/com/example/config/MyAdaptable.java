package com.example.config;

import org.quartz.spi.TriggerFiredBundle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.scheduling.quartz.AdaptableJobFactory;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * 解决service注入job异常
 * @Auther: zhangfx
 * @Date: 2018/12/7/ 12:27
 */
@Component("myAdaptable")
public class MyAdaptable extends AdaptableJobFactory {

    @Autowired
    private AutowireCapableBeanFactory autowireCapableBeanFactory;

    @Override
    protected Object createJobInstance(TriggerFiredBundle bundle) throws Exception {
        Object jobInstance = super.createJobInstance(bundle);
        this.autowireCapableBeanFactory.autowireBean(jobInstance);
        return jobInstance;
    }
}
