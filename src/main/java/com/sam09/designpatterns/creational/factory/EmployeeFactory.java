package com.sam09.designpatterns.creational.factory;

/**
 * @author Soumyabrata09
 */
public class EmployeeFactory {
    /**
     *
     * @param name
     * @param type
     * @param experience
     * @return an instance of the type of Object asked for
     */
    public static EmployeeDetails createEmployee(String name, String type, String experience) {
        EmployeeDetails emp;
        switch (type) {
            case "Developer":
                emp = new Developer(name,type,experience);
                break;
            case "Manager":
                emp = new Manager(name,type,experience);
                break;
            case "Tester":
                emp = new Tester(name,type);
                break;
            default: throw new RuntimeException("Unknown Employee type");
        }
        return emp;
    }
}
