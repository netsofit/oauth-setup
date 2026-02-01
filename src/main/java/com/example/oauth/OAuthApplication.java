package com.example.oauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.security.Principal;

@SpringBootApplication
@RestController
public class OAuthApplication {

	public static void main(String[] args) {
		SpringApplication.run(OAuthApplication.class, args);
	}

	@GetMapping("/user")
	public String user(Principal principal) {
		return "Hello, " + (principal != null ? principal.getName() : "User") + "! You are logged in.";
	}
}
