package com.dmarchante.kiddoh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableAutoConfiguration
@SpringBootApplication
public class KidDohApplication {
    public static void main(String[] args) {
        SpringApplication.run(KidDohApplication.class, args);
    }
}
