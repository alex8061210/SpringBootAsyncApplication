package com.chtti.demo.SpringBootAsync;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@SpringBootApplication
@EnableAsync
public class SpringBootAsyncApplication {
	private static final Logger LOGGER = LoggerFactory.getLogger(SpringBootAsyncApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(SpringBootAsyncApplication.class, args);
	}

	@Bean
	public Executor taskExecutor(){
		LOGGER.info("Setup my executor.");
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(5);
		executor.setMaxPoolSize(10);
		executor.setQueueCapacity(500);
		executor.setThreadNamePrefix("chtti");
		executor.initialize();
		return executor;
	}
}
