package com.fanle.moka;

import com.fanle.moka.respo.stat.MokaStatChannelLogRespo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.fanle.moka.**")
public class DataStatApplication implements ApplicationRunner {

    public static void main(String[] args) {
        SpringApplication.run(DataStatApplication.class, args);
    }

    @Autowired
    private MokaStatChannelLogRespo channelLogRespo ;

    @Override
    public void run(ApplicationArguments args) throws Exception {


    }
}
