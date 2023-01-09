package org.mert;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class AuthMicroservicesApplication {
    public static void main(String[] args) {

        SpringApplication.run(AuthMicroservicesApplication.class);
    }
}