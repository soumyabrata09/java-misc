/*
package com.sam09.Exercises.immutability;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

//@FieldDefaults(level = AccessLevel.PRIVATE)
public class CustomImmutabilityTest {

    static String name = "Sam09";
    static int id = 101;

    HashMap<String, String> hashMap;

    public CustomImmutability immutableInstance;

    @BeforeMethod
    public void setup() {
        immutableInstance = new CustomImmutability(name, id, populateMap());
    }

    private Map<String, String> populateMap() {
        hashMap = new HashMap<>();
        hashMap.put("Microsoft", "Satya Nadella");
        hashMap.put("Google", "Sundar Pichai");
        hashMap.put("Apple", "Tim Cook");
        hashMap.put("IBM", "Arvind Krishna");
        return hashMap;
    }


    @Test
    public void testImmutability() {
        assertEquals(id, immutableInstance.getId());
        assertEquals(name, immutableInstance.getName());
        assertEquals(populateMap(), immutableInstance.getHashMap());

        Map<String, String> tempMap = immutableInstance.getHashMap();
        tempMap.put("IBM", "Arvind Krishna");

        name = "Modified Value";
        id = 102;
        assertNotEquals(name, immutableInstance.getName());
        assertNotEquals(id, immutableInstance.getId());
    }

}
*/
