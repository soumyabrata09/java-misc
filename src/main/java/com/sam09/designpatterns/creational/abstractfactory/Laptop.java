package com.sam09.designpatterns.creational.abstractfactory;

/**
 * @author Soumyabrata09
 */
public class Laptop implements Computer{
    private String RAM;
    private String HDD;
    private String Processor;
    private String Graphics;
    private String ProcessorGen;

    /**
     *
     * @param RAM
     * @param HDD
     * @param processor
     * @param graphics
     * @param processorGen
     */
    public Laptop(String RAM, String HDD, String processor, String graphics, String processorGen) {
        this.RAM = RAM;
        this.HDD = HDD;
        Processor = processor;
        Graphics = graphics;
        ProcessorGen = processorGen;
    }

    /**
     *
     * @return RAM parameter's value
     */
    @Override
    public String getRAM() {
        return this.RAM;
    }

    /**
     *
     * @return HDD parameter's value
     */
    @Override
    public String getHDD() {
        return this.HDD;
    }

    /**
     *
     * @return processor parameter's value
     */
    @Override
    public String getProcessor() {
        return this.Processor;
    }

    /**
     *
     * @return Graphics parameter's value
     */
    @Override
    public String getGraphics() {
        return this.Graphics;
    }

    /**
     *
     * @return ProcessorGen parameter's value
     */
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
