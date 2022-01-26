package com.candidate.interview.hiringevent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityFilterAutoConfiguration;

@SpringBootApplication(scanBasePackages = {"com.candidate.interview.hiringevent","io.login.client"}
)
public class HiringEventApplication {

	public static void main(String[] args) {
		SpringApplication.run(HiringEventApplication.class, args);
	}

}
