package com.blog.blog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.github.cdimascio.dotenv.Dotenv;

@SpringBootApplication
public class BlogApplication {

	public static void main(String[] args) {
		Dotenv.configure().load();
		
		SpringApplication.run(BlogApplication.class, args);
	}

}
