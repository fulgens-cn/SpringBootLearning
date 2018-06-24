package com.example.springbootconfiguration.controller;

import com.example.springbootconfiguration.properties.GirlProperties;
import com.example.springbootconfiguration.properties.GirlProperties2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableConfigurationProperties(value = {GirlProperties.class, GirlProperties2.class})
public class GirlController {

    @Value("${com.example.girl.name}")
    private String girlName;

    @Value("${com.example.girl.age}")
    private Integer girlAge;

    @Value("${com.example.girl.cupSize}")
    private String girlCupSize;

    @Value("${com.example.girl.desc}")
    private String girlDesc;

    @GetMapping("/girl")
    public String getGirlInfo() {
        // return "girlName: " + girlName + " girlAge: " + girlAge + " girlCupSize: " + girlCupSize;
        return girlDesc;
    }

    @Autowired
    private GirlProperties girlProperties;

    @Autowired
    private GirlProperties2 girlProperties2;

    @GetMapping("/girl2")
    public GirlProperties getGirlInfo2() {
        return girlProperties;
    }

    @GetMapping("/girl3")
    public GirlProperties2 getGirlInfo3() {
        return girlProperties2;
    }

}
