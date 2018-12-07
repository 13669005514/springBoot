package com.example.scheduled;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @Description:
 * @Auther: zhangfx
 * @Date: 2018/12/7/ 09:34
 */
@Component
public class ScheduledDemo {

    /**
     * 定时任务方法
     * @Scheduled:设置定时任务
     * cron 属性： cron 表达式。 定时任务触发是时间的一个字符串表达形式
     */
    @Scheduled(cron = "0/2 * * * * ?")
    public void print() {
        Date date = new Date();
        System.out.println("哈哈哈"+date);
    }

}
