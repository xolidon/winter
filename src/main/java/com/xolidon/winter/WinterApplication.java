package com.xolidon.winter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class WinterApplication {

    public static void main(String[] args) {
        SpringApplication.run(WinterApplication.class, args);
    }

}
