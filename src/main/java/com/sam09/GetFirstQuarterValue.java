package com.sam09;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * Input S -> 2Q24 1Q23 1Q22 3Q21
 * Above input denotes {number}Quarter{year} -> 2Q24 means 2nd quarter of the year 2024
 * 1Q23 -> means 1st quarter of the year 2023
 * Now write a method to find out the lowest years lowest quarter
 * As per the above input, output will be -> 1Q22
 */
public class GetFirstQuarterValue {

    private static final Logger logger = LoggerFactory.getLogger(GetFirstQuarterValue.class);

    public static String getFirstQuarter(String quarterAndYearValues) {
        return sortQuarters(quarterAndYearValues.split(" ")).first();
    }

    private static TreeSet<String> sortQuarters(String[] quarters) {
        TreeSet<String> sortedQuarters = new TreeSet<>((o1, o2) -> {
            int year1 = Integer.parseInt(o1.substring(2));
            int year2 = Integer.parseInt(o2.substring(2));
            int quarter1 = Integer.parseInt(o1.substring(0, 1));
            int quarter2 = Integer.parseInt(o2.substring(0, 1));

            if (year1 != year2) {
                return year1 - year2;
            } else {
                return quarter1 - quarter2;
            }
        });
        sortedQuarters.addAll(Arrays.asList(quarters));
        return sortedQuarters;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Quarters value: \t");
        var quarters = scanner.nextLine();
        logger.info(String.format("First quarter is: %s", getFirstQuarter(quarters)));
    }
}
