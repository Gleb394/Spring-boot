package com.gleb.springbootdemoaug18;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class SpringBootDemoAug18Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootDemoAug18Application.class, args);
    }
}
