/*
package com.sam09.Exercises.immutability;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class CustomImmutabilityTest {

    private static final Logger log = LoggerFactory.getLogger(CustomImmutabilityTest.class);
    */
/*private HashMap<String,String> hashMap;*//*

    private String name = "Sam09";
    private int id = 101;
    CustomImmutability immutableInstance;

    @Before
    public void setUp() throws Exception {
        immutableInstance = new CustomImmutability(name,id, populateMap());
    }

    private Map<String,String> populateMap() {
        Map<String,String> hashMap = new HashMap<>();
        hashMap.put("Microsoft", "Satya Nadella");
        hashMap.put("Google", "Sundar Pichai");
        hashMap.put("Apple", "Tim Cook");
        */
/*hashMap.put("IBM", "Arvind Krishna");*//*

        return hashMap;
    }

    @Test
    public void testImmutability() {
        log.info("id: " + immutableInstance.getId() +  "\nname: " + immutableInstance.getName() + "\nHashMap: " + immutableInstance.getHashMap());

        assertEquals(id, immutableInstance.getId());
        assertEquals(name, immutableInstance.getName());
        assertEquals(populateMap(),immutableInstance.getHashMap());

        Map<String,String> tempMap = immutableInstance.getHashMap();
        log.info("HashMap Size: " + tempMap.size());
        tempMap.put("IBM", "Arvind Krishna");

        name = "Modified Value";
        id = 102;
        log.info("After modification-> id: " + immutableInstance.getId() +  "\nname: " + immutableInstance.getName() + "\nHashMap: " + immutableInstance.getHashMap());
        log.info("HashMap Size after putting new value: " + tempMap.size());
        assertNotEquals(name, immutableInstance.getName());
        assertNotEquals(id, immutableInstance.getId());
    }
}*/
