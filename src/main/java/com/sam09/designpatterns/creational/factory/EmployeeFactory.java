package com.sam09.designpatterns.creational.factory;

public class EmployeeFactory {
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
                emp = new Tester(name,type,experience);
                break;
            default: throw new RuntimeException("Unknown Employee type");
        }
        return emp;
    }
}
