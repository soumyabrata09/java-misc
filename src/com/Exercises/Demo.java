package com.Exercises;

import com.logging.Loggable;
import com.logging.LoggerBeanFactoryPostProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;

import java.util.Arrays;
import java.util.Optional;

/*@Loggable
@Import(LoggerBeanFactoryPostProcessor.class)*/
public class Demo {

    private static final Logger logger = LoggerFactory.getLogger(Demo.class);

    /*public Demo(Logger logger) {
        this.logger = logger;
    }*/

    public static void main(String[] args){
        String[] strValues = new String[]{"abc","bcd","efg","mnp","xyz"};
        Optional<String> collect = Arrays.stream(strValues).filter(
                elem -> elem.equalsIgnoreCase("MnP")
        ).findAny();

        System.out.println("Testing Loggable Annotation");
        if(Arrays.stream(strValues).anyMatch(e -> e.equalsIgnoreCase("mNp")) ){
            logger.info("True");
        }
        else{
            logger.info("False");
        }

    }

}
