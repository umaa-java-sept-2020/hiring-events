package com.candidate.interview.hiringevent.mock;

import com.candidate.interview.hiringevent.config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestRun {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

    }
}
