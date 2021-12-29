package com.sam09.designpatterns.creational.abstractfactory;

public class LaptopFactory implements ComputerAbstractFactory{
    private String RAM;
    private String HDD;
    private String Processor;
    private String Graphics;
    private String ProcessorGen;

    public LaptopFactory(String RAM, String HDD, String processor, String graphics, String processorGen) {
        this.RAM = RAM;
        this.HDD = HDD;
        Processor = processor;
        Graphics = graphics;
        ProcessorGen = processorGen;
    }

    @Override
    public Computer createComputer() {
        return new Laptop(RAM,HDD,Processor,Graphics,ProcessorGen);
    }
}
