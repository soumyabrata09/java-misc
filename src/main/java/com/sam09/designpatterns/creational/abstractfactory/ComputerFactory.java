package com.sam09.designpatterns.creational.abstractfactory;

/**
 * @author Souyabrata09
 */
public class ComputerFactory {
    /**
     *
     * @param abstractFactory takes available child Factory class reference dynamically
     * @return an Object of the Computer object
     */
    public static Computer createComputer(ComputerAbstractFactory abstractFactory) {
        return  abstractFactory.createComputer();
    }
}
