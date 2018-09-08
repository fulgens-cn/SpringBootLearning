package com.example.springbootredis;

import com.example.springbootredis.entity.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    public void setTest() {
        redisTemplate.opsForValue().set("one", "1");

        stringRedisTemplate.opsForValue().set("two", "2");

        redisTemplate.opsForValue().set("user:1", new User(1L, "jack123", "123456789"));

        ExecutorService executorService = Executors.newFixedThreadPool(1000);
        IntStream.range(0, 1000).forEach(i -> {
            executorService.execute(() -> stringRedisTemplate.opsForValue().increment("num", 1));
        });
    }

    @Test
    public void getTest() {
        Object one = redisTemplate.opsForValue().get("one");
        Assert.assertEquals("1", one);

        String two = stringRedisTemplate.opsForValue().get("two");
        Assert.assertEquals("2", two);

        User user = (User) redisTemplate.opsForValue().get("user:1");
        Assert.assertEquals("jack123", user.getUsername());
    }


}
