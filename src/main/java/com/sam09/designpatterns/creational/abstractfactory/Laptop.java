package com.sam09.designpatterns.creational.abstractfactory;

public class Laptop implements Computer{
    private String RAM;
    private String HDD;
    private String Processor;
    private String Graphics;
    private String ProcessorGen;

    public Laptop(String RAM, String HDD, String processor, String graphics, String processorGen) {
        this.RAM = RAM;
        this.HDD = HDD;
        Processor = processor;
        Graphics = graphics;
        ProcessorGen = processorGen;
    }

    @Override
    public String getRAM() {
        return this.RAM;
    }

    @Override
    public String getHDD() {
        return this.HDD;
    }

    @Override
    public String getProcessor() {
        return this.Processor;
    }

    @Override
    public String getGraphics() {
        return this.Graphics;
    }

    @Override
    public String getProcessorGen() {
        return this.ProcessorGen;
    }

    @Override
    public String toString() {
        return "[" + this.getProcessor() + "; " + this.getProcessorGen() +"; " + this.getRAM()
                + "; " + this.getHDD() + "; " + this.getGraphics() + "]";
    }
}
