package com.huyang;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.huyang.mapper")
@SpringBootApplication
public class SpringBoot20ShiroApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBoot20ShiroApplication.class, args);
    }

}
