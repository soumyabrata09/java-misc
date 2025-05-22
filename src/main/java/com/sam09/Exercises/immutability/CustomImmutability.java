package com.sam09.Exercises.immutability;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
* @author soumyabrata09
 * Details about immutability in Java can be found here
 * see also @see <a href="https://sam09.atlassian.net/wiki/spaces/SAM09HOWTO/pages/589828/Immutable+Class+in+Java">Immutable Class in Java</a>
* */
public final class CustomImmutability {

    private static final Logger log = LoggerFactory.getLogger(CustomImmutability.class);

    private final String name;
    private final int id;
    private final HashMap<String,String> hashMap;

    /**
     * Constructor injection through Deep copy
     * @param name accepts a String value
     * @param id accepts a integer value
     * @param hashMap takes an HashMap object
     * */
    public CustomImmutability(String name, int id, Map<String, String> hashMap) {
        log.info("Performing the Deep Copy of the Objects");
        this.name = name;
        this.id = id;
        HashMap<String,String> temporaryMap = new HashMap<>();
        String mapKey;
        Iterator<String> iterator = hashMap.keySet().iterator();
        while (iterator.hasNext()) {
            mapKey = iterator.next();
            temporaryMap.put(mapKey, hashMap.get(mapKey));
        }
        this.hashMap = temporaryMap;
    }
    /*public CustomImmutability(String name, int id, Map<String, String> hashMap) {
        log.info("Performing the Deep Copy of the Objects");
        this.name = name;
        this.id = id;
        this.hashMap = hashMap;
    }*/

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    /**
     * Assessor getter method for mutable Objects
     * @return a clone of the mutable Object
     * */
    public Map<String, String> getHashMap() {
        return (Map<String, String>) hashMap.clone();
        /*return hashMap;*/
    }

    @Override
    public int hashCode() {
        /*return super.hashCode();*/
        final int prime = 31;
        int result = 1;
        result = prime*result + id;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        /*return super.equals(obj);*/
        if (null == obj)
            return false;
        if (this == obj)
            return true;
        if (getClass() != obj.getClass())
            return false;
        CustomImmutability tempInstance = (CustomImmutability) obj;
        if (id != tempInstance.id)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "[ " + id + ", " + name + " ]";
    }
}
