package com.zxm.graduatemanagesystem;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.zxm.graduatemanagesystem.dao")
public class GraduateManageSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(GraduateManageSystemApplication.class, args);
    }

}
