package com.aia.aiaedownload;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.aia.aiaedownload"})
public class AiaEDownloadApplication {

    public static void main(String[] args) {

        SpringApplication.run(AiaEDownloadApplication.class, args);
        System.out.println("http://localhost:8080/swagger-ui.html");
    }

}
