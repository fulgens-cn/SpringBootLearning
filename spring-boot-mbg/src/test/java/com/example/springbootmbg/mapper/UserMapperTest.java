package com.example.springbootmbg.mapper;

import com.example.springbootmbg.entity.User;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    private static final Logger logger = LoggerFactory.getLogger(UserMapperTest.class);

    @Test
    public void testInsert() {
        User user = new User();
        user.setId(UUID.randomUUID().toString().replaceAll("-", ""));
        user.setUsername("aaa");
        user.setPassword("123456");
        user.setNickname("aaa");
        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());
        userMapper.insertSelective(user);

        User user2 = new User();
        user2.setId(UUID.randomUUID().toString().replaceAll("-", ""));
        user2.setUsername("bbb");
        user2.setPassword("123456");
        user2.setNickname("bbb");
        user2.setCreateTime(new Date());
        user2.setUpdateTime(new Date());
        userMapper.insertSelective(user2);
    }

    @Test
    public void testPage() {
        PageHelper.startPage(1, 10);
        List<User> userList = userMapper.selectAll();
        PageInfo<User> pageInfo = new PageInfo<>(userList);
        logger.info("pageInfo: {}", pageInfo);
    }

}