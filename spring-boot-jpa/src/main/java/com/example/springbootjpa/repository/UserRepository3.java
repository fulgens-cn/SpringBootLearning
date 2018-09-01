package com.example.springbootjpa.repository;

import com.example.springbootjpa.entity.User;
import org.springframework.data.repository.RepositoryDefinition;

import java.util.Optional;

@RepositoryDefinition(domainClass = User.class, idClass = String.class)
public interface UserRepository3 {

    Optional<User> findById(String id);

    User save(User user);

}
