package com.amigoscode;

import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.TimeZone;

@SpringBootApplication
@RestController
public class Application {

    static {
        // Set timezone before anything else happens - this is crucial
        System.setProperty("user.timezone", "UTC");
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
    }

    @PostConstruct
    public void init() {
        // Verify timezone is set correctly
        System.out.println("Application timezone set to: " + TimeZone.getDefault().getID());
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
        // this is a endpoint
        @GetMapping
        public String helloworld(){
          return "Hello World Spring Boot";
        }
}
