package com.wyl.jedis.util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @auther yanl.wang
 * @date 2023/3/11
 **/
public class JedisConnectionFactory {
    private static final JedisPool jedisPool;
    static {
        //配置连接池
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setMaxTotal(8);  //最大连接
        poolConfig.setMaxIdle(8);//最多预备
        poolConfig.setMinIdle(0);//最小连接，空闲释放
        poolConfig.setMaxWaitMillis(1000);//最多等待
        jedisPool = new JedisPool(poolConfig,"192.168.83.2",6379,1000);
    }

    public static Jedis getJedis(){
        return jedisPool.getResource();
    }
}
