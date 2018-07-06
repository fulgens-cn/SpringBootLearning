package com.example.springbootthymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("/regist")
    public String toRegistPage(Model model) {
        model.addAttribute("title", "用户注册");
        model.addAttribute("msg", "欢迎注册");
        return "regist";
    }

}
