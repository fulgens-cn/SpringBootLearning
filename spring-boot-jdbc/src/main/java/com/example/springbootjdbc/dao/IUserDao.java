package com.example.springbootjdbc.dao;

import com.example.springbootjdbc.pojo.User;

import java.util.List;

public interface IUserDao {

    int save(User user);

    int delete(Integer id);

    int update(User user);

    User findById(Integer id);

    List<User> findAll();

    List<User> findList(Integer page, Integer pageSize);

}
