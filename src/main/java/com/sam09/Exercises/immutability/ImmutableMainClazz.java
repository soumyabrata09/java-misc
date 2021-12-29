package com.sam09.Exercises.immutability;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class ImmutableMainClazz {

    public static final Logger getLogger() {
        return LoggerFactory.getLogger(ImmutableMainClazz.class);
    }

    enum ORGANIZATION {
        APPL("Apple Inc.", "Tim Cook"),
        IBM("IBM Inc.", "Arvind Krishna"),
        GOOGLE("Google Inc.", "Sundar Pichai"),
        MICROSOFT("Microsoft Inc.", "Satya Nadella");
        private String orgName;
        private String ceo;
        ORGANIZATION(String orgName, String ceo) {
            this.orgName = orgName;
            this.ceo = ceo;
        }
        public String getOrgName() {
            return orgName;
        }
        public String getCeo() {
            return ceo;
        }
    }

    private static Map<String,String> populateMap() {
        Map<String,String> map = new HashMap<>();
        map.put(ORGANIZATION.APPL.getOrgName(), ORGANIZATION.APPL.getCeo());
        map.put(ORGANIZATION.MICROSOFT.getOrgName(), ORGANIZATION.MICROSOFT.getCeo());
        map.put(ORGANIZATION.GOOGLE.getOrgName(), ORGANIZATION.GOOGLE.getCeo());
        return map;
    }

    public static void main(String args[]) {

        String name = "Sam09";
        int id = 101;
        Map<String,String> map = populateMap();
        CustomImmutability immutableInstance = new CustomImmutability(name,id,map);
        //Let's see whether its copy by field or reference
        getLogger().info(String.valueOf(name == immutableInstance.getName()));
        getLogger().info("ID: " + immutableInstance.getId() + "Name: " + immutableInstance.getName());
        getLogger().info(String.valueOf(populateMap() == immutableInstance.getHashMap()));
        getLogger().info("Map Value: " + immutableInstance.getHashMap() +
                " size: " + immutableInstance.getHashMap().size());
        name = "Modified Name";
        id = 102;
        map.put(ORGANIZATION.IBM.getOrgName(), ORGANIZATION.IBM.getCeo());
        getLogger().info("After modification ID: "+immutableInstance.getId() + " Name: " + immutableInstance.getName());
        getLogger().info("After modification Map value: " + immutableInstance.getHashMap() +
                " size: " + immutableInstance.getHashMap().size());
    }
}
