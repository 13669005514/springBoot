package com.example.config;

import redis.clients.jedis.JedisPoolConfig;

/**
 * @Description:
 * 配置redis
 * @Auther: zhangfx
 * @Date: 2018/12/4/ 17:42
 */
public class RedisConfig {

    public JedisPoolConfig jedisPoolConfig() {
        JedisPoolConfig config = new JedisPoolConfig();
        //最大空闲数
        config.setMaxIdle(10);
        //最小空闲数
        config.setMinIdle(5);
        //最大链接数
        config.setMaxTotal(20);
        return config;

    }

}
