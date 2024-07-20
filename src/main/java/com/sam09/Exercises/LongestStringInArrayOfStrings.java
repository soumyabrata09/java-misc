package com.sam09.Exercises;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author soumyabrata
 *
 *  Write a program to find longest string in a given array.
 */
public class LongestStringInArrayOfStrings {

    private static final Logger logger = LoggerFactory.getLogger(LongestStringInArrayOfStrings.class);

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Array of strings: \t");
        var inputs = scanner.nextLine();
        logger.info("Longest String: " + findLongestString(inputs.split(" ")));
    }

    private static String findLongestString(String[] inputs) {
        return Arrays.stream(inputs)
                .reduce((word1, word2) -> word1.length() > word2.length() ? word1 : word2)
                .get();
    }

}
