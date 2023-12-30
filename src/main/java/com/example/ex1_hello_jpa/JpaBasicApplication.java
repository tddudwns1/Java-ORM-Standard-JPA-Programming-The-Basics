package com.example.ex1_hello_jpa;

import com.example.ex1_hello_jpa.domain.member.Member;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JpaBasicApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaBasicApplication.class, args);
	}

}
