package com.sam09.designpatterns.creational.builder;
/**
 * @author Soumyabarata09
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BuilderPatternMainClazz {
    public static final Logger getLogger() {
        return LoggerFactory.getLogger(BuilderPatternMainClazz.class);
    }

    public static void main(String arg[]) {
        Address address1 = new Address("Blue Ridge Township Tower-18, flat-804", "Hinjewadi, phase-1",
                "411057", "Opposite of Accenture");
        Address address2 = new Address("Blue Ridge Township Tower-03, flat-402", "Hinjewadi, phase-1",
                "411057", "Near ICICI Bank");

        UserDetails user1 = new UserDetails.UserDetailsBuilder("Sam09", "Sen")
                .age(31)
                .address(address1)
                .build();
        UserDetails user2 = new UserDetails.UserDetailsBuilder("Venom09", "Sen")
                .age(31)
                .address(address2)
                .build();
        getLogger().info("User1: " + user1);
        getLogger().info("User2: " + user2);
    }
}
