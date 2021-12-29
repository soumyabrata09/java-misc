package com.sam09.designpatterns.creational.factory;

public enum EmployeeEnum {
    MANAGER("Manager"),DEVELOPER("Developer"),TESTER("Tester");
    private String type;
    EmployeeEnum(String type) {
        this.type = type;
    }
    public String getType() {
        return type;
    }
}
