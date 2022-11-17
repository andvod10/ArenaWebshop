package com.arenawebshop.aw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.arenawebshop.aw", "com.arenawebshop.price", "com.arenawebshop.vat"})
public class AwApplication {
    public static void main(String[] args) {
        SpringApplication.run(AwApplication.class, args);
    }
}
