package com.example.springbootjdbc.controller;

import com.example.springbootjdbc.pojo.User;
import com.example.springbootjdbc.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final IUserService userService;

    @Autowired
    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @PostMapping("")
    public String saveUser(@RequestBody User user) {
        int count = userService.save(user);
        return count > 0 ? "success" : "fail";
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Integer id) {
        int count = userService.delete(id);
        return count > 0 ? "success" : "fail";
    }

    @PutMapping("/{id}")
    public String updateUser(@PathVariable Integer id, @RequestParam(value = "username", required = true) String username,
                          @RequestParam(value = "password", required = true) String password,
                          @RequestParam(value = "birthday", required = true) String birthday) throws ParseException {
        User updateUser = new User();
        updateUser.setId(id);
        updateUser.setUsername(username);
        updateUser.setPassword(password);
        updateUser.setBirthday(new SimpleDateFormat("yyyy-MM-dd").parse(birthday));
        int count = userService.update(updateUser);
        return count > 0 ? "success" : "fail";
    }

    @GetMapping("")
    public List<User> findList(@RequestParam(value = "page", defaultValue = "1") Integer page,
                               @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        return userService.findList(page, pageSize);
    }

    @GetMapping("{id}")
    public User findById(@PathVariable Integer id) {
        return userService.findById(id);
    }

}
