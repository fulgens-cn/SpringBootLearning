package com.example.springbootmybatis.mapper;

import com.example.springbootmybatis.entity.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class IUserMapperTest {

    @Autowired
    private IUserMapper userMapper;

    private static final Logger logger = LoggerFactory.getLogger(IUserMapperTest.class);

    @Test
    public void insert() {
        User user1 = new User("aaa", "123456");
        userMapper.insert(user1);
        logger.info("插入记录id: {}", user1.getId());
        User user2 = new User("bbb", "123456");
        userMapper.insert(user2);
        logger.info("插入记录id: {}", user2.getId());
        User user3 = new User("ccc", "123456");
        userMapper.insert(user3);
        logger.info("插入记录id: {}", user3.getId());
        User user4 = new User("abc123", "123456");
        userMapper.insert(user4);
        logger.info("插入记录id: {}", user4.getId());
        Assert.assertEquals(4, userMapper.selectAll().size());
    }

    @Test
    public void delete() {
        Integer count = userMapper.delete(10);
        Assert.assertEquals(Integer.valueOf(1), count);
    }

    @Test
    public void update() {
        User updateUser = new User();
        updateUser.setId(15);
        updateUser.setUsername("jerry");
        updateUser.setPassword("jerry123456");
        Integer count = userMapper.update(updateUser);
        Assert.assertEquals(Integer.valueOf(1), count);
    }

    @Test
    public void selectAll() {
        List<User> userList = userMapper.selectAll();
        Assert.assertEquals(4, userList.size());
    }

    @Test
    public void selectList() {
        Integer pageNum = 2;
        Integer pageSize = 2;
        List<User> userList = userMapper.selectList((pageNum - 1) * pageSize, pageSize);
        Assert.assertEquals(2, userList.size());
    }

    @Test
    public void selectById() {
        User user = userMapper.selectById(15);
        Assert.assertEquals("jerry", user.getUsername());
    }

    @Test
    public void selectByUsername() {
        User user = userMapper.selectByUsername("jerry");
        Assert.assertEquals("jerry123456", user.getPassword());
    }

    @Test
    public void selectLike() {
        List<User> userList = userMapper.selectLike("a");
        Assert.assertEquals(2, userList.size());
    }

    @Test
    public void selectByPrimaryKey() {
        User user = userMapper.selectById(15);
        Assert.assertEquals("jerry", user.getUsername());
    }
}