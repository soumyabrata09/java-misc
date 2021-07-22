package com.logging;

import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@Order( value = Ordered.HIGHEST_PRECEDENCE)
public class LoggerBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        String[] beanNames = beanFactory.getBeanDefinitionNames();
        for (String name : beanNames) {
            Object bean = beanFactory.getBean(name);
            if(bean.getClass().isAnnotationPresent(Loggable.class)){
               try{
                   boolean condition = Arrays.stream(bean.getClass().getDeclaredFields())
                           .anyMatch(e -> e.getName().equalsIgnoreCase("logger"));
                   if (condition){
                      Field field = bean.getClass().getDeclaredField(LoggerEnum.LOGGER.getEnumValue());
                      field.setAccessible(true);
                      field.set(bean,LoggerFactory.getLogger(bean.getClass()));
                   }
               }
               catch (Exception e){
                   e.printStackTrace();
               }
            }
        }
    }
}
