package com.sam09.designpatterns.creational.factory;
/**
 * @author Soumyabrata09
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FactoryPatternMainClazz {
    /**
     *
     * @return slf4j Logger for this class
     */
    public static final Logger getLogger() {
        return LoggerFactory.getLogger(FactoryPatternMainClazz.class);
    }

    public static void main(String arg[]) {
        EmployeeDetails developer= EmployeeFactory.createEmployee("Sam09", EmployeeEnum.DEVELOPER.getType(), "6.2 Years");
        EmployeeDetails manager= EmployeeFactory.createEmployee("Sourav", EmployeeEnum.MANAGER.getType(), "15 Years");
        EmployeeDetails tester= EmployeeFactory.createEmployee("Mainak", EmployeeEnum.TESTER.getType(), "8 Years");

        getLogger().info("Developer Details: " + developer);
        getLogger().info("Developer Details: " + manager);
        getLogger().info("Developer Details: " + tester);
    }
}
