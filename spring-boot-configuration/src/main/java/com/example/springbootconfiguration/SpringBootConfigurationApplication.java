package com.example.springbootconfiguration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
public class SpringBootConfigurationApplication {

    public static void main(String[] args) {
        // SpringApplication.run(SpringBootConfigurationApplication.class, args);
        SpringApplication application = new SpringApplication(SpringBootConfigurationApplication.class);
        application.setAddCommandLineProperties(false);
        application.run(args);
    }
}
