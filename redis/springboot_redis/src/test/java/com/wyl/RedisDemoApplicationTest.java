package com.wyl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wyl.bean.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.Map;


/**
 * @auther yanl.wang
 * @date 2023/3/11
 **/
@SpringBootTest
public class RedisDemoApplicationTest {

    @Autowired //序列化的是对象，需要加配置类手动处理
    private RedisTemplate<String,Object> redisTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    private static final ObjectMapper mapper = new ObjectMapper();

    @Test
    void testString(){
        //写入一条String数据
        redisTemplate.opsForValue().set("name","张三");
        Object name = redisTemplate.opsForValue().get("name");

        System.out.println("name = " + name);
    }

    @Test
    void testObject(){
        //写入一条String数据
        redisTemplate.opsForValue().set("user:1",new User(18,"李四"));
        User user = (User) redisTemplate.opsForValue().get("user:1");
        System.out.println("user = " + user);
    }

    @Test
    void testObjectSerialize() throws JsonProcessingException {
        //准备对象
        User user = new User(21, "哈哈");
        //手动序列化
        String json = mapper.writeValueAsString(user);
        //写入数据到redis
        stringRedisTemplate.opsForValue().set("user:2",json);
        //读取数据
        String val = stringRedisTemplate.opsForValue().get("user:2");
        //手动反序列化
        User user1 = mapper.readValue(val, User.class);
        System.out.println("user1 = " + user1);
    }

    @Test
    void testHash(){
        stringRedisTemplate.opsForHash().put("user:11","name","zhangsan");
        stringRedisTemplate.opsForHash().put("user:11","age","19");
        Map<Object, Object> entries = stringRedisTemplate.opsForHash().entries("user:11");
        System.out.println("entries = " + entries);
    }
}
