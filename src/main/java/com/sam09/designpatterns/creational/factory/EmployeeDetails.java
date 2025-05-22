package com.sam09.designpatterns.creational.factory;

/**
 * @author Soumyabrata09
 */
public abstract class EmployeeDetails {
    public abstract String getName();
    public abstract String getType();
    public abstract String getExperience();

    @Override
    public String toString() {
        return "[Name: " + this.getName() + "; Type: " + this.getType() + "; Experience: " + this.getExperience() + "]";
    }
}
