package com.example.springbootmybatis.mapper;

import com.example.springbootmybatis.entity.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.jdbc.SQL;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUserMapper {

    User selectByPrimaryKey(Integer id);

    @Insert("INSERT INTO tb_user(username, password, create_time, update_time) VALUES(#{username}, #{password}, now(), now())")
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = Integer.class)
    Integer insert(User user);

    @Delete("DELETE FROM tb_user WHERE id = #{id}")
    Integer delete(Integer id);

    @Update("UPDATE tb_user SET username = #{username}, password = #{password}, update_time = now() WHERE id = #{id}")
    Integer update(User user);

    @Select("SELECT * FROM tb_user")
    @Results(id = "userResult", value = {
            @Result(property = "id", column = "id"),
            @Result(property = "username", column = "username"),
            @Result(property = "password", column = "password"),
            @Result(property = "createTime", column = "create_time"),
            @Result(property = "updateTime", column = "update_time"),
    })
    List<User> selectAll();

    @Select("SELECT * FROM tb_user LIMIT #{offset}, #{rows}")
    List<User> selectList(@Param("offset") Integer offset, @Param("rows") Integer rows);

    @Select("SELECT * FROM tb_user WHERE id = #{id}")
    @ResultMap("userResult")
    User selectById(Integer id);

    @Select("SELECT * FROM tb_user WHERE username = #{username}")
    @ResultMap("userResult")
    User selectByUsername(String username);

    @SelectProvider(type = UserSqlBuilder.class, method = "selectLike")
    List<User> selectLike(String username);

    class UserSqlBuilder {

        public static String selectLike(String username) {
            return new SQL(){{
                SELECT("id", "username", "password", "create_time", "update_time");
                FROM("tb_user");
                if (username != null) {
                    WHERE("username LIKE CONCAT(CONCAT('%', #{username}), '%')");
                }
                ORDER_BY("id");
            }}.toString();
        }

    }

}


