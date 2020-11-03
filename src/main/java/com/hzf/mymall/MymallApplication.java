package com.hzf.mymall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.oas.annotations.EnableOpenApi;

@EnableOpenApi
@SpringBootApplication(scanBasePackages = "com.hzf.mymall")
public class MymallApplication {

    public static void main(String[] args) {
        SpringApplication.run(MymallApplication.class, args);
    }

}
