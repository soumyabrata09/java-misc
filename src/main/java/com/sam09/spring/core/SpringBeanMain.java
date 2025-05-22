package com.sam09.spring.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

//@ComponentScan(basePackages = "com.sam09.spring.core")
public class SpringBeanMain {
    private static final Logger log = LoggerFactory.getLogger(SpringBeanMain.class);
    public static void main(String[] args) throws BeansException {
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(SpringBeanLifeCycleConfiguration.class);
        context.getBean("beanLifeCycle");

//        context.refresh();
        context.close();
//        context.registerShutdownHook();
        log.info("Context is running state? " + context.isRunning() + " or active? " + context.isActive());
//        if (context.isRunning())
//            context.close();

    }
}
