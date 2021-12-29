package com.sam09.designpatterns.creational.abstractfactory;

public class PCFactory implements ComputerAbstractFactory{
    private String RAM;
    private String HDD;
    private String Processor;
    private String Graphics;
    private String ProcessorGen;

    public PCFactory(String RAM, String HDD, String processor, String graphics, String processorGen) {
        this.RAM = RAM;
        this.HDD = HDD;
        Processor = processor;
        Graphics = graphics;
        ProcessorGen = processorGen;
    }

    @Override
    public Computer createComputer() {
        return new PC(RAM,HDD,Processor,Graphics,ProcessorGen);
    }
}
