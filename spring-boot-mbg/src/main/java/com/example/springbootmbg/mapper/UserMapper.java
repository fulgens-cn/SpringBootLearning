package com.example.springbootmbg.mapper;

import com.example.springbootmbg.common.MyBaseMapper;
import com.example.springbootmbg.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper extends MyBaseMapper<User> {
}