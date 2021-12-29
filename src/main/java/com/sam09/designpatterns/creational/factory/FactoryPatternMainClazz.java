package com.sam09.designpatterns.creational.factory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FactoryPatternMainClazz {
    public static final Logger getLogger() {
        return LoggerFactory.getLogger(FactoryPatternMainClazz.class);
    }

    public static void main(String arg[]) {
        EmployeeDetails developer= EmployeeFactory.createEmployee("Sam09", "Developer", "6.2 Years");
        EmployeeDetails manager= EmployeeFactory.createEmployee("Sourav", "Manager", "15 Years");
        EmployeeDetails tester= EmployeeFactory.createEmployee("Mainak", "Tester", "8 Years");

        getLogger().info("Developer Details: " + developer);
        getLogger().info("Developer Details: " + manager);
        getLogger().info("Developer Details: " + tester);
    }
}
