package com.fanle.moka;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.fanle.moka")
public class AdminApplication implements ApplicationRunner {

    public static void main(String[] args) {
        SpringApplication.run(AdminApplication.class, args);
    }


    @Override
    public void run(ApplicationArguments args) throws Exception {


    }
}
