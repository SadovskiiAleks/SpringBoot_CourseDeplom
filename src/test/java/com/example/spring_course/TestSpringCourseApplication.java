package com.example.spring_course;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.TestConfiguration;

@TestConfiguration(proxyBeanMethods = false)
public class TestSpringCourseApplication {

    public static void main(String[] args) {
        SpringApplication.from(SpringCourseApplication::main).with(TestSpringCourseApplication.class).run(args);
    }

}
