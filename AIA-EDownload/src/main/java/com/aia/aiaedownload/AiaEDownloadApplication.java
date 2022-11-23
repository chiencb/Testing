package com.aia.aiaedownload;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AiaEDownloadApplication {

    public static void main(String[] args) {

        SpringApplication.run(AiaEDownloadApplication.class, args);
        System.out.println("http://localhost:8080/swagger-ui.html");
    }

}
