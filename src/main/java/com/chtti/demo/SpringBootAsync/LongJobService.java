package com.chtti.demo.SpringBootAsync;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class LongJobService {
    private static final Logger LOGGER = LoggerFactory.getLogger(LongJobService.class);

    @Async
    public CompletableFuture<String> doLong(int x) throws InterruptedException {
        LOGGER.info("[doLong]start to do long");
        Thread.sleep(x*1500);
        LOGGER.info("[doLong]long job will return");
        return CompletableFuture.completedFuture("abcdefg1234567");
    }

    @Async
    public void doLong2(int y) throws InterruptedException {
        LOGGER.info("do something long");
        Thread.sleep(y*1000);
        LOGGER.info("[doLong2]long job will return");
    }
}
