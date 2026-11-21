package com.andersonmesq.identifyservice;

import org.springframework.boot.SpringApplication;

public class TestTorqueDeskApplication {

	public static void main(String[] args) {
		SpringApplication.from(IdentityApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
