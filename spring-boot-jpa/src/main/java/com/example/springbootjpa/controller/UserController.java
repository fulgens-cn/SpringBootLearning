package com.example.springbootjpa.controller;

import com.example.springbootjpa.common.enums.RoleEnum;
import com.example.springbootjpa.entity.Role;
import com.example.springbootjpa.entity.User;
import com.example.springbootjpa.repository.RoleRepository;
import com.example.springbootjpa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @PostMapping()
    public User saveUser(@RequestBody User user) {
        Role userRole = roleRepository.findByRoleName(RoleEnum.ROLE_USER.getRole());
        /*Set<Role> roles = new HashSet<>();
        roles.add(userRole);
        user.setRoles(roles);*/
        user.getRoles().add(userRole);
        return userRepository.save(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") String userId) {
        userRepository.deleteById(userId);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable("id") String userId, @RequestBody User user) {
        user.setId(userId);
        return userRepository.saveAndFlush(user);
    }

    @GetMapping("/{id}")
    public User getUserInfo(@PathVariable("id") String userId) {
        Optional<User> optional = userRepository.findById(userId);
        Set<Role> roles = optional.get().getRoles();
        return optional.orElseGet(User::new);
    }

    @GetMapping("/list")
    public Page<User> pageQuery(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        return userRepository.findAll(PageRequest.of(pageNum - 1, pageSize));
    }

}
