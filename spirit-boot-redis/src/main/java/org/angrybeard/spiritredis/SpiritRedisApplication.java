package org.angrybeard.spiritredis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Created by angry_beary on 2019/9/8.
 */
@ServletComponentScan
@SpringBootApplication
@EnableScheduling
public class SpiritRedisApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpiritRedisApplication.class, args);
    }

}
