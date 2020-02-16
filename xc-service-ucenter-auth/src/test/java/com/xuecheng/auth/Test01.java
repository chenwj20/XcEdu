package com.xuecheng.auth;

import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@SpringBootTest
@RunWith(SpringRunner.class)
public class Test01 {
    @Autowired
    RedisTemplate redisTemplate;
    @Test
    public void test01(){
        //定义key
        String key = "jti:fcbc3dd4-ce72-49d7-96a8-c3c67ce3ef87";
        //定义value
        Map<String,String> map = new HashMap<>();
        map.put("id","001");
        map.put("name","张三");
        String jsonString = JSON.toJSONString(map);
        System.out.println(jsonString);
        redisTemplate.boundValueOps(key).set(jsonString,60, TimeUnit.SECONDS);
        Long expire = redisTemplate.getExpire(key);
        System.out.println("消失时间为："+expire+"秒");
        String s = (String) redisTemplate.opsForValue().get(key);
        System.out.println(s);

    }
}
