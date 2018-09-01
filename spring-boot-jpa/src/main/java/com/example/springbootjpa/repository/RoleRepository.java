package com.example.springbootjpa.repository;

import com.example.springbootjpa.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, String> {

    Role findByRoleName(String roleName);

}
