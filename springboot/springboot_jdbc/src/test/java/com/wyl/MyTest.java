package com.wyl;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;



/**
 * @auther yanl.wang
 * @date 2023/3/1
 **/
@Slf4j
@SpringBootTest
public class MyTest {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    DataSource dataSource;

    @Autowired
    StringRedisTemplate redisTemplate;

    @Test
    public void test01(){
//        jdbcTemplate.queryForList("select * from tb_user");
        Long aLong = jdbcTemplate.queryForObject("select count(*) from tb_user", Long.class);
        System.out.println("along:"+aLong);
        System.out.println(dataSource.getClass());
    }

    @Test
    public void test02(){
        ValueOperations<String, String> opsForValue = redisTemplate.opsForValue();
        opsForValue.set("hello","world");
        String hello = opsForValue.get("hello");
        System.out.println(hello);
    }
}
