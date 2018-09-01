package com.example.springbootjpa.repository;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

import java.util.Optional;

/**
 * 自定义Repository，选择性暴露CRUD方法
 * @param <T>
 * @param <ID>
 */
@NoRepositoryBean
public interface MyBaseRepository<T, ID> extends Repository<T, ID> {

    Optional<T> findById(ID id);

    <S extends T> S save(S entity);

}
