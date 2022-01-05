package com.sam09.Exercises.bitwiseops;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BitwiseOPsMainClazz {
    private static final Logger getLogger() {
        return LoggerFactory.getLogger(BitwiseOPsMainClazz.class);
    }

    public static void main(String args[]) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        int[] extractedValue = new int[2];
        int counter = 0;
        getLogger().info("::This is a demonstration of BitWise operator functionalities::\n");
        System.out.println("Enter two integer values: ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        StringTokenizer tokenizer = new StringTokenizer(input,",");
        while (tokenizer.hasMoreTokens()) {
            extractedValue[counter] = Integer.parseInt(tokenizer.nextToken());
            getLogger().info("Position-"+(counter+1) + " value extracted: " + extractedValue[counter] + "\n");
            counter++;
        }
        BitwiseFunction object = new BitwiseFunction();
        System.out.println("Enter Bitwise Operation type: ");
        String methodName = BitwiseOperands.getBitwiseMethod(scanner.nextLine());
        object.performBitwiseOperation(extractedValue,methodName);
    }
}
