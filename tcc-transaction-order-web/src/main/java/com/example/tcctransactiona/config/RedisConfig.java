package com.example.tcctransactiona.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author: Jindong.Tian
 * @date: 2021-12-05
 **/
@Configuration
public class RedisConfig {

    @Value("${spring.redis.host}")
    private String host;
    @Value("${spring.redis.port}")
    private int port;

    @Bean
    public JedisPool jedisPool() {
        return new JedisPool(new JedisPoolConfig(), host, port, 1000);
    }
}
