package com.sam09.designpatterns.creational.abstractfactory;

public class ComputerFactory {
    public static Computer createComputer(ComputerAbstractFactory abstractFactory) {
        return  abstractFactory.createComputer();
    }
}
