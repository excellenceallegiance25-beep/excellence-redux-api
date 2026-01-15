package com.eapl.excellence;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import javax.annotation.PostConstruct;
import java.util.TimeZone;

@SpringBootApplication
public class ExcellenceApplication extends SpringBootServletInitializer {

    @PostConstruct
    void started() {
        // Set JVM timezone to UTC
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
        System.out.println("Application timezone set to: " + TimeZone.getDefault().getID());
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        // Also set timezone here for WAR deployment
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
        return application.sources(ExcellenceApplication.class);
    }

    public static void main(String[] args) {
        // Set timezone before Spring Boot starts
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
        SpringApplication.run(ExcellenceApplication.class, args);
    }

}