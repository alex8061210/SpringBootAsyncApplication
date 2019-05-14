package com.chtti.demo.SpringBootAsync;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AsyncDemoRestController {
    private static final Logger LOGGER = LoggerFactory.getLogger(AsyncDemoRestController.class);

    @Autowired
    private LongJobService service;

    @RequestMapping(value = "/hello1")
    public String hello(){
        LOGGER.info("Inside hello1");
        try {
            service.doLong(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        LOGGER.info("hello1 return");
        return "hello1";
    }

    @RequestMapping(value = "/hello2")
    public String hello2(){
        LOGGER.info("Inside hello2");
        try {
            service.doLong2(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        LOGGER.info("hello2 return");
        return "hello2";
    }
}
