package com.sam09.spring.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class BeanLifeCycle {
    private static final Logger log = LoggerFactory.getLogger(BeanLifeCycle.class);
    @PostConstruct
    public void customizedInit() {
        log.info("Bean has been initialized through my custom initializer");
        // My initialized codes goes here
    }
    @PreDestroy
    public void customizedDestroy() {
        log.info("Bean has been destroyed through my custom destroyer");
        //My clean-up codes gpes here
    }
}
