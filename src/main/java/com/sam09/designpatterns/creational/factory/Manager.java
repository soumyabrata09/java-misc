package com.sam09.designpatterns.creational.factory;

public class Manager extends EmployeeDetails {
    private String name;
    private String type;
    private String experience;

    public Manager(String name, String type, String experience) {
        this.name = name;
        this.type = type;
        this.experience = experience;
    }
    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getType() {
        return this.type;
    }

    @Override
    public String getExperience() {
        return this.experience;
    }
}