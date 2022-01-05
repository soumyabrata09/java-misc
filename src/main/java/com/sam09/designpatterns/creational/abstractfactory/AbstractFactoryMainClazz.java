package com.sam09.designpatterns.creational.abstractfactory;
/**
 * @author Soumyabrata09
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AbstractFactoryMainClazz {
    /**
     *
     * @return slf4J logger for this class
     */
    public static final Logger getLogger() {
        return LoggerFactory.getLogger(AbstractFactoryMainClazz.class);
    }
    public static void main(String arg[]) {//String RAM, String HDD, String processor, String graphics, String processorGen
        Computer pc = ComputerFactory.createComputer(
                new PCFactory("16 GB","1 TB", "Intel Core i7 Octa-Core",
                        "Nvidia RTX 3070", "10th Generation")
        );
        Computer laptop = ComputerFactory.createComputer(
                new LaptopFactory("8 GB", "1 TB", "Intel Core i5 Quad-Core",
                        "Nvidia GTX 1660Ti", "11th Generation")
        );

        getLogger().info("PC configs: " + pc);
        getLogger().info("Laptop configs: " + laptop);
    }
}
