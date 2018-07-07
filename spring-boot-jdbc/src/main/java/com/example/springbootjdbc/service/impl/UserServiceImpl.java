package com.example.springbootjdbc.service.impl;

import com.example.springbootjdbc.dao.IUserDao;
import com.example.springbootjdbc.pojo.User;
import com.example.springbootjdbc.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    private final IUserDao userDao;

    @Autowired
    public UserServiceImpl(IUserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public int save(User user) {
        return userDao.save(user);
    }

    @Override
    public int delete(Integer id) {
        return userDao.delete(id);
    }

    @Override
    public int update(User user) {
        return userDao.update(user);
    }

    @Override
    public User findById(Integer id) {
        return userDao.findById(id);
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public List<User> findList(Integer page, Integer pageSize) {
        return userDao.findList(page, pageSize);
    }
}
