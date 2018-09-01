package com.example.springbootjpa.repository;

import com.example.springbootjpa.entity.Role;
import com.example.springbootjpa.entity.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void getByEmail() {
        User user = userRepository.getByEmail("abc@gmail.com");
        Assert.assertNotNull(user);
    }

    @Test
    public void getByUsernameAndPassword() {
        User user = userRepository.getByUsernameAndPassword("hello123", "123456789");
        Assert.assertNotNull(user);
    }

    @Test
    public void getByUsernameLike() {
        List<User> userList = userRepository.getByUsernameLike("12");
        Assert.assertNotEquals(0, userList.size());
    }

    @Test
    public void getByIdTest() {
        User user = userRepository.getById("40289f0c65674a930165674d54940000");
        Assert.assertNotNull(user);
    }

    @Test
    public void queryByEmailTest() {
        User user = userRepository.queryByEmail("abc@gmail.com");
        Assert.assertNotNull(user);
    }

    @Test
    public void queryByUsernameLikeTest() {
        Page<User> page =
                userRepository.queryByUsernameLike("12", PageRequest.of(0, 5, Sort.by(Sort.Direction.ASC, "username")));
        Assert.assertEquals(page.getContent().size(), 2);
        userRepository.findAll(PageRequest.of(0, 5));
    }

    @Test
    public void updatePasswordByUsernameTest() {
        int count = userRepository.updatePasswordByUsername("abc123", "88888888");
        System.out.println("count:" + count);
        Assert.assertNotEquals(0, count);
    }

    @Test
    public void deleteByUsernameTest() {
        userRepository.deleteByUsername("abc123");
    }

    @Test
    public void findByIdTest() {
        Optional<User> optional = userRepository.findById("40289f0c65674a930165674d54940000");
        Set<Role> roles = optional.get().getRoles();
        System.out.println(optional.get());
    }

    @Test
    public void specificationTest() {
        List<User> userList = userRepository.findAll(new Specification<User>() {
            @Override
            public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.like(root.get("username"), "%123%");
            }
        });
        Assert.assertNotEquals(0, userList.size());
    }

    @Test
    public void queryByExampleTest() {
        User user = new User();
        user.setUsername("fulgens");
        Optional<User> userOptional = userRepository.findOne(Example.of(user));
        System.out.println(userOptional.get());

        long count = userRepository.count(Example.of(user));
        Assert.assertEquals(1, count);

        user.setUsername("123");
        List<User> userList = userRepository.findAll(Example.of(user, ExampleMatcher.matching().withStringMatcher(ExampleMatcher.StringMatcher.ENDING)));
        Assert.assertEquals(1, userList.size());
    }

}