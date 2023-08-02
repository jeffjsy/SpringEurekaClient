package com.jeffreysy.microjpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RestController;

@ComponentScan
@SpringBootApplication(scanBasePackages = "com/jeffreysy/microjpa") 
@RestController
@EnableDiscoveryClient
public class JeffreySyComp303Assignment4Application {

	public static void main(String[] args) {
		SpringApplication.run(JeffreySyComp303Assignment4Application.class, args);
		System.out.println("Launching Book service...");
	}

}
