package com.sam09.Exercises;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CollectionDemo {
    private static final Logger log = LoggerFactory.getLogger(CollectionDemo.class);
    public static void main(String args[]) {
        List<Integer> list = new ArrayList<>(2000000);
//        List<Integer> list = new ArrayList<>(2000000);
        long startTime = System.currentTimeMillis();
        log.info("Start Time: " + startTime);
        for (int i=1; i<=2000000; i++) {
            list.add(i);
        }
        long endTime = System.currentTimeMillis();
        log.info("End Time: " + endTime);
//        log.info("List Data: " + list);
        log.info("Time taken for the process: " + (endTime - startTime)  + "ms");

        /*for ( Integer a : list) {
            list.remove(10);
            log.info("elem: " + a);
        }*/
    }
}
