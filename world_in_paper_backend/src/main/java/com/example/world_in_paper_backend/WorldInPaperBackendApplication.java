package com.example.world_in_paper_backend;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.example")
@MapperScan
public class WorldInPaperBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(WorldInPaperBackendApplication.class, args);
    }

}
