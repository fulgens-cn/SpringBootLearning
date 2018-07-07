package com.example.springbootjdbc.dao.impl;

import com.example.springbootjdbc.dao.IUserDao;
import com.example.springbootjdbc.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl implements IUserDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int save(User user) {
        String sql = "INSERT INTO tb_user(username, password, birthday) VALUES(?, ?, ?)";
        return jdbcTemplate.update(sql, user.getUsername(), user.getPassword(), user.getBirthday());
    }

    @Override
    public int delete(Integer id) {
        String sql = "DELETE FROM tb_user WHERE id = ?";
        return jdbcTemplate.update(sql, id);
    }

    @Override
    public int update(User user) {
        String sql = "UPDATE tb_user u SET u.username = ?, u.password = ?, u.birthday = ? WHERE u.id = ?";
        return jdbcTemplate.update(sql, user.getUsername(), user.getPassword(), user.getBirthday(), user.getId());
    }

    @Override
    public User findById(Integer id) {
        String sql = "SELECT * FROM tb_user WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), id);
    }

    @Override
    public List<User> findAll() {
        String sql = "SELECT * FROM tb_user";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class));
    }

    @Override
    public List<User> findList(Integer page, Integer pageSize) {
        String sql = "SELECT * FROM tb_user LIMIT ?, ?";
        Integer offset = (page - 1) * pageSize;
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class), offset, pageSize);
    }

}
