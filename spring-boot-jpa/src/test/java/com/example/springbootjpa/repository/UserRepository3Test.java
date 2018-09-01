package com.example.springbootjpa.repository;

import com.example.springbootjpa.entity.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepository3Test {

    @Autowired
    private UserRepository3 userRepository;

    @Test
    public void findById() {
        Optional<User> optional = userRepository.findById("40289f0c65674a930165674d54940000");
        Assert.assertNotNull(optional.get());
    }
}