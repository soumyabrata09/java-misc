package com.sam09.spring.core;

import org.springframework.aop.scope.DefaultScopedObject;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Configuration
public class SpringBeanLifeCycleConfiguration {

    @Bean("beanLifeCycle")
    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
    public BeanLifeCycle getBeanOf() {
        return new BeanLifeCycle();
    }
}
