package com.example.springbootmbg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan(basePackages = {"com.example.springbootmbg.mapper"})
public class SpringBootMbgApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootMbgApplication.class, args);
    }

}
