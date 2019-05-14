package com.chtti.demo.SpringBootAsync;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;

@Component
public class MyAsyncRunner implements CommandLineRunner {
    private static final Logger LOGGER = LoggerFactory.getLogger(MyAsyncRunner.class);

    @Autowired
    private LongJobService service;

    @Override
    public void run(String... args) throws Exception {
        LOGGER.info("start MyAsync");
        CompletableFuture<String> result1 = service.doLong(5);
        CompletableFuture<String> result2 = service.doLong(10);
        LOGGER.info("finished MyAsync");
        CompletableFuture.allOf(result1, result2).join(); // 都執行完才繼續
        LOGGER.info("result1={}", result1.get());
        LOGGER.info("result2={}", result2.get());

    }
}
