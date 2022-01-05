package com.sam09.designpatterns.creational.factory;

/**
 * @author Soumyabrata09
 */
public class Developer extends EmployeeDetails {
    private String name;
    private String type;
    private String experience;

    /**
     *
     * @param name
     * @param type
     * @param experience
     */
    public Developer(String name, String type, String experience) {
        this.name = name;
        this.type = type;
        this.experience = experience;
    }

    /**
     *
     * @return name parameter's value
     */
    @Override
    public String getName() {
        return this.name;
    }

    /**
     *
     * @return type parameter's value
     */
    @Override
    public String getType() {
        return this.type;
    }

    /**
     *
     * @return experience parameter's value
     */
    @Override
    public String getExperience() {
        return this.experience;
    }
}
