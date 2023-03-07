package com.example.world_in_paper_backend.utils;


import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * 描述: Jedis工具类（封装了连接池）
 */
public class JedisUtils {

    private static JedisPool jedisPool;

    static {
        // 配置连接池
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(5);
        config.setMaxIdle(3);
        config.setMinIdle(2);

        // 创建连接池
        jedisPool = new JedisPool(config, "117.50.179.215", 8066);
    }

    /**
     * 获取redis连接
     */
    public static Jedis getJedis() {
        Jedis j = jedisPool.getResource();
        j.auth("G3.1415926");
        return j;
    }
}