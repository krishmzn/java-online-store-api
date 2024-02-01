package com.ozzy.osbourne;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OsbourneApplication {

	public static void main(String[] args) {
		SpringApplication.run(OsbourneApplication.class, args);
		System.out.println("Hi from Osbourne");
	}
}
