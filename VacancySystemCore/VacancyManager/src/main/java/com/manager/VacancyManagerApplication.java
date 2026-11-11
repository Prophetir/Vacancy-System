package com.manager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class VacancyManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(VacancyManagerApplication.class, args);
    }

}
